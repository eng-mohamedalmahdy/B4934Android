package com.example.b4934.gameobjects.levels;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.b4934.core.Level;
import com.example.b4934.gameobjects.Player;
import com.example.b4934.gameobjects.obstacles.BaseObstacle;
import com.example.b4934.utils.SpritesFactory;

public class Level1 {
    private Level level;

    public Level1(Context context) {

        Bitmap background = SpritesFactory.getLevel1BackgroundSprite(context);
        Player player = new Player(SpritesFactory.getOwlSprites(context));
        level = new Level(context, player, background);

    }

    public Level getLevel() {
        return level;
    }
}
