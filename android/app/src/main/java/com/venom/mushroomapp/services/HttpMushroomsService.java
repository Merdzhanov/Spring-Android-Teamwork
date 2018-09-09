package com.venom.mushroomapp.services;


import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.repositories.base.Repository;
import com.venom.mushroomapp.services.base.MushroomsService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HttpMushroomsService implements MushroomsService {
    private final Repository<Mushroom> mMushroomsRepository;

    public HttpMushroomsService(Repository<Mushroom> mushroomRepository) {
        mMushroomsRepository = mushroomRepository;
    }

    @Override
    public List<Mushroom> getAllMushrooms() throws IOException {
        return mMushroomsRepository.getAll();
    }

    @Override
    public Mushroom getDetailsById(int id) throws IOException {
        return mMushroomsRepository.getById(id);
    }

    @Override
    public List<Mushroom> getFilteredMushrooms(String pattern) throws IOException {
        String patternToLower = pattern.toLowerCase();

        return getAllMushrooms().stream()
                .filter(mushroom -> mushroom.getName().toLowerCase().contains(patternToLower))
                .collect(Collectors.toList());
    }

    @Override
    public Mushroom createMushroom(Mushroom mushroom) throws IOException {
        return mMushroomsRepository.add(mushroom);
    }
}
