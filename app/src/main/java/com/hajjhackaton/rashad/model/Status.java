package com.hajjhackaton.rashad.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status
{
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

