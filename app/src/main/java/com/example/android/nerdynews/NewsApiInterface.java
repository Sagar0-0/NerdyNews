package com.example.android.nerdynews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface NewsApiInterface {
    String BASE_URL="https://newsapi.org/v2/";
    final String apikey="cdbba53bb0d34fa2a43789edbdf5feba";

    @GET("top-headlines")
    Call<NewsModal> getNews(
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<NewsModal> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<NewsModal> getSearchNews(
            @Query("country") String country,
            @Query("q") String search,
            @Query("apiKey") String apiKey
    );


}
