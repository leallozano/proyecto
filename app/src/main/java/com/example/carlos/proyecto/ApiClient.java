package com.example.carlos.proyecto;

/**
 * Created by Carlos on 7/3/2017.
 */
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClient {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static retrofit2.Retrofit retrofit = null;


    public static retrofit2.Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
