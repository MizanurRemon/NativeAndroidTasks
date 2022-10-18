package com.example.nativeandroidtasks.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.nativeandroidtasks.R;
import com.example.nativeandroidtasks.View.Fragment.Fragment_home;
import com.example.nativeandroidtasks.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new Fragment_home()).commit();
        }

        setContentView(view);
    }
}