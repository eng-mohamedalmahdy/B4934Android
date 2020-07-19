package com.example.b4934.core;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;

import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;


import com.example.b4934.gameobjects.Player;
import com.example.b4934.gameobjects.obstacles.BaseObstacle;
import com.example.b4934.utils.Constants;
import com.example.b4934.utils.SpritesFactory;

import java.util.ArrayList;

@SuppressLint("ViewConstructor")
public class Level extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private Context context;
    int width;
    int height;
    double ratio;
    final private int maxWidth = 168;

    private Bitmap levelBackground;
    private Player player;
    private ArrayList<MovingCharacterSprite> movingCharacterSprites;

    public Level(Context context, Player player) {
        super(context);
        this.context = context;
        this.player = player;
        init();
        movingCharacterSprites.add(player);
    }

    public Level(Context context, Player player, Bitmap levelBackground) {
        super(context);
        this.levelBackground = levelBackground;
        this.context = context;
        this.player = player;
        init();
        movingCharacterSprites.add(player);


    }

    public void generateObstacles(){
        int parts = Constants.screenWidth / 5;
        int start = parts + 1, mn = start, mx = 2 * parts;
        for(int part = 1; part < parts; part++){
            int randX = (int)Math.random() * (mx - mn + 1) + mn;
            BaseObstacle ob = new BaseObstacle(SpritesFactory.getRandomBuildingObstacle(context), randX);
            addObject(ob);
            mn = mx + 1;
            mx *= parts;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
        movingCharacterSprites = new ArrayList<>();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        ratio = (double) levelBackground.getWidth() / (double) levelBackground.getHeight();
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(Constants.screenWidth * 3, Constants.screenHeight);
        setLayoutParams(params);

        setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL: {
                    player.setUp(false);
                    break;
                }
                case MotionEvent.ACTION_DOWN: {
                    player.setUp(true);
                }

            }
            return true;
        });

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update() {
        for (MovingCharacterSprite movingCharacterSprite : movingCharacterSprites) {
            movingCharacterSprite.update();
            if (movingCharacterSprite.getRect().intersect(player.getRect()) &&
                movingCharacterSprite.getWeight() != player.getWeight()) {
                Log.d("game report", "update: game over");
                //thread.setRunning(false);
            }
        }
        float newX = getX() - player.getxVelocity();

        setX(newX);
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (levelBackground != null) {
            Rect dest = new Rect(0, 0, (int) (height * ratio), height);
            Paint paint1 = new Paint();
            paint1.setFilterBitmap(true);
            paint1.setAntiAlias(true);
            canvas.drawColor(Color.rgb(18, 48, 134));
            //canvas.drawBitmap(levelBackground, null, dest, paint1);
            invalidate();
        }
        if (canvas != null) {
            for (MovingCharacterSprite movingCharacterSprite : movingCharacterSprites) {
                invalidate();
                movingCharacterSprite.draw(canvas);
            }
        }
    }

    public ArrayList<MovingCharacterSprite> getMovingCharacterSprites() {
        return movingCharacterSprites;
    }

    public Bitmap getLevelBackground() {
        return levelBackground;
    }

    public void setLevelBackground(Bitmap levelBackground) {
        this.levelBackground = levelBackground;
    }

    public MainThread getThread() {
        return thread;
    }

    public void addObject(MovingCharacterSprite object) {
        movingCharacterSprites.add(object);
        invalidate();
    }

    public void removeObject(MovingCharacterSprite object) {
        movingCharacterSprites.remove(object);
        invalidate();
    }

    public int getMaxWidth() {
        return maxWidth;
    }
}
