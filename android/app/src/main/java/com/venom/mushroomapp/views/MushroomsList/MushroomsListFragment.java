package com.venom.mushroomapp.views.MushroomsList;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.venom.mushroomapp.R;
import com.venom.mushroomapp.models.Mushroom;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class MushroomsListFragment
        extends Fragment
        implements MushroomsListContracts.View, MushroomsAdapter.OnMushroomClickListener {
    private MushroomsListContracts.Navigator mNavigator;

    @BindView(R.id.rv_mushrooms)
    RecyclerView mMushroomsView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    @BindView(R.id.et_filter)
    EditText mFilterEditText;

    @Inject
    MushroomsAdapter mMushroomsAdapter;

    private MushroomsListContracts.Presenter mPresenter;
    private LinearLayoutManager mMushroomsViewLayoutManager;

    @Inject
    public MushroomsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mushrooms_list, container, false);

        // ButterKnife is applied
        ButterKnife.bind(this, view);

        mMushroomsAdapter.setOnMushroomClickListener(this);

        mMushroomsView.setAdapter(mMushroomsAdapter);
        mMushroomsViewLayoutManager = new LinearLayoutManager(getContext());
        mMushroomsView.setLayoutManager(mMushroomsViewLayoutManager);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadMushrooms();
    }

    @Override
    public void setPresenter(MushroomsListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMushrooms(List<Mushroom> mushrooms) {
        mMushroomsAdapter.clear();
        mMushroomsAdapter.addAll(mushrooms);
        mMushroomsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyMushroomsList() {
        Toast.makeText(getContext(),
                "No Mushrooms",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mMushroomsView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mMushroomsView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void showMushroomDetails(Mushroom mushroom) {
        mNavigator.navigateWith(mushroom);
    }

    void setNavigator(MushroomsListContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @OnTextChanged(R.id.et_filter)
    public void onTextChanged() {
        String pattern = mFilterEditText.getText().toString();
        mPresenter.filterMushrooms(pattern);
    }

    @Override
    public void onClick(Mushroom mushroom) {
        mPresenter.selectMushroom(mushroom);
    }
}
