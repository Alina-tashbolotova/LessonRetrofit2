package com.example.lessonretrofit2.ui.fragments.character;

import androidx.lifecycle.MutableLiveData;

import com.example.lessonretrofit2.App;
import com.example.lessonretrofit2.base.BaseViewModel;
import com.example.lessonretrofit2.data.models.RickAndMortyResponse;
import com.example.lessonretrofit2.data.models.character.CharacterModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends BaseViewModel {

    public MutableLiveData<RickAndMortyResponse<CharacterModel>> fetchCharacters() {

        MutableLiveData<RickAndMortyResponse<CharacterModel>> data = new MutableLiveData<>();
        App.characterApiService.fetchCharacters().enqueue(new Callback<RickAndMortyResponse<CharacterModel>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<CharacterModel>> call, Response<RickAndMortyResponse<CharacterModel>> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<CharacterModel>> call, Throwable t) {
                data.setValue(null);

            }
        });
        return data;

    }

    public MutableLiveData<CharacterModel> fetchId(int id) {
        MutableLiveData<CharacterModel> liveData = new MutableLiveData<>();
        App.characterApiService.fetchId(id).enqueue(new Callback<CharacterModel>() {
            @Override
            public void onResponse(Call<CharacterModel> call, Response<CharacterModel> response) {
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CharacterModel> call, Throwable t) {
                liveData.setValue(null);

            }
        });
        return liveData;
    }
}
