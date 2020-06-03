package com.example.myapplication.remote;

import com.example.myapplication.model.Place;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface PlaceService {
    @GET("getLocations/")
    Call<List<Place>> getPlaces();

    @POST("createLocation/")
    Call<Place> addPlace(@Body Place place);

    @GET("getLocations/")
    Call<List<Place>> getPlacesByCityId();
}
