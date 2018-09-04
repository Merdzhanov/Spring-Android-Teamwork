package com.venom.mushroomapp.views.MushroomsList;


import com.venom.mushroomapp.async.SyncSchedulerProvider;
import com.venom.mushroomapp.async.base.SchedulerProvider;
import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.services.base.MushroomsService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTests {
    @Mock
    MushroomsService mockService;

    @Mock
    MushroomsListContracts.View mockView;

    SchedulerProvider schedulerProvider = new SyncSchedulerProvider();

    @Test
    public void presenterLoadMushrooms_whenMushrooms_expectViewShowMushrooms() throws IOException {
        List<Mushroom> MushroomList = Arrays.asList(
                new Mushroom(),
                new Mushroom(),
                new Mushroom(),
                new Mushroom()
        );

        when(mockService.getAllMushrooms())
                .thenReturn(MushroomList);

        MushroomsListPresenter presenter = new MushroomsListPresenter(mockService, schedulerProvider);
        presenter.subscribe(mockView);

        presenter.loadMushrooms();

        verify(mockView).showMushrooms(MushroomList);
    }

    @Test
    public void presenterLoadMushrooms_whenNoMushrooms_expectViewShowEmptyMushrooms() throws IOException {
        List<Mushroom> MushroomList = Collections.emptyList();

        when(mockService.getAllMushrooms())
                .thenReturn(MushroomList);

        MushroomsListPresenter presenter = new MushroomsListPresenter(mockService, schedulerProvider);
        presenter.subscribe(mockView);

        presenter.loadMushrooms();

        verify(mockView).showEmptyMushroomsList();
    }

    @Test
    public void presenterLoadMushrooms_whenException_expectShowError() throws IOException {
        IOException e = new IOException();
        when(mockService.getAllMushrooms())
                .thenThrow(e);

        MushroomsListPresenter presenter = new MushroomsListPresenter(mockService, schedulerProvider);
        presenter.subscribe(mockView);

        presenter.loadMushrooms();

        verify(mockView).showError(e);
    }
}
