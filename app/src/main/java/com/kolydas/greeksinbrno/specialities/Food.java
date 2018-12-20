package com.kolydas.greeksinbrno.specialities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kolydas.greeksinbrno.Adapters.FoodAdapter;
import com.kolydas.greeksinbrno.Data.MyData;
import com.kolydas.greeksinbrno.Models.FoodModel;
import com.kolydas.greeksinbrno.R;

import java.util.ArrayList;

public class Food extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<FoodModel> data;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food, null);


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_food);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<FoodModel>();
        for (int i = 0; i < MyData.titleArray.length; i++) {
            data.add(new FoodModel(
                    MyData.nameArray[i],
                    MyData.titleArray[i],
                    MyData.webArray[i]
            ));
        }

        adapter = new FoodAdapter(data);
        recyclerView.setAdapter(adapter);

        return view;


    }

}
