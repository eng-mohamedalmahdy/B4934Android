package com.example.b4934.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.b4934.gameobjects.levels.Level1;

public class GameActivity extends AppCompatActivity {

    private Level1 level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        level = new Level1(this);
        setContentView(level.getLevel());
    }

    @Override
    protected void onPause() {
        super.onPause();
        level.getLevel().getThread().setRunning(false);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        level.getLevel().getThread().setRunning(false);
        finish();
    }
}

