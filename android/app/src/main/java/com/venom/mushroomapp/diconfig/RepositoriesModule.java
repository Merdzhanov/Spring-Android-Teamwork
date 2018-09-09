package com.venom.mushroomapp.diconfig;


import com.venom.mushroomapp.http.HttpRequester;
import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.parsers.base.JsonParser;
import com.venom.mushroomapp.repositories.HttpRepository;
import com.venom.mushroomapp.repositories.InMemoryRepository;
import com.venom.mushroomapp.repositories.base.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
//    @Provides
//    @Singleton
//    public Repository<Mushroom> MushroomRepository() {
//        Repository<Mushroom> repository = new InMemoryRepository<>();
//        List<Mushroom> initialMushrooms = Arrays.asList(
//                new Mushroom("Boletus edulis Bull.", "Обикновена манатарка", "http://manatarka.org/files/2011/12/Boletusedulis4.jpg"),
//                new Mushroom("Алпийска чашка", "Microstoma protractum (Fr.) Kanouse", "http://manatarka.org/files/2016/03/Microstomaprotractum1.jpg"),
//                new Mushroom("Виолетов вълчи зъб", "Inocybe geophylla (Bull.) P. Kumm.", "http://manatarka.org/files/2018/05/Inocybegeophylla7.jpg")
//        );
//
//        initialMushrooms.forEach(s -> {
//            try {
//                repository.add(s);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//
//        return repository;
//    }

    @Provides
    @Singleton
    public Repository<Mushroom> MushroomRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<Mushroom> jsonParser
    ) {
        String url = baseServerUrl + "/Mushrooms";
        return new HttpRepository<>(url, httpRequester, jsonParser);
    }
}
