package com.example.android.nerdynews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface NewsApiInterface {
    String G_BASE_URL="https://content.guardianapis.com/";

    @GET("search")
    Call<ApiModal> getSearchedNews(
            @Query("q") String toSearch,
            @Query("show-fields") String thumbnail,
            @Query("page-size") int pageSize,
            @Query("order-by") String newest,
            @Query("api-key") String apiKey
    );


}
