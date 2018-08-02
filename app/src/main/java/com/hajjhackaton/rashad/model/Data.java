package com.hajjhackaton.rashad.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data
{
    @SerializedName("calleeId")
    @Expose
    private Integer calleeId;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("operationNo")
    @Expose
    private Integer operationNo;

    public Integer getCalleeId() {
        return calleeId;
    }

    public void setCalleeId(Integer calleeId) {
        this.calleeId = calleeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(Integer operationNo) {
        this.operationNo = operationNo;
    }
}
