package com.kolydas.greeksinbrno.specialities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kolydas.greeksinbrno.Adapters.FoodAdapter;
import com.kolydas.greeksinbrno.Data.MyData;
import com.kolydas.greeksinbrno.Models.Model;
import com.kolydas.greeksinbrno.R;

import java.util.ArrayList;

public class Courses extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Model> data;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courses, null);


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_courses);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<Model>();
        for (int i = 0; i < MyData.coursetitleArray.length; i++) {
            data.add(new Model(
                    MyData.coursenameArray[i],
                    MyData.coursetitleArray[i],
                    MyData.coursewebArray[i],
                    MyData.courseEmailArray[i],
                    MyData.courseDescArray[i]
            ));
        }

        adapter = new FoodAdapter(data);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
