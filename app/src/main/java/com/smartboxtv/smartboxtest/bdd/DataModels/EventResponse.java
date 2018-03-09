package com.smartboxtv.smartboxtest.bdd.DataModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by XPECTRA on 9/3/2018.
 */

public class EventResponse {
    @SerializedName("data")
    @Expose
    private Data data;

    public EventResponse(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EventResponse{" +
                "data=" + data +
                '}';
    }
}
