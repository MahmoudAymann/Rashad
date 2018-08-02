package com.hajjhackaton.rashad;

import com.hajjhackaton.rashad.model.RequirdData;
import com.hajjhackaton.rashad.model.responseModule;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by MahmoudAyman on 12/06/2018.
 */

public interface ApiLink {
    @POST("RequestCall")
    Call<responseModule> getData(@Body RequirdData sentData);

}
