package com.venom.mushroomapp.views.MushroomsList;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.venom.mushroomapp.Constants;
import com.venom.mushroomapp.R;
import com.venom.mushroomapp.models.Mushroom;
import com.venom.mushroomapp.views.BaseDrawerActivity;
import com.venom.mushroomapp.views.MushroomDetails.MushroomDetailsActivity;
import com.venom.mushroomapp.views.MushroomDetails.MushroomDetailsFragment;
import com.venom.mushroomapp.views.MushroomDetails.MushroomDetailsPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MushroomsListActivity
        extends BaseDrawerActivity
        implements MushroomsListContracts.Navigator {

    @Inject
    MushroomsListFragment mMushroomsListFragment;

    @Inject
    MushroomsListContracts.Presenter mMushroomsListPresenter;

    @Inject
    MushroomDetailsFragment mMushroomDetailsFragment;

    @Inject
    MushroomDetailsPresenter mMushroomDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mushrooms_list);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

        mMushroomsListFragment.setNavigator(this);
        mMushroomsListFragment.setPresenter(mMushroomsListPresenter);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mMushroomsListFragment);

        if (!isPhone()) {
            mMushroomDetailsFragment.setPresenter(mMushroomDetailsPresenter);
            transaction.replace(R.id.content_details, mMushroomDetailsFragment);
        }

        transaction.commit();
    }

    private boolean isPhone() {
        return findViewById(R.id.content_details) == null;
    }

    @Override
    protected long getIdentifier() {
        return Constants.LIST_IDENTIFIER;
    }

    @Override
    public void navigateWith(Mushroom mushroom) {
        if (isPhone()) {
            Intent intent = new Intent(
                    this,
                    MushroomDetailsActivity.class
            );

            intent.putExtra(Constants.EXTRA_KEY, mushroom);

            startActivity(intent);
        } else {
            mMushroomDetailsPresenter.setMushroomId(mushroom.getId());
            mMushroomDetailsPresenter.loadMushroom();
        }
    }
}
