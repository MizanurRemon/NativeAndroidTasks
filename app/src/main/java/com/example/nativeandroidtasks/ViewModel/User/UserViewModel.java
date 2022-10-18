package com.example.nativeandroidtasks.ViewModel.User;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nativeandroidtasks.Model.User_response;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<User_response>> getUser(){
        return User_repositories.getInstance().getUser();
    }
}
