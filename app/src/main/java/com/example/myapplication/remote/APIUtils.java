package com.example.myapplication.remote;

public class APIUtils {

    private APIUtils(){
    };
    public static final String API_URL = "https://innovatebackend.herokuapp.com/api/";

    public static PlaceService getPlaceService(){
        return RetrofitClient.getClient(API_URL).create(PlaceService.class);
    }

    public static UserService getUserService(){
        return RetrofitClient.getClient(API_URL).create(UserService.class);
    }
}
