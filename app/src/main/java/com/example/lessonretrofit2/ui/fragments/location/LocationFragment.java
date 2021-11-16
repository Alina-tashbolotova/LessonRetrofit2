package com.example.lessonretrofit2.ui.fragments.location;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lessonretrofit2.base.BaseFragment;
import com.example.lessonretrofit2.databinding.FragmentLocationBinding;
import com.example.lessonretrofit2.ui.adapters.LocationAdapter;

public class LocationFragment extends BaseFragment<LocationViewModel, FragmentLocationBinding> {

    private LocationAdapter locationAdapter = new LocationAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    protected void initialization() {
        viewModel = new ViewModelProvider(this).get(LocationViewModel.class);
        setupRecycler();
    }

    protected void setupRecycler() {
        binding.recyclerLocation.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerLocation.setAdapter(locationAdapter);

        locationAdapter.setItemClickListener(position -> {
            Toast.makeText(requireContext(), "Click Position" + position, Toast.LENGTH_SHORT).show();
        });
    }

    protected void setupRequest() {
        viewModel.fetchLocations().observe(getViewLifecycleOwner(), locationModelRickAndMortyResponse -> {
            locationAdapter.addList(locationModelRickAndMortyResponse.getResult());
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}