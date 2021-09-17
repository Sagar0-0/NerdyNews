package com.example.android.nerdynews;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.squareup.picasso.Picasso;

public class PagerAdapter extends FragmentPagerAdapter {


    private int tabNumber;

    public PagerAdapter(@NonNull FragmentManager fm,int behaviour,int tabs) {
        super(fm,behaviour);
        this.tabNumber=tabs;
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
        return tabNumber;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "\uD835\uDC07\uD835\uDC0E\uD835\uDC0C\uD835\uDC04";
            case 1:
                return "\uD835\uDC02\uD835\uDC0E\uD835\uDC15\uD835\uDC08\uD835\uDC03";
            case 2:
                return "\uD835\uDC0F\uD835\uDC0E\uD835\uDC0B\uD835\uDC08\uD835\uDC13\uD835\uDC08\uD835\uDC02\uD835\uDC12";
            case 3:
                return "\uD835\uDC07\uD835\uDC04\uD835\uDC00\uD835\uDC0B\uD835\uDC13\uD835\uDC07";
            case 4:
                return "\uD835\uDC12\uD835\uDC02\uD835\uDC08\uD835\uDC04\uD835\uDC0D\uD835\uDC02\uD835\uDC04";
            case 5:
                return "\uD835\uDC04\uD835\uDC0D\uD835\uDC13\uD835\uDC04\uD835\uDC11\uD835\uDC13\uD835\uDC00\uD835\uDC08\uD835\uDC0D\uD835\uDC0C\uD835\uDC04\uD835\uDC0D\uD835\uDC13";
            case 6:
                return "\uD835\uDC13\uD835\uDC04\uD835\uDC02\uD835\uDC07\uD835\uDC0D\uD835\uDC0E\uD835\uDC0B\uD835\uDC0E\uD835\uDC06\uD835\uDC18";
            case 7:
                return "\uD835\uDC12\uD835\uDC0F\uD835\uDC0E\uD835\uDC11\uD835\uDC13\uD835\uDC12";
            default:
                return null;
        }

    }
}
