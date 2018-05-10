package com.shenkar.reutleib.reutmobile;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.Build.VERSION_CODES;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.widget.Toast;

import com.shenkar.reutleib.reutmobile.model.BirthdayDb;
import com.shenkar.reutleib.reutmobile.model.BirthdayEntity;


import java.util.ArrayList;
import java.util.List;


public class BirthdayListActivity extends AppCompatActivity {

    public static ArrayList<BirthdayEntity> bList = new ArrayList<BirthdayEntity>();
    public static RecyclerView.Adapter mAdapter;
    public static String gName = null;
    public static String gDate = null;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.shenkar.reutleib.reutmobile.R.layout.activity_birthday_list);

        //get a ref to our r.view
        mRecyclerView = findViewById(R.id.birthdayList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        // and bind our adapter to the bday list
        mAdapter = new AdapterBirthday(bList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        // Create the observer which updates the UI.
        final Observer<List<BirthdayEntity>> logObserver = new Observer<List<BirthdayEntity>>() {

            @RequiresApi(api = VERSION_CODES.N)
            @Override
            public void onChanged(@Nullable final List<BirthdayEntity> newLog) {
                // Update the UI, in this case, a TextView.
                if(newLog.isEmpty()){
                    Toast.makeText(BirthdayListActivity.this, "Empty",Toast.LENGTH_LONG).show();
                }
                for(BirthdayEntity b: newLog) {
                    boolean inList = false;
                    for (BirthdayEntity bday: bList) {
                        if(bday.id == b.id) {
                            inList=true;
                            break;
                        }
                    }
                    if(!inList)
                        bList.add(b);
                    mAdapter.notifyDataSetChanged();
                }

            }
        };

        LiveData<List<BirthdayEntity>> BdayLiveData = BirthdayDb.getInstance(this).readBday();
        BdayLiveData.observe(this, logObserver);


        mAdapter.notifyDataSetChanged();
    }


    public static void addBirthday(String name, String data){
        bList.add(new BirthdayEntity(data,name));
    }
}
