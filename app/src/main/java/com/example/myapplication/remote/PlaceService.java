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
import retrofit2.http.Query;


public interface PlaceService {
    @GET("getLocations/")
    Call<List<Place>> getPlaces();

    @GET("place/")
    Call<Place> getPlace(@Query("place_id") int place_id);

    @POST("createLocation/")
    Call<Place> addPlace(@Body Place place);

    @GET("place_by_city_id/")
    Call<List<Place>> getPlacesByCityId(@Query("city_id") int city_id);
}
