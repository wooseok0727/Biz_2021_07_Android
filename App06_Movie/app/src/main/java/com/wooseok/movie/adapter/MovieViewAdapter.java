package com.wooseok.movie.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.wooseok.movie.R;
import com.wooseok.movie.model.NaverMovieDTO;

import java.util.List;

public class MovieViewAdapter extends RecyclerView.Adapter {

    private List<NaverMovieDTO> movieList;

    public MovieViewAdapter(List<NaverMovieDTO> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(
                R.layout.movie_item_view,parent,false
        );
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieViewHolder movieHolder = (MovieViewHolder) holder;
        NaverMovieDTO movieDTO = movieList.get(position);

        String item_title = movieDTO.getTitle();
        Spanned sp_title = Html.fromHtml(item_title,Html.FROM_HTML_MODE_LEGACY);
        movieHolder.item_title.setText(sp_title);

        String item_dir = movieDTO.getDirector().replace("|",",");
        if(item_dir.length() > 0) {
            if(item_dir.lastIndexOf(",") == item_dir.length()-1) {
                item_dir = item_dir.substring(0,item_dir.length() -1);
            }
        } else {
            item_dir = "정보 없음";
        }
        movieHolder.item_dir.setText("감독: " + item_dir);

        String item_act = movieDTO.getActor().replace("|",",");
        if(item_act.length() > 0) {
            if(item_act.lastIndexOf(",") == item_act.length()-1) {
                item_act = item_act.substring(0,item_act.length() -1);
            }
        } else {
            item_act = "정보 없음";
        }
        movieHolder.item_act.setText("출연: " + item_act);

        String item_rating = movieDTO.getUserRating();
        if(item_rating.equals("0.00")) {
            item_rating = "없음";
        }
        movieHolder.item_rating.setText("평점: " + item_rating);

        if(!movieDTO.getImage().isEmpty()) {
            Picasso.get().load(movieDTO.getImage()).into(movieHolder.item_image);
        }
    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        public TextView item_title;
        public ImageView item_image;
        public TextView item_dir;
        public TextView item_act;
        public TextView item_rating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            item_title = itemView.findViewById(R.id.movie_item_title);
            item_dir = itemView.findViewById(R.id.movie_item_dir);
            item_image = itemView.findViewById(R.id.movie_item_image);
            item_act = itemView.findViewById(R.id.movie_item_act);
            item_rating = itemView.findViewById(R.id.movie_item_rating);
        }
    }
}
