package com.hajjhackaton.rashad;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MahmoudAyman on 07/02/2018.
 */

public class MyRetrofitClient {

    @NonNull
    public static Retrofit getBase() {
        return new Retrofit.Builder().baseUrl("http://rashedcallrequestapi.gear.host/RashedAssistant/Call/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}