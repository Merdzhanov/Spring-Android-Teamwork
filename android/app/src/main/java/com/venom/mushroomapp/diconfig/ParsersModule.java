package com.venom.mushroomapp.diconfig;


import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.parsers.GsonJsonParser;
import com.venom.mushroomapp.parsers.base.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<Mushroom> MushroomJsonParser() {
        return new GsonJsonParser<>(Mushroom.class, Mushroom[].class);
    }
}
