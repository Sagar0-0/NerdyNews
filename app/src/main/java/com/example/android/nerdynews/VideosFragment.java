package com.example.android.nerdynews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class VideosFragment extends Fragment {
    private VideoAdapter vdoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.word_list,container,false);

        ListView vdolist=rootView.findViewById(R.id.list);
        vdoAdapter=new VideoAdapter(getActivity(),new ArrayList<VideoNewsItem>());
        vdolist.setAdapter(vdoAdapter);

        return rootView;
    }

}
