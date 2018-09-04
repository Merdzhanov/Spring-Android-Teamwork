package com.venom.mushroomapp.views.MushroomsList;


import com.venom.mushroomapp.models.Mushroom;

import java.util.List;

public interface MushroomsListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showMushrooms(List<Mushroom> Mushrooms);

        void showEmptyMushroomsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showMushroomDetails(Mushroom Mushroom);
    }

    interface Presenter {
        void subscribe(View view);

        void loadMushrooms();

        void filterMushrooms(String pattern);

        void selectMushroom(Mushroom Mushroom);
    }

    interface Navigator {
        void navigateWith(Mushroom Mushroom);
    }
}
