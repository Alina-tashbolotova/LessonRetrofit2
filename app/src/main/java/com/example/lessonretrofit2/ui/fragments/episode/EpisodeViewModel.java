package com.example.lessonretrofit2.ui.fragments.episode;

import androidx.lifecycle.MutableLiveData;

import com.example.lessonretrofit2.App;
import com.example.lessonretrofit2.base.BaseViewModel;
import com.example.lessonretrofit2.data.models.RickAndMortyResponse;
import com.example.lessonretrofit2.data.models.episode.EpisodeModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeViewModel extends BaseViewModel {

    public MutableLiveData<RickAndMortyResponse<EpisodeModel>> fetchEpisode() {

        MutableLiveData<RickAndMortyResponse<EpisodeModel>> data = new MutableLiveData<>();
        App.episodeApiService.fetchEpisode().enqueue(new Callback<RickAndMortyResponse<EpisodeModel>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<EpisodeModel>> call, Response<RickAndMortyResponse<EpisodeModel>> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<EpisodeModel>> call, Throwable t) {
                data.setValue(null);
            }

        });
        return data;

    }
}
