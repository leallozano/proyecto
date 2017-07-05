package com.example.carlos.proyecto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    private final static String API_KEY = "b5297900952d5edc9daf9f34cd717a8a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }


    }


    @Override
    public boolean  onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu,menu);
        return  true;


    }

    public void ejecutar_class_inf(View v){


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.getPopularMovies:
                consulta(1);

            case R.id.getTopRatedMovies:
                consulta(2);

            case R.id.getUpcomingMovies:
                consulta(3);
            case R.id.getMovieDetails:
                consulta(4);
            default:

                return super.onOptionsItemSelected(item);
        }

    }

    private void consulta(int getType) {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movie_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClientRetrofit.getClient().create(ApiInterface.class);



        if (getType == 1) {
            Call<MovieResponse> call = apiService.getPopularMovies (API_KEY);
            call.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse>call, Response<MovieResponse> response) {
                    List<Movie> movies = response.body().getResults();
                    Log.d(TAG, "Number of movies received: " + movies.size());
                    Toast.makeText(MainActivity.this, "Number of movies received: " + movies.size(), Toast.LENGTH_LONG).show();
                    recyclerView.setAdapter(new Adapter(movies, R.layout.list_item_movie, getApplicationContext()));
                }

                @Override
                public void onFailure(Call<MovieResponse>call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });

        } else if (getType == 2) {

            Call<MovieResponse> call = apiService.getTopRatedMovies (API_KEY);
            call.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse>call, Response<MovieResponse> response) {
                    List<Movie> movies = response.body().getResults();
                    Log.d(TAG, "Number of movies received: " + movies.size());
                    Toast.makeText(MainActivity.this, "Number of movies received: " + movies.size(), Toast.LENGTH_LONG).show();
                    recyclerView.setAdapter(new Adapter(movies, R.layout.list_item_movie, getApplicationContext()));
                }

                @Override
                public void onFailure(Call<MovieResponse>call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });

        } else if (getType == 3) {
            Call<MovieResponse> call = apiService.getUpcomingMovies (API_KEY);
            call.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse>call, Response<MovieResponse> response) {
                    List<Movie> movies = response.body().getResults();
                    Log.d(TAG, "Number of movies received: " + movies.size());
                    Toast.makeText(MainActivity.this, "Number of movies received: " + movies.size(), Toast.LENGTH_LONG).show();
                    recyclerView.setAdapter(new Adapter(movies, R.layout.list_item_movie, getApplicationContext()));
                }

                @Override
                public void onFailure(Call<MovieResponse>call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });


        }
}


}
