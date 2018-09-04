package com.venom.mushroomsapi.services;


import com.venom.mushroomsapi.models.Mushroom;
import com.venom.mushroomsapi.repositories.base.GenericRepository;
import com.venom.mushroomsapi.services.base.MushroomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MushroomsServiceImpl implements MushroomsService {

    private final GenericRepository<Mushroom> mushroomRepository;

    @Autowired
    public MushroomsServiceImpl(GenericRepository<Mushroom> superheroRepository) {
        this.mushroomRepository = superheroRepository;
    }

    @Override
    public List<Mushroom> getAllMushrooms() {
        return this.mushroomRepository.findAll();
    }

    @Override
    public Mushroom findMushroomById(int id) {
        return this.mushroomRepository.findById(id);
    }

    @Override
    public Mushroom create(Mushroom mushroom) {
        mushroomRepository.add(mushroom);
        return mushroom;
    }
}
