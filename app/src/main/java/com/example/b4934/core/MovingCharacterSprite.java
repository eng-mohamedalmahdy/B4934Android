package com.example.b4934.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public abstract class MovingCharacterSprite {
    protected Bitmap[] images;
    protected int x, y;
    protected int xVelocity = 10;
    protected int yVelocity = 10;
    protected int width;
    protected int height;
    protected boolean up;
    protected int currFrame = 0;

    protected int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    protected int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

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

    abstract public void update();

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
