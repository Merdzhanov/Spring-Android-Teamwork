package com.venom.mushroomapp.models;

import java.io.Serializable;

public class Mushroom implements Serializable {
    public String imageUrl;
    public int id;
    public String name;
    public String secretIdentity;

    public Mushroom() {
        // public constructor is needed for parsing from/to JSON to work
    }

    public Mushroom(String name, String secretIdentity, String imageUrl) {
        this.name = name;
        this.secretIdentity = secretIdentity;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
