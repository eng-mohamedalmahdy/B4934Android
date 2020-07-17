package com.example.b4934.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.b4934.R;
import com.example.b4934.core.Level;
import com.example.b4934.core.MovingCharacterSprite;
import com.example.b4934.core.StaticCharacterSprite;
import com.example.b4934.levels.Level1;

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

