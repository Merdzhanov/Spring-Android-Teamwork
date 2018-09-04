package com.venom.mushroomapp.diconfig;


import com.venom.mushroomapp.views.MushroomCreate.MushroomCreateActivity;
import com.venom.mushroomapp.views.MushroomDetails.MushroomDetailsActivity;
import com.venom.mushroomapp.views.MushroomsList.MushroomsListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
            modules = MushroomsListModule.class
    )
    abstract MushroomsListActivity MushroomsListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = MushroomDetailsModule.class
    )
    abstract MushroomDetailsActivity MushroomDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = MushroomCreateModule.class
    )
    abstract MushroomCreateActivity MushroomCreateActivity();
}