package com.example.nativeandroidtasks.ViewModel.Todos;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.nativeandroidtasks.API.APIService;
import com.example.nativeandroidtasks.API.APIUtilize;
import com.example.nativeandroidtasks.Model.Todos_response;
import com.example.nativeandroidtasks.Model.User_response;
import com.example.nativeandroidtasks.ViewModel.User.User_repositories;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Todos_repositories {
    public static Todos_repositories todosRepositories;
    APIService apiService;
    MutableLiveData<List<Todos_response>> datas;

    private Todos_repositories() {
        apiService = APIUtilize.apiService();
    }

    public synchronized static Todos_repositories getInstance() {
        if (todosRepositories == null) {
            return new Todos_repositories();
        }

        return todosRepositories;
    }

    public @NonNull
    MutableLiveData<List<Todos_response>> getTodos() {
        if (datas == null) {
            datas = new MutableLiveData<>();
        }

        Call<List<Todos_response>> call = apiService.get_user_todos();
        call.enqueue(new Callback<List<Todos_response>>() {
            @Override
            public void onResponse(Call<List<Todos_response>> call, Response<List<Todos_response>> response) {
                if (response.isSuccessful()) {
                    List<Todos_response> todos_responses = response.body();
                    datas.postValue(todos_responses);
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Todos_response>> call, Throwable t) {

            }
        });

        return datas;
    }
}
