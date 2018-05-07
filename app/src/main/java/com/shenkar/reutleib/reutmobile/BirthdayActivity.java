package com.shenkar.reutleib.reutmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BirthdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

    }

    public void submitDate(android.view.View view){

    }

    public void viewListBirth(android.view.View view){
        startActivity(new android.content.Intent(this, BirthdayListActivity.class));
    }

}
