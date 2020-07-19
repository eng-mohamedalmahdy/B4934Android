package com.example.b4934.gameobjects;

import android.graphics.Bitmap;

import com.example.b4934.core.MovingCharacterSprite;

public class Player extends MovingCharacterSprite {
    protected boolean up;

    public Player(Bitmap[] bmp) {
        super(bmp);
    }


    public void setUp(boolean up) {
        this.up = up;
    }

    @Override
    public void update() {
        {
            x += xVelocity;
            y += (up) ? -yVelocity : yVelocity;
            currFrame++;
            currFrame %= images.length;
//        if ((x > screenWidth - width) || (x < 0)) {
//            xVelocity = xVelocity * -1;
//        }
//        if ((y > screenHeight - height) || (y < 0)) {
//            yVelocity = yVelocity * -1;
//        }
        }
    }
}
