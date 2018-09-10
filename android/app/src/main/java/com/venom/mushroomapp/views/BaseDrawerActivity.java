package com.venom.mushroomapp.views;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.venom.mushroomapp.Constants;
import com.venom.mushroomapp.R;
import com.venom.mushroomapp.views.MushroomCreate.MushroomCreateActivity;
import com.venom.mushroomapp.views.MushroomsList.MushroomsListActivity;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;

    public BaseDrawerActivity() {

    }

    public void setupDrawer() {
        PrimaryDrawerItem listMushroomsItem = new PrimaryDrawerItem()
                .withIdentifier(Constants.LIST_IDENTIFIER)
                .withIcon(android.R.drawable.ic_input_get)
                .withName("Home");

        PrimaryDrawerItem createMushroomItem = new PrimaryDrawerItem()
                .withIdentifier(Constants.CREATE_IDENTIFIER)
                .withIcon(android.R.drawable.btn_plus)
                .withName("Create Mushroom");

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        listMushroomsItem,
                        new DividerDrawerItem(),
                        createMushroomItem
                )
                .withOnDrawerItemClickListener((view, position, drawerItem) ->
                {
                    long identifier = drawerItem.getIdentifier();

                    if (getIdentifier() == identifier) {
                        return false;
                    }

                    Intent intent = getNextIntent(identifier);
                    if (intent == null) {
                        return false;
                    }

                    startActivity(intent);
                    return true;
                })
                .build();
    }

    private Intent getNextIntent(long identifier) {
        if (identifier == Constants.CREATE_IDENTIFIER) {
            return new Intent(this, MushroomCreateActivity.class);
        }
        else if (identifier == Constants.LIST_IDENTIFIER)
        {
            return new Intent(this, MushroomsListActivity.class);
        }

        return null;
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    protected abstract long getIdentifier();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }
}
