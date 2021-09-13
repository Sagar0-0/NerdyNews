package com.example.android.nerdynews;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidFragment extends Fragment {

    String NEWS_API_URL="https://newsapi.org/v2/top-headlines?country=in&q=covid&apiKey=cdbba53bb0d34fa2a43789edbdf5feba";
    final String apikey="cdbba53bb0d34fa2a43789edbdf5feba";
    private NewsAdapter mAdapter;
    private ArrayList<Articles> arrayList;
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
        NewsUtils.getApiInterface().getSearchNews("in","covid",apikey).enqueue(new Callback<NewsModal>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<NewsModal> call, Response<NewsModal> response) {

                if(response.isSuccessful()){
                    assert response.body() != null;
                    arrayList.addAll(response.body().getArticles());
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsModal> call, Throwable t) {

            }
        });
    }
}
