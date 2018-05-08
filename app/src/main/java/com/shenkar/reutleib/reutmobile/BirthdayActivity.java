package com.shenkar.reutleib.reutmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.util.*;
import android.widget.*;
import java.sql.*;
import android.widget.CalendarView.*;


public class BirthdayActivity extends AppCompatActivity {

    private static final String TAG = "BirthdayActivity";
    EditText name;
    CalendarView calView;
    Button btnEnter;
    String dateString;
    Boolean flagToCheckIsFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

        name = findViewById(com.shenkar.reutleib.reutmobile.R.id.firstName);
        calView = (android.widget.CalendarView) findViewById(com.shenkar.reutleib.reutmobile.R.id.calendarView);
        btnEnter = findViewById(com.shenkar.reutleib.reutmobile.R.id.btnpushBirthday);


        if(flagToCheckIsFirst){
            long l = calView.getDate();
            dateString = android.text.format.DateFormat.format("MM/dd/yyyy", new Date(l)).toString();
            calView.setOnDateChangeListener(new OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(@android.support.annotation.NonNull CalendarView view, int year, int month, int dayOfMonth) {
                    dateString = dayOfMonth+"."+month+"."+year;
                }
            });
            flagToCheckIsFirst = false;
        }

        btnEnter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                // TODO: save to database
                calView.setOnDateChangeListener(new OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@android.support.annotation.NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        dateString = dayOfMonth+"."+month+"."+year;
                    }
                });
                Log.d(TAG,"Clicked firstName:" + name.getText().toString());
                Log.d(TAG,"DATE-STRING:" + dateString);

            }
        });
    }


    public void viewListBirth(View view){
        startActivity(new android.content.Intent(this, BirthdayListActivity.class));
    }

}
