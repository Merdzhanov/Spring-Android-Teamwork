package com.venom.mushroomapp.diconfig;


import com.venom.mushroomapp.views.MushroomsList.MushroomsListContracts;
import com.venom.mushroomapp.views.MushroomsList.MushroomsListFragment;
import com.venom.mushroomapp.views.MushroomsList.MushroomsListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MushroomsListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MushroomsListFragment MushroomsListFragment();

    @ActivityScoped
    @Binds
    abstract MushroomsListContracts.Presenter MushroomsListPresenter(MushroomsListPresenter presenter);
}
