package com.shenkar.reutleib.reutmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import java.sql.*;


public class BirthdayListActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private java.util.ArrayList<Date> birth = new java.util.ArrayList<Date>() {{
        add(new Date(2018,1,1));
        add(new Date(2018,1,2));
        add(new Date(2018,1,3));
        add(new Date(2018,1,4));
        add(new Date(2018,1,5));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.shenkar.reutleib.reutmobile.R.layout.activity_birthday_list);

        mRecyclerView = findViewById(R.id.birthdayList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new AdapterBirthday(birth.toArray(new Date[birth.size()] ));
        mRecyclerView.setAdapter(mAdapter);
    }
}
