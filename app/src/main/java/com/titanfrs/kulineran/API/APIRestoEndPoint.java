package com.titanfrs.kulineran.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIRestoEndPoint {

    private static final String BASE_URL = "https://api.myjson.com/bins/";

    private static Retrofit retrofit;
    public static Retrofit getClient()
    {
        if(retrofit == null)
        {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }
}
