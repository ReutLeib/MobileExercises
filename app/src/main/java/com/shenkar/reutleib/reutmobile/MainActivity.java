package com.shenkar.reutleib.reutmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private java.util.ArrayList<String> myDataset = new java.util.ArrayList<String>() {{
        add("Calculator");
        add("Birthday");
        add("item3");
        add("item4");
        add("item5");
        add("item6");
        add("item7");
        add("item8");
        add("item9");
        add("item10");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.mainList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset.toArray(new String[myDataset.size()] ));
        mRecyclerView.setAdapter(mAdapter);
    }

    public void OnBirth(android.view.View view){
        startActivity(new android.content.Intent(this, com.shenkar.reutleib.reutmobile.BirthdayActivity.class));
    }

    public void OnCalc(android.view.View view){
       startActivity(new android.content.Intent(this, com.shenkar.reutleib.reutmobile.CalculatorActivity.class));
    }

}
