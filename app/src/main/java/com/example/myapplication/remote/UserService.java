package com.example.myapplication.remote;


import com.example.myapplication.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

    @GET("users/")
    Call<List<User>> getUsers();

    @GET("user_by_cin/")
    Call<User> user_by_cin(@Query("cin") int cin);

    @POST("users/")
    Call<User> addUser(@Body User user);

    @PUT("update/{id}")
    Call<User> updateUser(@Path("id") int id, @Body User user);

    @DELETE("delete/{id}")
    Call<User> deleteUser(@Path("id") int id);
}
