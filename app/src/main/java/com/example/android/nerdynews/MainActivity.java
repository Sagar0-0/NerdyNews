package com.example.android.nerdynews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    NavigationView nav_view,options;
    DrawerLayout drawerlayout;
    ActionBarDrawerToggle toggle;
    ViewPager viewPager;
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerlayout=findViewById(R.id.drawer_layout);
        nav_view=findViewById(R.id.nav_view);
        options=findViewById(R.id.options_menu);
        viewPager=findViewById(R.id.viewpager);
        tabLayout =findViewById(R.id.main_tabs);

        toggle=new ActionBarDrawerToggle(this,drawerlayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        nav_view.setNavigationItemSelectedListener(this);



        pagerAdapter=new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        gettingWithTabs();

    }

    public void gettingWithTabs(){


            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.covid:
                viewPager.setCurrentItem(1);
                break;

            case R.id.politics:
                viewPager.setCurrentItem(2);
                break;

            case R.id.health:
                viewPager.setCurrentItem(3);
                break;

            case R.id.science:
                viewPager.setCurrentItem(4);
                break;

            case R.id.entertainment:
                viewPager.setCurrentItem(5);
                break;

            case R.id.technology:
                viewPager.setCurrentItem(6);
                break;

            case R.id.sports:
                viewPager.setCurrentItem(7);
                break;

        }
        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerlayout.isDrawerOpen(GravityCompat.START)){
            drawerlayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.searchbutton:
                viewPager.setCurrentItem(7);
                break;
            case R.id.about_us:
                viewPager.setCurrentItem(3);
                break;
            case R.id.contact_us:
                viewPager.setCurrentItem(4);
                break;
            case R.id.rate_us:
                viewPager.setCurrentItem(5);
                break;
            case R.id.exit:
                viewPager.setCurrentItem(6);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}