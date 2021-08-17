package com.wooseok.movie.service;

import com.wooseok.movie.model.NaverParent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface NaverRetrofit {

    @GET("movie.json")
    public Call<NaverParent> getMovie(
            @Header("X-Naver-Client-Id") String clientID,
            @Header("X-Naver-Client-Secret") String clientSecret,
            @Query("query") String query,
            @Query("start") int start,
            @Query("display") int display
    );
}
