package com.shenkar.reutleib.reutmobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by USER on 22/05/2018.
 */

public class animationActivity_Layout extends SurfaceView implements Runnable {
    Thread thread = null;
    boolean canDraw = false;

    Bitmap backGroundCheck;
    Canvas canvas;
    SurfaceHolder surfaceHolder;

    Paint blue_paintbrush_fill;
    Paint blue_paintbrush_stroke;
    Bitmap ball_bm;
    Path square;

    int ball_x,ball_y,x_dir,y_dir,ball_hight,ball_width;

    public animationActivity_Layout(Context context) {
        super(context);

        surfaceHolder = getHolder();
//        backGroundCheck = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
//        setBackgroundResource(R.drawable.ic_launcher_background);
//
//        ball_bm = BitmapFactory.decodeResource(getResources(),R.drawable.krug);
//        ball_x = 300;
//        ball_y = 470;
//        // direction:
//        x_dir = 5;
//        y_dir = 5;

    }


    @Override
    public void run() {
        //ready to brushes

        prepPaintBrushes();

        while(canDraw){

            if(!surfaceHolder.getSurface().isValid()){
                continue;
            }

            canvas = surfaceHolder.lockCanvas();
//            motionBall(5);
            canvas.drawBitmap(backGroundCheck,0,0,null);
            drawSquare(130,130,650,650);
            surfaceHolder.unlockCanvasAndPost(canvas);

        }

    }

    private void drawSquare(int x1, int y1, int x2, int y2) {
        square = new Path();
        square.moveTo(x1,y1);
        square.lineTo(x2,y1);
        square.moveTo(x2,y1);
        square.lineTo(x2,y2);
        square.moveTo(x2,y2);
        square.lineTo(x1,y2);
        square.moveTo(x1,y2);
        square.lineTo(x1,y1);

        this.canvas.drawPath(square,blue_paintbrush_stroke);

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

    private void prepPaintBrushes(){
        blue_paintbrush_fill = new Paint();
        blue_paintbrush_fill.setColor(Color.BLUE);
        blue_paintbrush_fill.setStyle(Style.FILL);

        blue_paintbrush_stroke = new Paint();
        blue_paintbrush_stroke.setColor(Color.BLUE);
        blue_paintbrush_stroke.setStyle(Style.STROKE);
        blue_paintbrush_stroke.setStrokeWidth(10);
    }

    private void motionBall(int speed){

        // find my width and hight direction:
//        BitmapFactory.Options option = new Options();
//        option.inJustDecodeBounds = true;
//        BitmapFactory.decodeResource(getResources(),R.drawable.krug,option);
//        ball_hight = option.outHeight;
//        ball_width = option.outWidth;

        if(ball_x >= canvas.getWidth()-ball_width){
            x_dir = -speed;
        }

        if(ball_x <= 0){
            x_dir = +speed;
        }

        if(ball_y >= canvas.getHeight()-ball_hight){
            y_dir = -speed;
        }

        if(ball_y <= 0){
            y_dir = +speed;
        }

//        //update location:
//        ball_x = ball_x + x_dir;
//        ball_y = ball_y + y_dir;
////        canvas.drawBitmap(ball_bm,ball_x,ball_y,null);
//
//        invalidate();
    }

}
