package com.example.b4934.gameobjects.obstacles;

import android.graphics.Bitmap;

import com.example.b4934.core.StaticCharacterSprite;
import com.example.b4934.utils.Util;

public abstract class BaseObstacle extends StaticCharacterSprite {


    public BaseObstacle(Bitmap bmp, int x) {
        super(bmp);
        setX(x);
        setY(Util.screenHeight - bmp.getHeight());
    }

}
