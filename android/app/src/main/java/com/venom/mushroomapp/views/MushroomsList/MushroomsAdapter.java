package com.venom.mushroomapp.views.MushroomsList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.venom.mushroomapp.R;
import com.venom.mushroomapp.models.Mushroom;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MushroomsAdapter extends RecyclerView.Adapter<MushroomsAdapter.MushroomViewHolder> {
    private List<Mushroom> mMushrooms;
    private OnMushroomClickListener mOnMushroomClickListener;

    @Inject
    public MushroomsAdapter() {
        mMushrooms = new ArrayList<>();
    }

    @NonNull
    @Override
    public MushroomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mushroom_item, parent, false);
        return new MushroomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MushroomViewHolder holder, int position) {
        holder.setOnClickListener(mOnMushroomClickListener);
        holder.bind(mMushrooms.get(position));
    }

    @Override
    public int getItemCount() {
        return mMushrooms.size();
    }

    public Mushroom getItem(int position) {
        return mMushrooms.get(position);
    }

    public void clear() {
        mMushrooms.clear();
    }

    public void addAll(List<Mushroom> Mushrooms) {
        mMushrooms.addAll(Mushrooms);
    }

    public void setOnMushroomClickListener(OnMushroomClickListener onMushroomClickListener) {
        this.mOnMushroomClickListener = onMushroomClickListener;
    }

    public static class MushroomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name_mushroom)
        TextView mNameTextView;

        @BindView(R.id.iv_mushroom)
        ImageView mMushroomImageView;

        private OnMushroomClickListener mOnClickListener;
        private Mushroom mMushroom;

        MushroomViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Mushroom mushroom) {
            mNameTextView.setText(mushroom.getName());
            Picasso.get()
                    .load(mushroom.getImageUrl())
                    .into(mMushroomImageView);
            mMushroom = mushroom;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mMushroom);
        }

        public void setOnClickListener(OnMushroomClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnMushroomClickListener {
        void onClick(Mushroom Mushroom);
    }
}