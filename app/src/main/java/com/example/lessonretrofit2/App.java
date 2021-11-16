package com.example.lessonretrofit2;

import android.app.Application;

import com.example.lessonretrofit2.data.network.RetrofitClient;
import com.example.lessonretrofit2.data.network.apiservice.CharacterApiService;
import com.example.lessonretrofit2.data.network.apiservice.EpisodeApiService;
import com.example.lessonretrofit2.data.network.apiservice.LocationApiService;

public class App extends Application {

    public static CharacterApiService characterApiService;
    public static EpisodeApiService episodeApiService;
    public static LocationApiService locationApiService;

    @Override
    public void onCreate() {
        super.onCreate();

        RetrofitClient retrofitClient = new RetrofitClient();

        characterApiService = retrofitClient.provideCharacterApiService();
        episodeApiService = retrofitClient.provideEpisodeApiService();
        locationApiService = retrofitClient.provideLocationApiService();


    }
}
