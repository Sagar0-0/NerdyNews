package com.example.android.nerdynews;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {


    private final Context mContext;

    public MainPagerAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        mContext=context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new HomeFragment();
        }else if(position==1){
            return new VideosFragment();
        }else{
            return new TopicsFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Home";
        }else if(position==1){
            return "Videos";
        }else{
            return "Topics";
        }
    }
}
