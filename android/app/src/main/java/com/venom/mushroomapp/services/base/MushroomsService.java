package com.venom.mushroomapp.services.base;


import com.venom.mushroomapp.models.Mushroom;

import java.io.IOException;
import java.util.List;

public interface MushroomsService {
    List<Mushroom> getAllMushrooms() throws IOException;

    Mushroom getDetailsById(int id) throws IOException;

    List<Mushroom> getFilteredMushrooms(String pattern) throws IOException;

    Mushroom createMushroom(Mushroom mushroom) throws IOException;
}
