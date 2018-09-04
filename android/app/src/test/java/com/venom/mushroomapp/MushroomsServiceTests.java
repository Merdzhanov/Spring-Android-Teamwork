package com.venom.mushroomapp;


import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.repositories.base.Repository;
import com.venom.mushroomapp.services.HttpMushroomsService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MushroomsServiceTests {
    @Mock
    Repository<Mushroom> mockRepository;

    @Test
    public void presenterLoadMushrooms_whenMushrooms_expectViewShowMushrooms() throws IOException {
        // Arrange
        List<Mushroom> Mushrooms = Arrays.asList(
                new Mushroom("Suoerherp 1", "Identity 1", ""),
                new Mushroom("Suoerherp 2", "Identity 2", ""),
                new Mushroom("Suoerherp 3", "Identity 3", "")
        );

        when(mockRepository.getAll())
                .thenReturn(Mushrooms);

        HttpMushroomsService service = new HttpMushroomsService(mockRepository);

        // Act
        List<Mushroom> returnedMushrooms = service.getAllMushrooms();

        // Assert
        Assert.assertArrayEquals(
                Mushrooms.toArray(),
                returnedMushrooms.toArray()
        );
    }

    @Test
    public void presenterLoadMushrooms_whenNoMushrooms_expectViewShowMushrooms() throws IOException {
        // Arrange
        List<Mushroom> Mushrooms = Collections.emptyList();

        when(mockRepository.getAll())
                .thenReturn(Mushrooms);

        HttpMushroomsService service = new HttpMushroomsService(mockRepository);

        // Act
        List<Mushroom> returnedMushrooms = service.getAllMushrooms();

        // Assert
        Assert.assertArrayEquals(
                Mushrooms.toArray(),
                returnedMushrooms.toArray()
        );
    }


//    @Test
//    public void test2() throws IOException {
//        List<Mushroom> toMatch = Arrays.asList(
//                new Mushroom("FILTERED", "FILTERED"),
//                new Mushroom("FILTERED 2", "FILTERED 2"),
//                new Mushroom("FILTERED", "asd")
//        );
//
//        List<Mushroom> notToMatch = Arrays.asList(
//                new Mushroom("Suoerherp 1", "Identity 1"),
//                new Mushroom("Suoerherp 2", "Identity 2"),
//                new Mushroom("Suoerherp 3", "Identity 3")
//        );
//
//        List<Mushroom> Mushrooms = new ArrayList<>();
//        Mushrooms.addAll(toMatch);
//        Mushrooms.addAll(notToMatch);
//
//        when(mockRepository.getAll())
//                .thenReturn(Mushrooms);
//
//        HttpMushroomsService service = new HttpMushroomsService(mockRepository);
//
//        List<Mushroom> returnedMushrooms = service.getFilteredMushrooms("filtered");
//
//        Assert.assertArrayEquals(
//                toMatch.toArray(),
//                returnedMushrooms.toArray()
//        );
//    }
}
