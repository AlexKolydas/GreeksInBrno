package com.kolydas.greeksinbrno;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.kolydas.greeksinbrno.specialities.Courses;
import com.kolydas.greeksinbrno.specialities.Doctors;
import com.kolydas.greeksinbrno.specialities.Food;
import com.kolydas.greeksinbrno.specialities.RestSpecialities;

//Tutorial : https://www.youtube.com/watch?v=jpaHMcQDaDg

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(MainActivity.this);

        loadFragment(new Food()); //Displays the Food fragment by default on bottom navigation
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment= null;

        switch (menuItem.getItemId()){

            case R.id.navigation_food:
                fragment= new Food();
                break;

            case R.id.navigation_doctors:
                fragment= new Doctors();
                break;

            case R.id.navigation_courses:
                fragment= new Courses();
                break;

            case R.id.navigation_rest:
                fragment= new RestSpecialities();
                break;


        }
        return loadFragment(fragment);
    }

    //Load Fragment
    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
