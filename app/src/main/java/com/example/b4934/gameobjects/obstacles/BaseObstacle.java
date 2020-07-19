package com.example.b4934.gameobjects.obstacles;

import android.graphics.Bitmap;

import com.example.b4934.core.StaticCharacterSprite;
import com.example.b4934.utils.Util;

public class BaseObstacle extends StaticCharacterSprite {


    public BaseObstacle(Bitmap bmp, int x) {
        super(bmp);
        setY(Util.screenHeight - bmp.getHeight());
        setX(x);
    }

    @Override
    public void update() {

    }
}
