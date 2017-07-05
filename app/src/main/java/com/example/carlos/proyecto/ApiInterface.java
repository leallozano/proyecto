package com.example.carlos.proyecto;

/**
 * Created by Carlos on 7/3/2017.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface  {


        @GET("movie/top_rated")
        Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);

        @GET("movie/popular")
        Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

        @GET("movie/upcoming")
        Call<MovieResponse> getUpcomingMovies(@Query("api_key") String apiKey);

        @GET("movie/latest")
        Call<MovieResponse> getLatestMovies(@Query("api_key") String apiKey);

        @GET("movie/{id}")
        Call<Movie> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);



}
