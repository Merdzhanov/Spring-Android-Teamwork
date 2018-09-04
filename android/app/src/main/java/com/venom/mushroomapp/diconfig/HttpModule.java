package com.venom.mushroomapp.diconfig;


import com.venom.mushroomapp.Constants;
import com.venom.mushroomapp.http.HttpRequester;
import com.venom.mushroomapp.http.OkHttpHttpRequester;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {
    @Provides
    public HttpRequester httpRequester() {
        return new OkHttpHttpRequester();
    }

    @Provides
    @Named("baseServerUrl")
    public String baseServerUrl() {
        return Constants.BASE_SERVER_URL;
    }
}
