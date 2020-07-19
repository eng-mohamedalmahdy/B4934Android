package com.example.b4934.gameobjects.obstacles;

import android.graphics.Bitmap;

import com.example.b4934.core.StaticCharacterSprite;
import com.example.b4934.utils.Constants;

public class BaseObstacle extends StaticCharacterSprite {


    public BaseObstacle(Bitmap bmp, int x) {
        super(bmp);
        setY(Constants.screenHeight - bmp.getHeight());
        setX(x);
        setWeight(Constants.STATIC_OBSTACLE_WEIGHT);
    }

    @Override
    public void update() {

    }
}
