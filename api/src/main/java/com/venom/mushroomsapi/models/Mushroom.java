package com.venom.mushroomsapi.models;

import com.venom.mushroomsapi.models.base.ModelBase;

public class Mushroom extends ModelBase {
    public String imageUrl;
    private String name;
    private String secretIdentity;

    public Mushroom() {

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


    public String getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
