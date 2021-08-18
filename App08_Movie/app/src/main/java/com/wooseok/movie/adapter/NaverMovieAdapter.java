package com.wooseok.movie.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wooseok.movie.databinding.MovieItemViewBinding;
import com.wooseok.movie.model.MovieDTO;

import java.util.List;

public class NaverMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieDTO> movieList;

    public NaverMovieAdapter(List<MovieDTO> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MovieItemViewBinding movieItemViewBinding
                = MovieItemViewBinding.inflate(layoutInflater,parent,false);

        return new MovieViewHolder(movieItemViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieViewHolder viewHolder = (MovieViewHolder) holder;
        MovieDTO movieDTO = movieList.get(position);
        MovieItemViewBinding movieItemViewBinding = viewHolder.movieItemViewBinding;

        Spanned sTitle = Html.fromHtml(movieDTO.getTitle(),Html.FROM_HTML_MODE_LEGACY);
        movieItemViewBinding.movieItemTitle.setText(sTitle);

        String mDirector = movieDTO.getDirector().replace("|",",");
        if(mDirector.lastIndexOf(",") == mDirector.length() - 1) {
            mDirector = mDirector.substring(0,mDirector.length() -1 );
        }
        movieItemViewBinding.movieItemDirect.setText("감독: " + mDirector);

        String mActor = movieDTO.getActor().replace("|",",");
        if(mActor.lastIndexOf(",") == mActor.length() - 1) {
            mActor = mActor.substring(0,mActor.length() -1 );
        }
        movieItemViewBinding.movieItemActor.setText("출연: " + mActor);

        movieItemViewBinding.movieItemRating.setText("평점: " + movieDTO.getUserRating());

        /*
            glide를 사용하여 이미지 링크를 참조하여
            이미지 표현하기
         */
        if(!movieDTO.getImage().isEmpty()) {
            Glide.with(movieItemViewBinding.movieItemImage.getContext())
                    .load(movieDTO.getImage())
                    .into(movieItemViewBinding.movieItemImage);
        }
    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        public MovieItemViewBinding movieItemViewBinding;

        public MovieViewHolder(@NonNull MovieItemViewBinding movieItemViewBinding) {
            super(movieItemViewBinding.getRoot());
            this.movieItemViewBinding = movieItemViewBinding;
        }
    }
}
