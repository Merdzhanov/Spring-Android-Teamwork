package com.venom.mushroomsapi.repositories.base;



import com.venom.mushroomsapi.models.base.ModelBase;

import java.util.List;

public interface GenericRepository<T extends ModelBase> {
    List<T> findAll();

    T findById(int id);

    void add(T mushroom);
}
