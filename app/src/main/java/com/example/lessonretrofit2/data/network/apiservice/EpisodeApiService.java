package com.example.lessonretrofit2.data.network.apiservice;

import com.example.lessonretrofit2.data.models.RickAndMortyResponse;
import com.example.lessonretrofit2.data.models.episode.EpisodeModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EpisodeApiService {

    @GET("/api/episode/")
    Call<RickAndMortyResponse<EpisodeModel>> fetchEpisode();
}
