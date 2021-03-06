package com.venom.mushroomapp.views.MushroomDetails;


import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import com.venom.mushroomapp.R;
import com.venom.mushroomapp.models.Mushroom;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MushroomDetailsFragment
        extends Fragment
        implements MushroomDetailsContracts.View {

    private MushroomDetailsContracts.Presenter mPresenter;

    @BindView(R.id.iv_mushroom_details)
    ImageView mImageView;

    @BindView(R.id.tv_name)
    TextView mNameTextView;

    @BindView(R.id.tv_description)
    TextView mDescriptionTextView;

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
    public void showMushroom(Mushroom mushroom) {
        mNameTextView.setText(mushroom.getName());
        mDescriptionTextView.setText(mushroom.getDescription());
        mDescriptionTextView.setMovementMethod(new ScrollingMovementMethod());
        Picasso.get().load(mushroom.getImageUrl()).into(mImageView);
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
