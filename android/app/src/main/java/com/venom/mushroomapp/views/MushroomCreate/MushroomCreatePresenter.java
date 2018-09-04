package com.venom.mushroomapp.views.MushroomCreate;


import com.venom.mushroomapp.async.base.SchedulerProvider;
import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.services.base.MushroomsService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MushroomCreatePresenter implements MushroomCreateContracts.Presenter {

    private final MushroomsService mMushroomsService;
    private final SchedulerProvider mSchedulerProvider;
    private MushroomCreateContracts.View mView;

    @Inject
    public MushroomCreatePresenter(
            MushroomsService MushroomsService,
            SchedulerProvider schedulerProvider) {
        mMushroomsService = MushroomsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(MushroomCreateContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void save(Mushroom Mushroom) {
        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Mushroom>) emitter -> {
                    Mushroom createdMushroom = mMushroomsService.createMushroom(Mushroom);
                    emitter.onNext(createdMushroom);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnEach(x -> mView.hideLoading())
                .doOnError(mView::showError)
                .subscribe(s -> mView.navigateToHome());
    }
}
