package com.venom.mushroomapp.views.MushroomCreate;

import android.content.Intent;
import android.os.Bundle;

import com.venom.mushroomapp.R;
import com.venom.mushroomapp.views.BaseDrawerActivity;
import com.venom.mushroomapp.views.MushroomsList.MushroomsListActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MushroomCreateActivity extends BaseDrawerActivity implements MushroomCreateContracts.Navigator {
    public static final long IDENTIFIER = 298;

    @Inject
    MushroomCreateFragment mView;

    @Inject
    MushroomCreateContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mushroom_create);
        ButterKnife.bind(this);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, MushroomsListActivity.class);
        startActivity(intent);
        finish();
    }
}
