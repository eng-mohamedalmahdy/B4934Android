package com.example.b4934.gameobjects.levels;

import android.graphics.Bitmap;

import com.example.b4934.core.MovingCharacterSprite;

public class Player extends MovingCharacterSprite {
    public Player(Bitmap[] bmp, int width, int height) {
        super(bmp, width, height);
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
