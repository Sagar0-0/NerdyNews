package com.example.android.nerdynews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface NewsApiInterface {
    String GUARDIAN_API="https://content.guardianapis.com/search?q=covid&show-fields=thumbnail&page-size=100&api-key=6575847b-7392-4838-bbce-b9a441a00c01";
    String NEWS_API_URL="https://newsapi.org/v2/top-headlines?country=in&q=covid&apiKey=cdbba53bb0d34fa2a43789edbdf5feba";

    String G_BASE_URL="https://content.guardianapis.com/";
    String BASE_URL="https://newsapi.org/v2/";
    final String api_key ="6575847b-7392-4838-bbce-b9a441a00c01";

    @GET("search")
    Call<ApiModal> getSearchedNews(
            @Query("q") String toSearch,
            @Query("show-fields") String thumbnail,
            @Query("page-size") int pageSize,
            @Query("order-by") String newest,
            @Query("api-key") String apiKey
    );


}
