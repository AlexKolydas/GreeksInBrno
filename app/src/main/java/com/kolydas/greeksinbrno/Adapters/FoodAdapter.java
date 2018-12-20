package com.kolydas.greeksinbrno.Adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.CallSuper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.kolydas.greeksinbrno.Models.Model;
import com.kolydas.greeksinbrno.R;



import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    //ArrayList that gets all the model stuff
    private ArrayList<Model> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewTitle;
        TextView textViewWeb;
        TextView textViewEmail;
        TextView textViewDesc;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.nameText);
            this.textViewTitle = (TextView) itemView.findViewById(R.id.titleText);
            this.textViewWeb = (TextView) itemView.findViewById(R.id.webTextView);
            this.textViewEmail = (TextView) itemView.findViewById(R.id.emailTextView);
            this.textViewDesc = (TextView) itemView.findViewById(R.id.descriptionTextView);
        }
    }

    //gets from Model FoodModel
    public FoodAdapter(ArrayList<Model> data) {
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
        TextView textViewWeb = holder.textViewWeb;
        TextView textViewEmail = holder.textViewEmail;
        TextView textViewDesc = holder.textViewDesc;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewTitle.setText(dataSet.get(listPosition).getTitle());
        textViewDesc.setText(dataSet.get(listPosition).getDesc());

        //Website
        textViewWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!dataSet.get(listPosition).getWeb().equals("")) { //If URL is not empty then go to url
                    Intent openLink = new Intent(Intent.ACTION_VIEW, Uri.parse(dataSet.get(listPosition).getWeb()));
                    v.getContext().startActivity(openLink);
                }
            }
        });

        //Email
        textViewEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!dataSet.get(listPosition).getEmail().equals("")) { //If email is not empty then send email
                    Intent sendIntent = new Intent(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_EMAIL, dataSet.get(listPosition).getEmail());
                    sendIntent.setType("text/html");
                    v.getContext().startActivity(sendIntent);
                }
            }
        });

}

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
