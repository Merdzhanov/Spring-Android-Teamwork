package com.venom.mushroomsapi.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelsConfiguration {
    @Bean
    public Class<Mushroom> provideMushroomClass() {
        return Mushroom.class;
    }
}
