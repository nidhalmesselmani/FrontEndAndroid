package com.example.myapplication.remote;

import com.example.myapplication.model.Place;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface PlaceService {
    @GET("places/")
    Call<List<Place>> getPlaces();

    @GET("getContanimatedPlaces/")
    Call<List<Place>> getContanimatedPlaces();

    @GET("place/")
    Call<Place> getPlace(@Query("place_id") int place_id);

    @POST("createLocation/")
    Call<Place> addPlace(@Body Place place);

    @GET("place_by_city_id/")
    Call<List<Place>> getPlacesByCityId(@Query("city_id") int city_id);


    @GET("report_place/")
    Call<ResponseBody>  reportPlace(
            @Query("place_id") int id
    );
}
