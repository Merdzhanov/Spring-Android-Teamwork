package com.venom.mushroomapp.views.MushroomDetails;


import com.venom.mushroomapp.async.base.SchedulerProvider;
import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.services.base.MushroomsService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MushroomDetailsPresenter
        implements MushroomDetailsContracts.Presenter {
    private final MushroomsService mMushroomsService;
    private final SchedulerProvider mSchedulerProvider;

    private MushroomDetailsContracts.View mView;
    private int mMushroomId;

    @Inject
    public MushroomDetailsPresenter(
            MushroomsService mushroomsService,
            SchedulerProvider schedulerProvider
    ) {
        mMushroomsService = mushroomsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(MushroomDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadMushroom() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Mushroom>) emitter -> {
                    Mushroom mushroom = mMushroomsService.getDetailsById(mMushroomId);
                    emitter.onNext(mushroom);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showMushroom);
    }

    @Override
    public void setMushroomId(int mushroomId) {
        mMushroomId = mushroomId;
    }
}
