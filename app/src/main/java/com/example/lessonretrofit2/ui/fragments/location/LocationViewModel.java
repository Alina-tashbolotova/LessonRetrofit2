package com.example.lessonretrofit2.ui.fragments.location;

import androidx.lifecycle.MutableLiveData;

import com.example.lessonretrofit2.App;
import com.example.lessonretrofit2.base.BaseViewModel;
import com.example.lessonretrofit2.data.models.RickAndMortyResponse;
import com.example.lessonretrofit2.data.models.location.LocationModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationViewModel extends BaseViewModel {

    public MutableLiveData<RickAndMortyResponse<LocationModel>> fetchLocations() {

        MutableLiveData<RickAndMortyResponse<LocationModel>> data = new MutableLiveData<>();
        App.locationApiService.fetchLocation().enqueue(new Callback<RickAndMortyResponse<LocationModel>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<LocationModel>> call, Response<RickAndMortyResponse<LocationModel>> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<LocationModel>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
