package com.example.nativeandroidtasks.API;

public class APIUtilize {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static APIService apiService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
