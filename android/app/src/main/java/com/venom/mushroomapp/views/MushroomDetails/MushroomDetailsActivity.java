package com.venom.mushroomapp.views.MushroomDetails;

import android.content.Intent;
import android.os.Bundle;

import com.venom.mushroomapp.Constants;
import com.venom.mushroomapp.R;
import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MushroomDetailsActivity extends BaseDrawerActivity {

    @Inject
    MushroomDetailsFragment mMushroomDetailsFragment;

    @Inject
    MushroomDetailsContracts.Presenter mMushroomDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mushroom_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Mushroom mushroom = (Mushroom) intent.getSerializableExtra(Constants.EXTRA_KEY);

        mMushroomDetailsPresenter.setMushroomId(mushroom.getId());
        mMushroomDetailsFragment.setPresenter(mMushroomDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mMushroomDetailsFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return 0;
    }
}
