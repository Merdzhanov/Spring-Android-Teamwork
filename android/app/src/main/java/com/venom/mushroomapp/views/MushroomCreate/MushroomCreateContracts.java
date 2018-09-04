package com.venom.mushroomapp.views.MushroomCreate;


import com.venom.mushroomapp.models.Mushroom;

public interface MushroomCreateContracts {
    interface View {

        void setPresenter(Presenter presenter);

        void navigateToHome();

        void showError(Throwable throwable);

        void hideLoading();

        void showLoading();
    }

    interface Presenter {

        void subscribe(View view);

        void unsubscribe();

        void save(Mushroom Mushroom);
    }

    public interface Navigator {

        void navigateToHome();
    }
}
