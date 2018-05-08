package com.shenkar.reutleib.reutmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.util.*;
import android.widget.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import android.widget.CalendarView.*;

import com.shenkar.reutleib.reutmobile.model.BirthdayDb;
import com.shenkar.reutleib.reutmobile.model.BirthdayEntity;


public class BirthdayActivity extends AppCompatActivity {

    private static final String TAG = "BirthdayActivity";
//    private ArrayList<BirthdayEntity> bList = new ArrayList<BirthdayEntity>();
//    private RecyclerView mRecyclerView;
//    private AdapterBirthday mAdapterBirthday;

    EditText name;
    String nameString;
    String dateString;
    CalendarView calView;
    Button btnEnter;
    Boolean flagToCheckIsFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

        name = findViewById(R.id.firstName);
        calView = findViewById(R.id.calendarView);
        btnEnter = findViewById(R.id.btnpushBirthday);

//        //bind our adapter to the bday list
//        mAdapterBirthday = new AdapterBirthday(bList);
//        //get a ref to our r.view
//        mRecyclerView = findViewById(R.id.birthdayList);
//        mRecyclerView.setAdapter(mAdapterBirthday);
//
//        mRecyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());



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

                //todo: replace this with writeToLog
                //BirthdayListActivity.addBirthday(name.getText().toString(),dateString);
                BirthdayListActivity.gName = name.getText().toString();
                BirthdayListActivity.gDate = dateString;


                //todo:write to db --done
                BirthdayDb.getInstance(BirthdayActivity.this).writeToCaptainsLog(new BirthdayEntity(dateString, name.getText().toString()));

                Toast.makeText(BirthdayActivity.this,"Added!",Toast.LENGTH_LONG).show();
                Log.d(TAG,"Clicked firstName:" + name.getText().toString());
                Log.d(TAG,"DATE-STRING:" + dateString);

            }
        });
    }


    public void viewListBirth(View view){
        startActivity(new android.content.Intent(this, BirthdayListActivity.class));
    }

}
