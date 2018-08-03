package com.hajjhackaton.rashad;

import com.hajjhackaton.rashad.model.RequirdData;
import com.hajjhackaton.rashad.model.ResponseModule;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by MahmoudAyman on 12/06/2018.
 */

public interface ApiLink {
    @POST("RequestCall")
    Call<ResponseModule> getData(@Body RequirdData sentData);

}
