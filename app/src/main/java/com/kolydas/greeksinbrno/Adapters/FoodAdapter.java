package com.kolydas.greeksinbrno.Adapters;

import android.content.Intent;
import android.net.Uri;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.kolydas.greeksinbrno.Models.FoodModel;
import com.kolydas.greeksinbrno.R;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    //ArrayList that gets all the model stuff
    private ArrayList<FoodModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewTitle;
        TextView textViewWeb;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.nameText);
            this.textViewTitle = (TextView) itemView.findViewById(R.id.titleText);
            this.textViewWeb=(TextView) itemView.findViewById(R.id.webTextView);
        }
    }

    //gets from Model FoodModel
    public FoodAdapter(ArrayList<FoodModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout_food, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewTitle = holder.textViewTitle;
        TextView textViewWeb=holder.textViewWeb;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewTitle.setText(dataSet.get(listPosition).getTitle());

        textViewWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openLink = new Intent(Intent.ACTION_VIEW,Uri.parse(dataSet.get(listPosition).getWeb()));
                v.getContext().startActivity(openLink);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
