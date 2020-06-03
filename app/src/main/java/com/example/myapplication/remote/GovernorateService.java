package com.example.myapplication.remote;

import com.example.myapplication.model.Governorate;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GovernorateService {

    @GET("governorates/")
    Call<List<Governorate>> getGovernorates();

    @POST("governorates/")
    Call<Governorate> addGovernorate(@Body Governorate governorate);

    @PUT("update/{id}")
    Call<Governorate> updateGovernorate(@Path("id") int id, @Body Governorate governorate);

    @DELETE("delete/{id}")
    Call<Governorate> deleteGovernorate(@Path("id") int id);
}