package com.venom.mushroomapp.views.MushroomsList;


import com.venom.mushroomapp.async.base.SchedulerProvider;
import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.services.base.MushroomsService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MushroomsListPresenter
        implements MushroomsListContracts.Presenter {

    private final MushroomsService mMushroomsService;
    private final SchedulerProvider mSchedulerProvider;
    private MushroomsListContracts.View mView;

    @Inject
    public MushroomsListPresenter(
            MushroomsService MushroomsService,
            SchedulerProvider schedulerProvider) {
        mMushroomsService = MushroomsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    // same as // setView(MushroomsListContracts.View view)
    public void subscribe(MushroomsListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadMushrooms() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Mushroom>>) emitter -> {
                    List<Mushroom> Mushrooms = mMushroomsService.getAllMushrooms();
                    emitter.onNext(Mushrooms);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                        this::presentMushroomsToView,
                        error -> mView.showError(error)
                );
    }

    @Override
    public void filterMushrooms(String pattern) {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Mushroom>>) emitter -> {
                    List<Mushroom> Mushrooms = mMushroomsService.getFilteredMushrooms(pattern);
                    emitter.onNext(Mushrooms);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(error -> mView.showError(error))
                .doFinally(mView::hideLoading)
                .subscribe(this::presentMushroomsToView);
    }

    @Override
    public void selectMushroom(Mushroom Mushroom) {
        mView.showMushroomDetails(Mushroom);
    }

    private void presentMushroomsToView(List<Mushroom> Mushrooms) {
        if (Mushrooms.isEmpty()) {
            mView.showEmptyMushroomsList();
        } else {
            mView.showMushrooms(Mushrooms);
        }
    }
}
