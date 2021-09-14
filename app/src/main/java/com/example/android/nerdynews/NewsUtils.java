package com.example.android.nerdynews;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsUtils {
    private  static Retrofit retrofit=null;

    public static NewsApiInterface getApiInterface(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(NewsApiInterface.G_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(NewsApiInterface.class);
    }



}
