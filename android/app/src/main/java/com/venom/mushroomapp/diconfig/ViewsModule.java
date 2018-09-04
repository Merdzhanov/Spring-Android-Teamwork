package com.venom.mushroomapp.diconfig;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.venom.mushroomapp.views.MushroomsList.MushroomsAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewsModule {
    @Provides
    public RecyclerView.Adapter<MushroomsAdapter.MushroomViewHolder> MushroomArrayAdapter(Context context) {
        return new MushroomsAdapter();
    }
}
