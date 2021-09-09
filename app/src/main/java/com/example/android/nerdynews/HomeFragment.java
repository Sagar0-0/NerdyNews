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

public class HomeFragment extends Fragment {
    private HomeAdapter homeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.word_list,container,false);

        ListView homelist=rootView.findViewById(R.id.list);
        homeAdapter=new HomeAdapter(getActivity(),new ArrayList<HomeNewsItem>());
        homelist.setAdapter(homeAdapter);

        return rootView;
    }
}
