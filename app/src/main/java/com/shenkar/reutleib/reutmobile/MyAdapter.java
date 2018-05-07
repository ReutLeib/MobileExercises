package com.shenkar.reutleib.reutmobile;

/**
 * Created by USER on 03/05/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.*;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] mDataset;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(android.view.ViewGroup v) {
            super(v);
            android.widget.TextView tv =  v.findViewById(com.shenkar.reutleib.reutmobile.R.id.txt);

            mTextView = tv;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        android.view.ViewGroup v = (android.view.ViewGroup) android.view.LayoutInflater.from(parent.getContext())
                .inflate(com.shenkar.reutleib.reutmobile.R.layout.my_text_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
