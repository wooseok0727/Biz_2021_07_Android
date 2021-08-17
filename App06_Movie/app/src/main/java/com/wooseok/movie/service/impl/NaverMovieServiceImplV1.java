package com.wooseok.movie.service.impl;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wooseok.movie.adapter.MovieViewAdapter;
import com.wooseok.movie.config.NaverAPI;
import com.wooseok.movie.model.NaverMovieDTO;
import com.wooseok.movie.model.NaverParent;
import com.wooseok.movie.service.NaverMovieService;
import com.wooseok.movie.service.NaverRetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverMovieServiceImplV1 implements NaverMovieService {

    protected RecyclerView recyclerView;

    public NaverMovieServiceImplV1(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public void getMovie(String search) {

        Log.d("Naver Service","Start");

        Call<NaverParent> naverCall = NaverRetrofitClient.getApiClient()
                .getMovie(
                        NaverAPI.CLIENT_ID,
                        NaverAPI.CLIENT_SECRET,
                        search,
                        1,
                        10);

        naverCall.enqueue(new Callback<NaverParent>() {

            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {

                int resCode = response.code();
                if(resCode < 300) {
                    Log.d("영화 조회",response.body().toString());
                    List<NaverMovieDTO> movieList = response.body().items;
                    MovieViewAdapter viewAdapter = new MovieViewAdapter(movieList);
                    recyclerView.setAdapter(viewAdapter);
                    RecyclerView.LayoutManager layoutManager
                            = new LinearLayoutManager(recyclerView.getContext());
                    recyclerView.setLayoutManager(layoutManager);
                } else {
                    Log.d("오류",response.toString());
                }
            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {

            }
        });

    }
}
