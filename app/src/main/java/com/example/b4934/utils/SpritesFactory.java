package com.example.b4934.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.b4934.R;

import org.jetbrains.annotations.NotNull;

public class SpritesFactory {
    @NotNull

    public static Bitmap getSpriteFromId(@NotNull Context context, int id) {
        return BitmapFactory.decodeResource(context.getResources(), id);
    }

    @NotNull
    public static Bitmap[] getSpritesFromIds(Context context, @NotNull int[] ids) {
        Bitmap[] res = new Bitmap[ids.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = getSpriteFromId(context, ids[i]);
        }
        return res;
    }

    @NotNull
    public static Bitmap[] getOwlSprites(Context context) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = context.getResources().getIdentifier("player_" + (i + 1), "drawable", context.getPackageName());

        }
        return getSpritesFromIds(context, arr);
    }

    @NotNull
    public static Bitmap getLevel1BackgroundSprite(Context context) {
        return getSpriteFromId(context, R.drawable.levels_level1);
    }

    @NotNull
    public static Bitmap getObstacle1Sprite(Context context) {
        return getSpriteFromId(context, R.drawable.obstacles_obstacle1);
    }

    @NotNull
    public static Bitmap getObstacle2Sprite(Context context) {
        return getSpriteFromId(context, R.drawable.obstacles_obstacle2);
    }

    @NotNull
    public static Bitmap getObstacle3Sprite(Context context) {
        return getSpriteFromId(context, R.drawable.obstacles_obstacle3);
    }

    @NotNull
    public static Bitmap getObstacle4Sprite(Context context) {
        return getSpriteFromId(context, R.drawable.obstacles_obstacle4);
    }

    @NotNull
    public static Bitmap getObstacle5Sprite(Context context) {
        return getSpriteFromId(context, R.drawable.obstacles_obstacle5);
    }

    @NotNull
    public static Bitmap getRandomBuildingObstacle(Context context) {
        int rand = (int) (Math.random() * 10) % 6;
        switch (rand) {
            case 1:
                return getObstacle1Sprite(context);
            case 2:
                return getObstacle2Sprite(context);
            case 3:
                return getObstacle3Sprite(context);
            case 4:
                return getObstacle4Sprite(context);
            case 5:
                return getObstacle5Sprite(context);
            default:
                Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
                return Bitmap.createBitmap(50, 50, conf); // this creates a MUTABLE bitmap

        }
    }
}
