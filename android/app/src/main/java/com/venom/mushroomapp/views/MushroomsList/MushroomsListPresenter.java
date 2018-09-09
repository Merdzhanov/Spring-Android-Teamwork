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
            MushroomsService mushroomsService,
            SchedulerProvider schedulerProvider) {
        mMushroomsService = mushroomsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(MushroomsListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadMushrooms() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Mushroom>>) emitter -> {
                    List<Mushroom> mushrooms = mMushroomsService.getAllMushrooms();
                    emitter.onNext(mushrooms);
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
                    List<Mushroom> mushrooms = mMushroomsService.getFilteredMushrooms(pattern);
                    emitter.onNext(mushrooms);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(error -> mView.showError(error))
                .doFinally(mView::hideLoading)
                .subscribe(this::presentMushroomsToView);
    }

    @Override
    public void selectMushroom(Mushroom mushroom) {
        mView.showMushroomDetails(mushroom);
    }

    private void presentMushroomsToView(List<Mushroom> mushrooms) {
        if (mushrooms.isEmpty()) {
            mView.showEmptyMushroomsList();
        } else {
            mView.showMushrooms(mushrooms);
        }
    }
}
