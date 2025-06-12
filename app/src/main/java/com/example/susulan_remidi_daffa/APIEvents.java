package com.example.susulan_remidi_daffa;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIEvents {

    private static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/123/";

    private static Retrofit retrofit;

    public static Retrofit getEvents() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
