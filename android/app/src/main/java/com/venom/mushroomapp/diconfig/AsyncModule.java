package com.venom.mushroomapp.diconfig;


import com.venom.mushroomapp.async.AsyncSchedulerProvider;
import com.venom.mushroomapp.async.base.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public SchedulerProvider schedulerProvider() {
        return AsyncSchedulerProvider.getInstance();
    }
}
