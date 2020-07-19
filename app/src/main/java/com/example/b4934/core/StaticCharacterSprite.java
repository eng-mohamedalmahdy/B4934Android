package com.example.b4934.core;

import android.graphics.Bitmap;

public abstract class StaticCharacterSprite extends MovingCharacterSprite {

    public StaticCharacterSprite(Bitmap bmp) {
        super(new Bitmap[]{bmp});
        xVelocity = 0;
        yVelocity = 0;
    }

}
