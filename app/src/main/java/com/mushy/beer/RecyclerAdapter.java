// Copyright 2018 Adam Gaetano. All Rights Reserved.

package com.mushy.beer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Beer> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder (View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
        }

    }

    public RecyclerAdapter (ArrayList<Beer> dataSet) {

        this.dataSet = dataSet;

    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_textview, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, int position) {
        String text = dataSet.get(position).getName() + " (" + dataSet.get(position).getRating() + ")";
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount () {
        return dataSet.size();
    }
}
