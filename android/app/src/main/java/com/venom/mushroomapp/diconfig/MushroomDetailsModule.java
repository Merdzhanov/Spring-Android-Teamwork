package com.venom.mushroomapp.diconfig;


import com.venom.mushroomapp.views.MushroomDetails.MushroomDetailsContracts;
import com.venom.mushroomapp.views.MushroomDetails.MushroomDetailsFragment;
import com.venom.mushroomapp.views.MushroomDetails.MushroomDetailsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class MushroomDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MushroomDetailsFragment MushroomDetailsFragment();

    @ActivityScoped
    @Binds
    abstract MushroomDetailsContracts.Presenter MushroomsListPresenter(MushroomDetailsPresenter presenter);
}