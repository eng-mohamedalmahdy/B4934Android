package com.example.b4934.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class MovingCharacterSprite {
    private Bitmap[] images;
    private int x, y;
    private int xVelocity = 10;
    private int yVelocity = 10;
    private int width;
    private int height;
    private boolean up;
    int currFrame = 0;


    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public MovingCharacterSprite(Bitmap[] bmp, int width, int height) {
        images = bmp;
        this.width = width;
        this.height = height;
        x = 50;
        y = screenHeight / 2;

    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(images[currFrame], x, y, null);
    }

    public void update() {
        x += xVelocity;
        y += (up)?-yVelocity:yVelocity;
//        if ((x > screenWidth - width) || (x < 0)) {
//            xVelocity = xVelocity * -1;
//        }
//        if ((y > screenHeight - height) || (y < 0)) {
//            yVelocity = yVelocity * -1;
//        }
        currFrame++;
        currFrame %= images.length;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rect getRect() {
        return new Rect(x, y, x + width, y + height);
    }

    public void setUp(boolean up) {
        this.up = up;
    }
}
