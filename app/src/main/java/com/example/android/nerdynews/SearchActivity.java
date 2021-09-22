package com.example.android.nerdynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    final String apikey = "6575847b-7392-4838-bbce-b9a441a00c01";
    private NewsAdapter mAdapter;
    private ArrayList<Result> arrayList;
    private ProgressBar loading;
    private ImageView emptyImage;
    private ImageView nothingfound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        loading = findViewById(R.id.loading);
        loading.setVisibility(View.GONE);
        emptyImage=findViewById(R.id.emptyImage);
        emptyImage.setImageResource(R.drawable.searchnews);
        nothingfound=findViewById(R.id.nothingfound);
        nothingfound.setVisibility(View.GONE);

        RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<>();
        mAdapter = new NewsAdapter(arrayList, this);
        list.setAdapter(mAdapter);

        Button back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        //Check if there is an active connection to the internet
        if (networkInfo == null) {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            arrayList.clear();
            emptyImage.setVisibility(View.VISIBLE);
            emptyImage.setImageResource(R.drawable.ic_internet_error);
        }
    }

    private void findNews(String toSearch) {
        NewsUtils.getApiInterface().getSearchedNews(toSearch, "thumbnail", 49, "relevance", apikey).enqueue(new Callback<ApiModal>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<ApiModal> call, Response<ApiModal> response) {

                if (response.isSuccessful()) {
                    assert response.body() != null;
                    arrayList.addAll(response.body().getResponse().getResults());
                    mAdapter.notifyDataSetChanged();
                    loading.setVisibility(View.GONE);
                    if(arrayList.isEmpty()){
                        nothingfound.setVisibility(View.VISIBLE);
                        nothingfound.setImageResource(R.drawable.nothingfound);
                        Toast.makeText(SearchActivity.this, "No matching result found for latest updates!", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<ApiModal> call, Throwable t) {

            }
        });
    }

    public void searchbutton(View view){
        try{

            ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            //Check if there is an active network connection to the internet
            if (networkInfo != null && networkInfo.isConnected()) {
                emptyImage.setImageResource(R.drawable.searchnews);

                EditText editText = findViewById(R.id.edittext);
                String searched = editText.getText().toString();
                String toSearch = searched.replaceAll(" ", "%20");
                if(searched.isEmpty()){
                    Toast.makeText(this, "Please enter some keyword first", Toast.LENGTH_SHORT).show();
                }else{

                    emptyImage.setVisibility(View.GONE);
                    nothingfound.setVisibility(View.GONE);
                    loading.setVisibility(View.VISIBLE);

                    arrayList.clear();
                    mAdapter.notifyDataSetChanged();
                    findNews(toSearch);


                    // hide keyboard once search button is clicked
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                }


            } else {
                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                arrayList.clear();
                mAdapter.notifyDataSetChanged();
                loading.setVisibility(View.GONE);
                nothingfound.setVisibility(View.GONE);
                emptyImage.setVisibility(View.VISIBLE);
                emptyImage.setImageResource(R.drawable.ic_internet_error);
            }
        }catch (Exception e){}
    }
}

