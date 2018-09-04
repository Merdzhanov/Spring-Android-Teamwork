package com.venom.mushroomapp.diconfig;

import com.venom.mushroomapp.views.MushroomCreate.MushroomCreatePresenter;
import com.venom.mushroomapp.views.MushroomCreate.MushroomCreateContracts;
import com.venom.mushroomapp.views.MushroomCreate.MushroomCreateFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MushroomCreateModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MushroomCreateFragment MushroomCreateFragment();

    @ActivityScoped
    @Binds
    abstract MushroomCreateContracts.Presenter MushroomCreatePresenter(MushroomCreatePresenter presenter);
}

