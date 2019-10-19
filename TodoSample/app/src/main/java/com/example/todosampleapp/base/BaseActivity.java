package com.example.todosampleapp.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.todosampleapp.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
