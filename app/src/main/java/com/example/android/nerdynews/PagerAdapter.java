package com.example.android.nerdynews;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {


    private final Context mContext;

    public PagerAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        mContext=context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new CovidFragment();
            case 2:
                return new PoliticsFragment();
            case 3:
                return new HealthFragment();
            case 4:
                return new ScienceFragment();
            case 5:
                return new EntertainmentFragment();
            case 6:
                return new TechFragment();
            case 7:
                return new SportsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "HOME";
            case 1:
                return "COVID";
            case 2:
                return "POLITICS";
            case 3:
                return "HEALTH";
            case 4:
                return "SCIENCE";
            case 5:
                return "ENTERTAINMENT";
            case 6:
                return "TECHNOLOGY";
            case 7:
                return "SPORTS";
            default:
                return null;
        }
    }
}
