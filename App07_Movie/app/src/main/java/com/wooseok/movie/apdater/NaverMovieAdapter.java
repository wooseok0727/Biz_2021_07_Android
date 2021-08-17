package com.wooseok.movie.apdater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wooseok.movie.databinding.MovieItemViewBinding;
import com.wooseok.movie.model.MovieDTO;

import java.util.List;

public class NaverMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // 리스트를 보이기 위한 데이터터
   private List<MovieDTO> movieList;

    public NaverMovieAdapter(List<MovieDTO> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater
                = LayoutInflater.from(parent.getContext());
        MovieItemViewBinding movieBinding
                = MovieItemViewBinding.inflate(layoutInflater,parent,false);

        return new NaverMoiveViewHolder(movieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NaverMoiveViewHolder moiveViewHolder = (NaverMoiveViewHolder) holder;
        MovieDTO movieDTO = movieList.get(position);
        MovieItemViewBinding binding = moiveViewHolder.movieBinding;

        binding.movieItemTitle.setText(movieDTO.getTitle());
        binding.movieItemDirector.setText(movieDTO.getDirector());
        binding.movieItemActor.setText(movieDTO.getActor());

    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public static class NaverMoiveViewHolder extends RecyclerView.ViewHolder {

        public MovieItemViewBinding movieBinding;

        public NaverMoiveViewHolder(@NonNull MovieItemViewBinding movieBinding) {
            super(movieBinding.getRoot());
            this.movieBinding = movieBinding;
        }
    }
}
