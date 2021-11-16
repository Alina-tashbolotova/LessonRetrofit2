package com.example.lessonretrofit2.ui.fragments.character;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lessonretrofit2.R;
import com.example.lessonretrofit2.base.BaseFragment;
import com.example.lessonretrofit2.databinding.FragmentCharacterBinding;
import com.example.lessonretrofit2.ui.adapters.CharacterAdapter;

public class CharacterFragment extends BaseFragment<CharacterViewModel, FragmentCharacterBinding> {

    private CharacterAdapter characterAdapter = new CharacterAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setItem();
    }


    protected void initialization() {
        viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
        setupRecycler();
    }

    protected void setupRequest() {
        viewModel.fetchCharacters().observe(getViewLifecycleOwner(), characterModelRickAndMortyResponse -> {
            characterAdapter.addList(characterModelRickAndMortyResponse.getResult());

        });

    }

    private void setItem() {

        characterAdapter.setOnItemClickListener(position -> {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment()
                            .setPhoto(position));
        });

    }

    protected void setupRecycler() {
        binding.recyclerCharacter.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerCharacter.setAdapter(characterAdapter);

        characterAdapter.setOnItemClickListener(position -> {
            Toast.makeText(requireContext(), "Click Position" + position, Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}