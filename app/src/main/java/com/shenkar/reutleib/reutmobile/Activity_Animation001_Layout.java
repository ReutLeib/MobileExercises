package com.shenkar.reutleib.reutmobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

/**
 * Created by USER on 21/05/2018.
 */

public class Activity_Animation001_Layout extends SurfaceView implements Runnable{

    //    private static ArrayList<NyanCat> cats = new ArrayList<>();
    private static final String TAG = "Activity_Animation001_Layout";

    Thread thread = null;
    boolean canDraw = false;

    Bitmap backGroundCheck;
    private Canvas canvas;
    SurfaceHolder surfaceHolder;


    Paint blue_paintbrush_fill;
    Paint blue_paintbrush_stroke;
    Bitmap ball_bm;
    int ball_x,ball_y,x_dir,y_dir,ball_hight,ball_width;

    public Activity_Animation001_Layout(Context context) {
        super(context);
        setBackgroundResource(R.drawable.ic_launcher_background);

        surfaceHolder = getHolder();


        ball_x = 300;
        ball_y = 470;

        // direction:
        x_dir = 5;
        y_dir = 5;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //ignore double actions (UP & DOWN)
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                //not working
                handleClickEvent(event);
                break;
            default:
                // working
                handleClickEvent(event);

                break;
        }
        Log.d("TAG","BBBBBBBBBB: onTouchEvent");
        // TODO: add balls here

        return super.onTouchEvent(event);
    }

    private void handleClickEvent(MotionEvent event) {
        Log.d("TAG","BBBBBBBBBB: handleClickEvent");
    }








    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }


    @Override
    public void run() {

        while(canDraw){

            if(!surfaceHolder.getSurface().isValid()){
                continue;
            }

            canvas = surfaceHolder.lockCanvas();
            drawBalls();
//            canvas.drawBitmap(backGroundCheck,0,0,null);
            surfaceHolder.unlockCanvasAndPost(canvas);

        }

    }

    private void drawBalls() {


        blue_paintbrush_fill = new Paint();
        blue_paintbrush_fill.setColor(Color.BLUE);
        blue_paintbrush_fill.setStyle(Style.FILL);

        blue_paintbrush_stroke = new Paint();
        blue_paintbrush_stroke.setColor(Color.BLUE);
        blue_paintbrush_stroke.setStyle(Style.STROKE);
        blue_paintbrush_stroke.setStrokeWidth(10);

        Rect rectangle001 = new Rect();
        rectangle001.set(310,225,50,475);
        canvas.drawRect(rectangle001,blue_paintbrush_fill);

        ball_bm = BitmapFactory.decodeResource(getResources(),R.drawable.krug);

        // find my width and hight direction:
        BitmapFactory.Options option = new Options();
        option.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),R.drawable.krug,option);
        ball_hight = option.outHeight;
        ball_width = option.outWidth;


        // move to another direction:
        if(ball_x >= canvas.getWidth()-ball_width){
            x_dir = -5;
        }

        if(ball_x <= 0){
            x_dir = +5;
        }

        if(ball_y >= canvas.getHeight()-ball_hight){
            y_dir = -5;
        }

        if(ball_y <= 0){
            y_dir = +5;
        }

        //update location:
        ball_x = ball_x + x_dir;
        ball_y = ball_y + y_dir;
        canvas.drawBitmap(ball_bm,ball_x,ball_y,null);

//        invalidate();
    }

    public void pause(){
        canDraw = false;

        while (true){

            try {
                thread.join();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread = null;
    }

    public void resume(){
        canDraw = true;
        thread = new Thread(this);
        thread.start();
    }


}
