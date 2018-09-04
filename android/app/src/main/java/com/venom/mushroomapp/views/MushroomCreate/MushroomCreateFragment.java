package com.venom.mushroomapp.views.MushroomCreate;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.venom.mushroomapp.R;
import com.venom.mushroomapp.models.Mushroom;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MushroomCreateFragment extends Fragment implements MushroomCreateContracts.View {
    private MushroomCreateContracts.Presenter mPresenter;

    @BindView(R.id.et_name)
    EditText mNameEditText;

    @BindView(R.id.et_secret_identity)
    EditText mSecretIdentity;
    private MushroomCreateContracts.Navigator mNavigator;

    @Inject
    public MushroomCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mushroom_create, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @OnClick(R.id.btn_save)
    public void onMuhroomSaveClicked() {
        String name = mNameEditText.getText().toString();
        String secretIdentity = mSecretIdentity.getText().toString();
        String imageUrl = "http://idrawproart.com/CapOneMushroom.jpg";
        Mushroom Mushroom = new Mushroom(name, secretIdentity, imageUrl);
        mPresenter.save(Mushroom);
    }

    @Override
    public void setPresenter(MushroomCreateContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void navigateToHome() {
        mNavigator.navigateToHome();
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    public void setNavigator(MushroomCreateContracts.Navigator navigator) {
        mNavigator = navigator;
    }
}
