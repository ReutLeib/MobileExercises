package com.shenkar.reutleib.reutmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class activity_animation1 extends AppCompatActivity {

    private animationActivity_Layout animationActivity_LayoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animationActivity_LayoutView = new animationActivity_Layout(this);
        setContentView(animationActivity_LayoutView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                handleClickEvent(event);
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    private void handleClickEvent(MotionEvent event) {
        if(animationActivity_LayoutView.menuScreen){
            animationActivity_LayoutView.menuScreen = false;
        }
        else {
            if(animationActivity_LayoutView.validPosition((int)event.getRawX(), (int)event.getRawY())) {
                animationActivity_LayoutView.addBall((int)event.getRawX(), (int)event.getRawY());
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        animationActivity_LayoutView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        animationActivity_LayoutView.resume();
    }

}
