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
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.gson.reflect.TypeToken;
import com.hajjhackaton.rashad.model.CallModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private String TAG = "testy";
    CallModel callModel;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        AndroidNetworking.initialize(Objects.requireNonNull(getActivity()));
        ButterKnife.bind(MainFragment.this, rootView);

        return rootView;
    }


    private Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    @OnClick(R.id.btn)
    protected void onClick() {

        String REQUEST_URL = "http://rashedcallrequestapi.gear.host/RashedAssistant/Call/RequestCall";

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("calleeId", "123");  //1- police , 2- nurse,  etc....
            jsonObject.put("userId", "15555");  // Hajj QR code
            jsonObject.put("message", "Some one is having a terrible stomach ache"); //msg to say
            jsonObject.put("image", ""); //image
            jsonObject.put("latitude", "1451.222"); //location lat
            jsonObject.put("longitude", "221.6333"); //location long
            jsonObject.put("time", getCurrentDate());
            Log.d(TAG, jsonObject + "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(REQUEST_URL)
                .addApplicationJsonBody(jsonObject)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        Log.d(TAG, "status: " + response.toString() );
                    }

                    @Override
                    public void onError(ANError anError) {

                        // handle error
                        Toast.makeText(getActivity(), "" + anError.getErrorDetail(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "id : " + anError.getErrorDetail() + anError.getErrorBody() + anError.getMessage());
                    }
                });
    }
}