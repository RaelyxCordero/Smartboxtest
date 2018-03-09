package com.smartboxtv.smartboxtest.bdd.LoginModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("data")
    @Expose
    private DataLogin dataLogin;

    public LoginResponse(DataLogin dataLogin) {
        this.dataLogin = dataLogin;
    }

    public DataLogin getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(DataLogin dataLogin) {
        this.dataLogin = dataLogin;
    }
}
