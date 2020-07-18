package com.example.b4934.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.b4934.R;

public class SpritesFactory {

    public static Bitmap getSpriteFromId(Context context, int id) {
        return BitmapFactory.decodeResource(context.getResources(), id);
    }

    public static Bitmap[] getSpritesFromIds(Context context, int[] ids) {
        Bitmap[] res = new Bitmap[ids.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = getSpriteFromId(context, ids[i]);
        }
        return res;
    }

    public static Bitmap[] getOwlSprites(Context context) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = context.getResources().getIdentifier("player_" + (i + 1), "drawable", context.getPackageName());

        }
        return getSpritesFromIds(context, arr);
    }

    public static Bitmap getLevel1BackgroundSprite(Context context) {
        return getSpriteFromId(context, R.drawable.levels_level1);
    }

    public static Bitmap getObstacle1Sprite(Context context) {
        return getSpriteFromId(context, R.drawable.obstacles_obstacle1);
    }
}
