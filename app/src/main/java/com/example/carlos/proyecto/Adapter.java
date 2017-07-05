package com.example.carlos.proyecto;

/**
 * Created by Carlos on 7/3/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        ImageView backbg;



        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            backbg = (ImageView) v.findViewById(R.id.backbg);
        }
    }

    public Adapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public Adapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
        Picasso.with(context).load("https://image.tmdb.org/t/p/w300_and_h450_bestv2" + movies.get(position).getBackdropPath()).resize(200, 250).into(holder.backbg);


        holder.movieTitle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Detail.class);
                i.putExtra("ID", movies.get(position).getId());
                i.putExtra("Title", movies.get(position).getTitle());
                i.putExtra("Overview", movies.get(position).getOverview());
                i.putExtra("Description", movies.get(position).getOverview());
                i.putExtra("rating", movies.get(position).getVoteAverage().toString());
                i.putExtra("im",  movies.get(position).getBackdropPath());

                i.putExtra("listName", "Original Lenguage: " + movies.get(position).getOriginalLanguage() + ". Popularity: " + movies.get(position).getPopularity() + ". Vote Count: " + movies.get(position).getVoteCount() );

                i.putIntegerArrayListExtra("list", (ArrayList<Integer>) movies.get(position).getGenreIds());
                i.putExtra("Estreno",  movies.get(position).getReleaseDate());
                i.putExtra("poster_path",  movies.get(position).getPosterPath());

                context.startActivity(i);
                //((MainActivity) context).startActivity(Detail.class,bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
