package com.example.lessonretrofit2.data.network.apiservice;

import com.example.lessonretrofit2.data.models.RickAndMortyResponse;
import com.example.lessonretrofit2.data.models.location.LocationModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocationApiService {

    @GET("/api/location")
    Call<RickAndMortyResponse<LocationModel>> fetchLocation();
}
