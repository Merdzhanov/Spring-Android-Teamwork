package com.venom.mushroomsapi.services.base;

import com.venom.mushroomsapi.models.Mushroom;

import java.util.List;

public interface MushroomsService {
    List<Mushroom> getAllMushrooms();

    Mushroom findMushroomById(int id);

    Mushroom create(Mushroom mushroom);
}
