package com.example.lessonretrofit2.data.network.apiservice;

import com.example.lessonretrofit2.data.models.RickAndMortyResponse;
import com.example.lessonretrofit2.data.models.character.CharacterModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CharacterApiService {

    @GET("/api/character")
    Call<RickAndMortyResponse<CharacterModel>> fetchCharacters();

    @GET("/api/character/{id}")
    Call<CharacterModel> fetchId(@Path("id") int id);
}
