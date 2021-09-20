package com.example.android.nerdynews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.io.File;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView nav_view;
    private DrawerLayout drawerlayout;
    private ActionBarDrawerToggle toggle;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private PagerAdapter pagerAdapter;
    private ImageView noInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//      binding views with its corresponding variables
        drawerlayout=findViewById(R.id.drawer_layout);
        nav_view=findViewById(R.id.nav_view);
        viewPager=findViewById(R.id.viewpager);
        tabLayout =findViewById(R.id.main_tabs);
        noInternet=findViewById(R.id.no_internet);

//      setting custom toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//      setting and attaching custom toggle button(in toolbar)
        toggle=new ActionBarDrawerToggle(this,drawerlayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

//      drawer items actions
        nav_view.setNavigationItemSelectedListener(this);
//      checking(highlighting) home in drawer as default check
        nav_view.setCheckedItem(R.id.home);

        settingAdapter();
//      checking internet connection and setting image resource
        checkingNetwork();


    }

    public void settingAdapter(){

//      setting pager adapter with viewpager
        pagerAdapter=new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
//      to get selected tab's respective fragment(not neccasary to create method)
        gettingWithTabs();
    }

//  custom method to check and access network state
    public void checkingNetwork(){

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        //Check if there is an active network connection to the internet
        if (networkInfo != null && networkInfo.isConnected()) {
            noInternet.setVisibility(View.GONE);
            settingAdapter();
        }else{
            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            noInternet.setImageResource(R.drawable.twitter);
            noInternet.setOnClickListener(v -> checkingNetwork());
        }
    }

//  moving fragment by tab clicks
    public void gettingWithTabs(){

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
//                  checking(highlighting) current item in drawer
                    nav_view.setCheckedItem(checkedByTab(tab.getPosition()));
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

//  **setting drawer selected item according to tabs**
    public int checkedByTab(int num){
        switch(num){
            case 0:
                return R.id.home;
            case 1:
                return R.id.covid;
            case 2:
                return R.id.politics;
            case 3:
                return R.id.health;
            case 4:
                return R.id.science;
            case 5:
                return R.id.entertainment;
            case 6:
                return R.id.technology;
            default:
                return R.id.sports;
        }
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

            case R.id.about_us:
                Intent intent=new Intent(MainActivity.this,AboutUs.class);
                startActivity(intent);
                break;

            case R.id.contact_us:
                String url="https://www.linkedin.com/messaging/compose/?recipient=ACoAADP_ivIBZr_lM4ddPfnuC0eFzae8ko-E48s";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
                break;

            case R.id.report_bug:
                String s="https://github.com/Sagar0-0/NerdyNews/issues/new";
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(s)));
                break;


            case R.id.share_support:
                Intent intent2=new Intent(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                String link="Download this News android application by SAGAR: https://play.google.com";
                intent2.putExtra(Intent.EXTRA_TEXT,link);
                startActivity(Intent.createChooser(intent2,"ShareVia"));
                break;

            case R.id.exit:
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you really want to exit ?");
                builder.setCancelable(true);
                builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog= builder.create();
                alertDialog.show();
                break;

        }
        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.searchbutton:
                Intent searchIntent=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(searchIntent);
                break;
            case R.id.about_us:
                Intent intent=new Intent(MainActivity.this,AboutUs.class);
                startActivity(intent);
                break;
            case R.id.contact_us:
                String url="https://www.linkedin.com/messaging/compose/?recipient=ACoAADP_ivIBZr_lM4ddPfnuC0eFzae8ko-E48s";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
                break;
            case R.id.report_bug:
                String s="https://github.com/Sagar0-0/NerdyNews/issues/new";
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(s)));
                break;
            case R.id.share_support:
                Intent intent2=new Intent(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                String link="Download this News android application by SAGAR: https://play.google.com";
                intent2.putExtra(Intent.EXTRA_TEXT,link);
                startActivity(Intent.createChooser(intent2,"ShareVia"));
                break;
            case R.id.exit:
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you really want to exit ?");
                builder.setCancelable(true);
                builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog= builder.create();
                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}