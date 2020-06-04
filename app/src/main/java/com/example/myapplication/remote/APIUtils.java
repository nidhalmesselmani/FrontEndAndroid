package com.example.myapplication.remote;

public class APIUtils {

    private APIUtils(){
    };
    public static final String API_URL = "https://innovatebackend.herokuapp.com/api/";

    public static PlaceService getPlaceService(){
        return RetrofitClient.getClient(API_URL).create(PlaceService.class);
    }

    public static UserService getUserService() {
        return RetrofitClient.getClient(API_URL).create(UserService.class);
    }

    public  static GovernorateService getGovernorateService() {
        return RetrofitClient.getClient(API_URL).create(GovernorateService.class);
    }
    public  static CityService getCityService() {
        return RetrofitClient.getClient(API_URL).create(CityService.class);
    }

    public  static PlaceCheckinsService getPlaceCheckinService() {
        return RetrofitClient.getClient(API_URL).create(PlaceCheckinsService.class);
    }
}
