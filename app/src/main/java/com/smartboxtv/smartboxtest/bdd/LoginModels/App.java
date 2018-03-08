package com.smartboxtv.smartboxtest.bdd.LoginModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class App implements Serializable {

    @SerializedName("version")
    @Expose
    private String version;

    public App(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
