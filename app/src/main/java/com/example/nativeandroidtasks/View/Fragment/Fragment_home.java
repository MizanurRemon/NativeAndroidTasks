package com.example.nativeandroidtasks.View.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.nativeandroidtasks.Adapter.ToDo_adapter;
import com.example.nativeandroidtasks.Model.Todos_response;
import com.example.nativeandroidtasks.Model.User_response;
import com.example.nativeandroidtasks.R;
import com.example.nativeandroidtasks.ViewModel.Todos.TodosViewModel;
import com.example.nativeandroidtasks.ViewModel.User.UserViewModel;
import com.example.nativeandroidtasks.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class Fragment_home extends Fragment {

    FragmentHomeBinding binding;
    UserViewModel userViewModel;
    TodosViewModel todosViewModel;

    List<User_response> userList;

    List<String> spinnerList;

    List<Todos_response> toDoList;
    List<Todos_response> filteredToDoList;

    ToDo_adapter toDoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        init_view(view);


        get_todos();

        return view;
    }

    private void get_todos() {
        todosViewModel = new ViewModelProvider(this).get(TodosViewModel.class);
        todosViewModel.get_user_todos().observe(getViewLifecycleOwner(), new Observer<List<Todos_response>>() {
            @Override
            public void onChanged(List<Todos_response> todos_responses) {
                toDoList = new ArrayList<>();
                toDoList = todos_responses;

                get_users();
            }
        });
    }

    private void get_users() {
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<List<User_response>>() {
            @Override
            public void onChanged(List<User_response> user_response) {
                userList = new ArrayList<>();
                userList = user_response;
                //Toast.makeText(getActivity(), String.valueOf(userList.size()), Toast.LENGTH_SHORT).show();
                spinnerList = new ArrayList<>();

                for (int i = 0; i < userList.size(); i++) {
                    spinnerList.add(userList.get(i).username);
                }

                ArrayAdapter userAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, spinnerList);
                userAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                binding.userSpinner.setAdapter(userAdapter);

                binding.userSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String userName = parent.getItemAtPosition(position).toString();
                        int userID = userList.get(position).id;

                        filteredToDoList = new ArrayList<>();

                        for (int i = 0; i < toDoList.size(); i++) {
                            if (userID == toDoList.get(i).userId) {
                                filteredToDoList.add(toDoList.get(i));
                            }
                        }

                        toDoAdapter = new ToDo_adapter(filteredToDoList);
                        binding.itemView.setAdapter(toDoAdapter);

                        //Toast.makeText(getActivity(), String.valueOf(filteredToDoList.size()), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
    }

    private void init_view(View view) {
        binding.itemView.setHasFixedSize(true);
        binding.itemView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.itemView.setItemViewCacheSize(150);
    }
}