package com.example.android.nerdynews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class VideoAdapter extends ArrayAdapter<VideoNewsItem> {
    public VideoAdapter(@NonNull Context context, List<VideoNewsItem> newsitem) {
        super(context,0,newsitem);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        VideoNewsItem current =getItem(position);
        View listItemView=convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.home_list_item, parent, false);
        }





        return listItemView;
    }
}
