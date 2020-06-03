package com.example.myapplication.remote;

import com.example.myapplication.model.City;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CityService {

    @GET("city_by_governorate_id/")
    Call<List<City>> getCityByGovernorateId(@Query("governorate_id") int governorate_id);

    @POST("cities/")
    Call<City> addCity(@Body City city);

    @PUT("update/{id}")
    Call<City> updateCity(@Path("id") int id, @Body City city);

    @DELETE("delete/{id}")
    Call<City> deleteCity(@Path("id") int id);
}