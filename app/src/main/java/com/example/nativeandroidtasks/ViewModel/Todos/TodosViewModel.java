package com.example.nativeandroidtasks.ViewModel.Todos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nativeandroidtasks.Model.Todos_response;

import java.util.List;

public class TodosViewModel extends AndroidViewModel {
    public TodosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Todos_response>> get_user_todos() {
        return Todos_repositories.getInstance().getTodos();
    }
}
