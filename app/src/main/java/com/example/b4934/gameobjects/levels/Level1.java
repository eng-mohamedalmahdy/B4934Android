package com.example.b4934.gameobjects.levels;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.b4934.R;
import com.example.b4934.core.Level;
import com.example.b4934.core.MovingCharacterSprite;

public class Level1 {
    private Level level;

    public Level1(Context context) {
        Bitmap background = BitmapFactory.decodeResource(context.getResources(), R.drawable.levels_level1);
        Bitmap[] arr = new Bitmap[10];
        for (int i = 0; i < 10; i++) {
            int rid = context.getResources().getIdentifier("player_" + (i + 1), "drawable", context.getPackageName());
            arr[i] = BitmapFactory.decodeResource(context.getResources(), rid);
        }
        Player player = new Player(arr, 50, 50);
        level = new Level(context, player, background);

    }

    public Level getLevel() {
        return level;
    }
}
