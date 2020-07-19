package com.example.b4934.gameobjects.levels;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.b4934.core.Level;
import com.example.b4934.gameobjects.Player;
import com.example.b4934.gameobjects.obstacles.BaseObstacle;
import com.example.b4934.utils.SpritesFactory;

public class Level1 {
    private Level level;
    private BaseObstacle ob1;

    public Level1(Context context) {
        ob1 = new BaseObstacle(SpritesFactory.getObstacle1Sprite(context),1000);
        Bitmap background = SpritesFactory.getLevel1BackgroundSprite(context);
        Player player = new Player(SpritesFactory.getOwlSprites(context));
        level = new Level(context, player, background);
        level.addObject(ob1);
    }

    public Level getLevel() {
        return level;
    }
}
