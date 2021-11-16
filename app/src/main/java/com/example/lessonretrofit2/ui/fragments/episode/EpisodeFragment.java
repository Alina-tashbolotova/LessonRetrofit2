package com.example.lessonretrofit2.ui.fragments.episode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lessonretrofit2.base.BaseFragment;
import com.example.lessonretrofit2.databinding.FragmentEpisodeBinding;
import com.example.lessonretrofit2.ui.adapters.EpisodeAdapter;


public class EpisodeFragment extends BaseFragment<EpisodeViewModel, FragmentEpisodeBinding> {

    private EpisodeAdapter episodeAdapter = new EpisodeAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodeBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    protected void initialization() {
        viewModel = new ViewModelProvider(this).get(EpisodeViewModel.class);
        setupRecycler();
    }

    protected void setupRequest() {
        viewModel.fetchEpisode().observe(getViewLifecycleOwner(), episodeModelRickAndMortyResponse -> {
            episodeAdapter.addList(episodeModelRickAndMortyResponse.getResult());
        });
    }


    protected void setupRecycler() {
        binding.recyclerEpisode.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerEpisode.setAdapter(episodeAdapter);

        episodeAdapter.setOnItemClickListener(position -> {
            Toast.makeText(requireContext(), "Click Position" + position, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }
}