package com.example.b4934.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.b4934.R;
import com.example.b4934.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private ActivityMainBinding binding;
    private Button play;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initComponents();

    }

    private void initComponents() {
        play = binding.play;
        play.setOnClickListener((cl) -> {
            startActivity(new Intent(MainActivity.this, GameActivity.class));
        });
    }
}
