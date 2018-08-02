package com.hajjhackaton.rashad.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class responseModule
{
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("data")
    @Expose
    private Data data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
