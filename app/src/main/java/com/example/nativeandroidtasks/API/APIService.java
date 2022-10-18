package com.example.nativeandroidtasks.API;

import com.example.nativeandroidtasks.Model.Todos_response;
import com.example.nativeandroidtasks.Model.User_response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("users")
    Call<List<User_response>> get_users();

    @GET("todos")
    Call<List<Todos_response>> get_user_todos();
}
