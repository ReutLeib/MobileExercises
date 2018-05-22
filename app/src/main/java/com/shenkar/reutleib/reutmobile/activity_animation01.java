package com.shenkar.reutleib.reutmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class activity_animation01 extends AppCompatActivity {

    //
    Activity_Animation001_Layout animation001_LayoutView;
    private activity_animation01 mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation01);

        animation001_LayoutView = new Activity_Animation001_Layout(this);
        setContentView(animation001_LayoutView);
    }

    // TODO: pause in 9 video
    //
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        //ignore double actions (UP & DOWN)
//        switch (event.getAction()){
//            case MotionEvent.ACTION_UP:
//                handleClickEvent(event);
//                break;
//            default:
//                break;
//        }
//
//
//        return super.onTouchEvent(event);
////        Toast.makeText(activity_animation01.this,"Added!",Toast.LENGTH_LONG).show();
////        Toast.makeText(this,"add!",Toast.LENGTH_LONG).show();
//    }
//
//    private void handleClickEvent(MotionEvent event) {
//        Toast.makeText(this, "new ball", Toast.LENGTH_LONG).show();
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_animation01);
//
//        animation001_LayoutView = new Activity_Animation001_Layout(this);
//        setContentView(animation001_LayoutView);
//    }


    @Override
    protected void onPause() {
        super.onPause();

        animation001_LayoutView.pause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        animation001_LayoutView.resume();

    }
}
