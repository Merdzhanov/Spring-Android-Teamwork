package com.venom.mushroomapp.diconfig;


import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.repositories.base.Repository;
import com.venom.mushroomapp.services.HttpMushroomsService;
import com.venom.mushroomapp.services.base.MushroomsService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public MushroomsService MushroomsService(Repository<Mushroom> repository) {
        return new HttpMushroomsService(repository);
    }
}
