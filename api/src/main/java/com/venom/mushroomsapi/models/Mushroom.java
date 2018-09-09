package com.venom.mushroomsapi.models;

import com.venom.mushroomsapi.models.base.ModelBase;

public class Mushroom extends ModelBase {
    public String imageUrl;
    private String name;
    private String description;

    public Mushroom() {

    }
    public Mushroom(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }
    public Mushroom(int id, String name, String description, String imageUrl) {
        this.setId(id);
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


    public String getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
