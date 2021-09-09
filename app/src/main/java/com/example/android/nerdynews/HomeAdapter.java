package com.example.android.nerdynews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HomeAdapter extends ArrayAdapter<HomeNewsItem> {
    public HomeAdapter(@NonNull Context context, List<HomeNewsItem> newsitem) {
        super(context,0,newsitem);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HomeNewsItem current =getItem(position);
        View listItemView=convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.home_list_item, parent, false);
        }





        return listItemView;
    }
}
