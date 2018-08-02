package com.hajjhackaton.rashad;

import com.hajjhackaton.rashad.model.CallModel;
import com.hajjhackaton.rashad.model.requist_requird_data;
import com.hajjhackaton.rashad.model.responseModule;

import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by MahmoudAyman on 12/06/2018.
 */

public interface ApiLink {


    @POST("RequestCall")
    Call<responseModule> getData(@Body requist_requird_data sentData);

}
