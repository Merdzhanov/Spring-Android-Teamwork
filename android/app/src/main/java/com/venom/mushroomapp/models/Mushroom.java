package com.venom.mushroomapp.models;

import java.io.Serializable;

public class Mushroom implements Serializable {
    public String imageUrl;
    public int id;
    public String name;
    public String description;

    public Mushroom() {
        // public constructor is needed for parsing from/to JSON to work
    }

    public Mushroom(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
