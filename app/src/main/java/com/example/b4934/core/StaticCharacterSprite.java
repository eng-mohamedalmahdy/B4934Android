package com.example.b4934.core;

import android.graphics.Bitmap;

public abstract class StaticCharacterSprite extends MovingCharacterSprite {

    public StaticCharacterSprite(Bitmap bmp, int width, int height) {
        super(new Bitmap[]{bmp}, width, height);
    }
}
