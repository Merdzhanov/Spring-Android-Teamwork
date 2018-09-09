package com.venom.mushroomapp.views.MushroomDetails;


import com.venom.mushroomapp.models.Mushroom;

public interface MushroomDetailsContracts {
    interface View {
        void showMushroom(Mushroom mushroom);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadMushroom();

        void setMushroomId(int id);
    }
}
