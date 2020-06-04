package com.example.myapplication.remote;

import com.example.myapplication.model.Governorate;
import com.example.myapplication.model.PlaceCheckins;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PlaceCheckinsService {

    @GET("checkins/")
    Call<List<PlaceCheckins>> getcheckins();

    @POST("checkins/")
    Call<PlaceCheckins> addPlaceCheckins(@Body PlaceCheckins placeCheckins);

    @PUT("update/{id}")
    Call<Governorate> updatePlaceCheckins(@Path("id") int id, @Body PlaceCheckins placeCheckins);

    @DELETE("delete/{id}")
    Call<Governorate> deletePlaceCheckins(@Path("id") int id);
}
