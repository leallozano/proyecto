package com.example.carlos.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity{



    TextView Id,Title,Description,Overview,Rating,genRes;
    ImageView Im,Im2;
    TextView Estreno;
    String Imagen,Imagen2,genres;



    private final static String API_KEY = "b5297900952d5edc9daf9f34cd717a8a";
    private static final String TAG = Detail.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Description = (TextView)findViewById(R.id.description);
        genRes = (TextView)findViewById(R.id.genres);
        Title = (TextView)findViewById(R.id.title);
        Overview= (TextView)findViewById(R.id.subtitle);
        Rating = (TextView)findViewById(R.id.rating);
        //Imagen=(ImageView) findViewById(R.id.Im);
        Im = (ImageView) findViewById(R.id.Im);
        Im2 = (ImageView) findViewById(R.id.Im2);
        Estreno = (TextView) findViewById(R.id.estreno);

        Intent intent = getIntent();

        Overview.setText(intent.getStringExtra("Overview"));
        Rating.setText(intent.getStringExtra("rating"));
        Title.setText(intent.getStringExtra("Title"));
        Description.setText(intent.getStringExtra("Description"));
        Imagen = intent.getStringExtra("im");
        Imagen2=intent.getStringExtra("poster_path");
        Estreno.setText("Release Date: "+intent.getStringExtra("Estreno"));
        //genRes.setText(intent.getStringArrayListExtra("listName").toString());
        genRes.setText(intent.getStringExtra("listName"));

        Picasso.with(Im.getContext()).load("https://image.tmdb.org/t/p/w300_and_h450_bestv2" + Imagen).resize(700, 750).into(Im);
        Picasso.with(Im2.getContext()).load("https://image.tmdb.org/t/p/w300_and_h450_bestv2" + Imagen2).resize(700, 750).into(Im2);



    }




}