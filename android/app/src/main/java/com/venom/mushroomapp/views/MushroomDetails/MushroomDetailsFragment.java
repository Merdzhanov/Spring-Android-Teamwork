package com.venom.mushroomapp.views.MushroomDetails;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venom.mushroomapp.R;
import com.venom.mushroomapp.models.Mushroom;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MushroomDetailsFragment
        extends Fragment
        implements MushroomDetailsContracts.View {

    private MushroomDetailsContracts.Presenter mPresenter;

    @BindView(R.id.tv_name)
    TextView mNameTextView;

    @BindView(R.id.tv_secret_identity)
    TextView mSecretIdentityTextView;

    @Inject
    public MushroomDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mushroom_details, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadMushroom();
    }

    @Override
    public void showMushroom(Mushroom Mushroom) {
        mNameTextView.setText(Mushroom.getName());
        mSecretIdentityTextView.setText(Mushroom.getSecretIdentity());
    }

    @Override
    public void setPresenter(MushroomDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
