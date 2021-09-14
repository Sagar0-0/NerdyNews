package com.example.android.nerdynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    String GUARDIAN_API="https://content.guardianapis.com/search?q=covid&show-fields=thumbnail&page-size=100&api-key=6575847b-7392-4838-bbce-b9a441a00c01";
    private String NEWS_API_URL="https://newsapi.org/v2/top-headlines?country=in&category=politics&apiKey=cdbba53bb0d34fa2a43789edbdf5feba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager=findViewById(R.id.viewpager);
        PagerAdapter adapter=new PagerAdapter(MainActivity.this,getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}