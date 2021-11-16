package com.example.lessonretrofit2.ui.fragments.character.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.lessonretrofit2.base.BaseFragment;
import com.example.lessonretrofit2.databinding.FragmentCharacterDetailBinding;
import com.example.lessonretrofit2.ui.fragments.character.CharacterViewModel;


public class CharacterDetailFragment extends BaseFragment<CharacterViewModel, FragmentCharacterDetailBinding> {

    int id;
    private FragmentCharacterDetailBinding binding;
    private CharacterViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterDetailBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    protected void initialization() {

        viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
    }

    protected void setupRequest() {

        id = CharacterDetailFragmentArgs.fromBundle(getArguments()).getPhoto(); // Получение данных через Safe Args

        viewModel.fetchId(id).observe(getViewLifecycleOwner(), characterModel -> {
            Glide.with(binding.imageItemCharacterDetail)
                    .load(characterModel.getImage())
                    .into(binding.imageItemCharacterDetail);
            binding.txtItemName.setText(characterModel.getName());
            binding.txtItemStatus.setText(characterModel.getStatus());
            binding.txtItemType.setText(characterModel.getType());

        });
    }

    @Override
    protected void setupRecycler() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}