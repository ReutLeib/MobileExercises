package com.shenkar.reutleib.reutmobile.model; /**
 * Created by USER on 23/05/2018.
 */

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Ball {

    private Bitmap bmap;
    public int x,y;
    public int x_dir, y_dir;
    public static final int speed = 10;

    public Ball(Bitmap bmap, int x, int y) {
        this.bmap = bmap;
        this.x = x;
        this.y = y;
        x_dir = 1;
        y_dir = 1;
    }

    public void move(Canvas canvas, int obstaclePosX, int obstaclePosY, int obstacleWidth, int obstacleHeight){
        if(range(x,y,obstaclePosX,obstaclePosY,obstacleWidth,obstacleHeight)){
            x_dir *= (-1);
            y_dir *= (-1);
        }
        if(x >= canvas.getWidth() || x <= 0 ){
            x_dir *= (-1);
        }
        if(y >= canvas.getHeight() || y <= 0 ){
            y_dir *= (-1);
        }
        else{
            y += (y_dir * speed);
            x += (x_dir * speed);
        }

    }

    private boolean range(int x, int y, int obstaclePosX, int obstaclePosY, int obstacleWidth, int obstacleHeight) {
        if(x >= obstaclePosX && y >= obstaclePosY && x <= obstaclePosX+obstacleWidth*2 && y <= obstaclePosY+obstacleHeight*2 ){
            return true;
        }
        return false;
    }

    public void draw(Canvas canvas, int obstaclePosX, int obstaclePosY, int obstacleWidth, int obstacleHeight) {
        move(canvas, obstaclePosX, obstaclePosY, obstacleWidth, obstacleHeight);
        canvas.drawBitmap(bmap, x, y,null);
    }
}
