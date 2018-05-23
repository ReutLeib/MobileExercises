package com.shenkar.reutleib.reutmobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.shenkar.reutleib.reutmobile.model.Ball;
import java.util.ArrayList;

public class animationActivity_Layout extends SurfaceView implements Runnable {

    private static ArrayList<Ball> balls = new ArrayList<>();
    public static final int maxBalls = 10;
    public static int currBall = 0;
    private boolean canPlay = false;
    private Thread mPlayThread = null;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    private Bitmap playBitmap, background;
    public boolean menuScreen = true;
    public int bigNyanPosX, bigNyanPosY;
    public int bigNyanWidth, bigNyanHeight;

    public animationActivity_Layout(Context context) {
        super(context);
        surfaceHolder = getHolder();
        background = BitmapFactory.decodeResource(getResources(), R.drawable.name);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void run() {

        while(canPlay) {
            if(!surfaceHolder.getSurface().isValid()){
                continue;
            }
            canvas = surfaceHolder.lockCanvas();
            canvas.drawBitmap(background,0,0,null);
            if(menuScreen){
                playBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.playplay);
                canvas.drawBitmap(playBitmap, 400,  700, null);
            }
            else {
                display();
            }
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void display() {
        for(Ball ball : balls){
            ball.draw(canvas, bigNyanPosX, bigNyanPosY, bigNyanWidth, bigNyanHeight);
        }
    }


    public void pause(){
        canPlay = false;
        balls.clear();
        currBall = 0;
        while (true) {
            try {
                mPlayThread.join();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        mPlayThread = null;
    }

    public void resume() {
        canPlay = true;
        mPlayThread = new Thread(this);
        mPlayThread.start();

    }


    public void addBall(int x, int y) {
        if(balls.size() < maxBalls){
            balls.add(new Ball(BitmapFactory.decodeResource(getResources(), R.drawable.krug), x, y));
        }
        else {
            balls.clear();
        }
    }

    public boolean validPosition(int x, int y){

        boolean isValid = true;
        if(x > bigNyanPosX && x < bigNyanPosX + bigNyanWidth){
            isValid = false;
        }
        if(y > bigNyanPosY && y < bigNyanPosY + bigNyanHeight){
            isValid = false;
        }
        return isValid;
    }

}
