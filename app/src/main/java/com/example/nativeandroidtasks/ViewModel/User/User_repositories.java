package com.example.nativeandroidtasks.ViewModel.User;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.nativeandroidtasks.API.APIUtilize;
import com.example.nativeandroidtasks.API.RetrofitClient;
import com.example.nativeandroidtasks.API.APIService;
import com.example.nativeandroidtasks.Model.User_response;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class User_repositories {
    public static User_repositories userRepositories;
    APIService apiService;
    MutableLiveData<List<User_response>> datas;

    private User_repositories() {
        apiService = APIUtilize.apiService();
    }

    public synchronized static User_repositories getInstance() {
        if (userRepositories == null) {
            return new User_repositories();
        }

        return userRepositories;
    }

    public @NonNull
    MutableLiveData<List<User_response>> getUser() {
        if (datas == null) {
            datas = new MutableLiveData<>();
        }

        Call<List<User_response>> call = apiService.get_users();
        call.enqueue(new Callback<List<User_response>>() {
            @Override
            public void onResponse(Call<List<User_response>> call, Response<List<User_response>> response) {
                if (response.isSuccessful()) {
                    List<User_response> userResponse = response.body();
                    datas.postValue(userResponse);
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<User_response>> call, Throwable t) {

            }
        });

        return datas;
    }
}
