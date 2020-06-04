package com.example.myapplication.remote;

import com.example.myapplication.model.Governorate;
import com.example.myapplication.model.PlaceCheckins;
import com.example.myapplication.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlaceCheckinsService {

    @GET("checkins/")
    Call<List<PlaceCheckins>> getcheckins();

    @GET("checkinsadd/")
    Call<PlaceCheckins> addPlaceCheckins(@Query("place_id") int place_id, @Query("user_id") int user_id, @Query("checkin") String checkin, @Query("checkout") String checkout);

    // Call<PlaceCheckins> addPlaceCheckins(@BO("place_id") int place_id, @Query("user_id") int user_id, @Query("checkin") String checkin, @Query("checkout") String checkout);

    @PUT("update/{id}")
    Call<Governorate> updatePlaceCheckins(@Path("id") int id, @Body PlaceCheckins placeCheckins);

    @DELETE("delete/{id}")
    Call<Governorate> deletePlaceCheckins(@Path("id") int id);
}
