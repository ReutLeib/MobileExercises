package com.shenkar.reutleib.reutmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class activity_animation1 extends AppCompatActivity {

    animationActivity_Layout animationActivity_LayoutView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_animation1);
        animationActivity_LayoutView = new animationActivity_Layout(this);
        setContentView(animationActivity_LayoutView);
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
