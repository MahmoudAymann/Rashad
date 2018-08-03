package com.hajjhackaton.rashad;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.hajjhackaton.rashad.model.RequirdData;
import com.hajjhackaton.rashad.model.ResponseModule;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private String TAG = "testy";

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(MainFragment.this, rootView);


        return rootView;
    }

    @OnClick(R.id.btn)
    protected void onClick(){
        setData("1", "66666","msg to send", "21.616862500000003","39.15633203125001","02-08-2018");
    }

    private void setData(String calleId, String userQrCode, String msg, String lat, String longX, String dateTime) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit =
                new Retrofit.Builder().baseUrl("http://rashedcallrequestapi.gear.host/RashedAssistant/Call/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build();
        ApiLink apiLink = retrofit.create(ApiLink.class);

        RequirdData data = new RequirdData();
        data.setCalleeId(calleId);
        data.setUserId(userQrCode);
        data.setMessage(msg);
        data.setLatitude(lat);
        data.setLongitude(longX);
        data.setTime(dateTime);

        Call<ResponseModule> callModel = apiLink.getData(data);
        callModel.enqueue(new Callback<ResponseModule>() {
            @Override
            public void onResponse(@NonNull Call<ResponseModule> call, @NonNull Response<ResponseModule> response) {

                Toast.makeText(getActivity(), ""+response.body().getStatus().getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(@NonNull Call<ResponseModule> call, @NonNull Throwable t) {

            }
        });

    }//end setData

}//end class