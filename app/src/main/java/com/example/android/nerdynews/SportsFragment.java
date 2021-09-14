package com.example.android.nerdynews;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsFragment extends Fragment {

    final String apikey="6575847b-7392-4838-bbce-b9a441a00c01";
    private NewsAdapter mAdapter;
    private ArrayList<Result> arrayList;
    private RecyclerView list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.news_list,container,false);

        list=rootView.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        arrayList=new ArrayList<>();
        mAdapter=new NewsAdapter(arrayList,getActivity());
        list.setAdapter(mAdapter);


        findNews();

        return rootView;
    }

    private void findNews() {
        NewsUtils.getApiInterface().getSearchedNews("sports","thumbnail",49,"newest",apikey).enqueue(new Callback<ApiModal>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<ApiModal> call, Response<ApiModal> response) {

                if(response.isSuccessful()){
                    assert response.body() != null;
                    arrayList.addAll(response.body().getResponse().getResults());
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ApiModal> call, Throwable t) {

            }
        });
    }
}