package com.venom.mushroomapp.diconfig;


import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.repositories.InMemoryRepository;
import com.venom.mushroomapp.repositories.base.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    public Repository<Mushroom> MushroomRepository() {
        Repository<Mushroom> repository = new InMemoryRepository<>();
        List<Mushroom> initialMushrooms = Arrays.asList(
                new Mushroom("Boletus edulis Bull.", "Обикновена манатарка", "http://manatarka.org/files/2011/12/Boletusedulis4.jpg"),
                new Mushroom("Алпийска чашка", "Microstoma protractum (Fr.) Kanouse", "http://manatarka.org/files/2016/03/Microstomaprotractum1.jpg"),
                new Mushroom("Виолетов вълчи зъб", "Inocybe geophylla (Bull.) P. Kumm.", "http://manatarka.org/files/2018/05/Inocybegeophylla7.jpg")
//                new Mushroom("Batman", "Bruce Wayne", "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png"),
//                new Mushroom("Wonder woman", "Diana Prince", "https://upload.wikimedia.org/wikipedia/en/thumb/9/93/Wonder_Woman.jpg/250px-Wonder_Woman.jpg"),
//                new Mushroom("The Flash", "Barry Alan", "https://upload.wikimedia.org/wikipedia/en/thumb/2/29/Barry_Allen_Flash_Vol_4_30.png/250px-Barry_Allen_Flash_Vol_4_30.png"),
//                new Mushroom("Batman", "Bruce Wayne", "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png"),
//                new Mushroom("Wonder woman", "Diana Prince", "https://upload.wikimedia.org/wikipedia/en/thumb/9/93/Wonder_Woman.jpg/250px-Wonder_Woman.jpg"),
//                new Mushroom("The Flash", "Barry Alan", "https://upload.wikimedia.org/wikipedia/en/thumb/2/29/Barry_Allen_Flash_Vol_4_30.png/250px-Barry_Allen_Flash_Vol_4_30.png"),
//                new Mushroom("Batman", "Bruce Wayne", "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png"),
//                new Mushroom("Wonder woman", "Diana Prince", "https://upload.wikimedia.org/wikipedia/en/thumb/9/93/Wonder_Woman.jpg/250px-Wonder_Woman.jpg"),
//                new Mushroom("The Flash", "Barry Alan", "https://upload.wikimedia.org/wikipedia/en/thumb/2/29/Barry_Allen_Flash_Vol_4_30.png/250px-Barry_Allen_Flash_Vol_4_30.png")
        );

        initialMushrooms.forEach(s -> {
            try {
                repository.add(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return repository;
    }

//    @Provides
//    @Singleton
//    public Repository<Mushroom> MushroomRepository(
//            @Named("baseServerUrl") String baseServerUrl,
//            HttpRequester httpRequester,
//            JsonParser<Mushroom> jsonParser
//    ) {
//        String url = baseServerUrl + "/Mushrooms";
//        return new HttpRepository<>(url, httpRequester, jsonParser);
//    }

//    @Provides
//    public Repository<Power> MushroomRepository() {
//        return new InMemoryRepository<>();
//    }
}
