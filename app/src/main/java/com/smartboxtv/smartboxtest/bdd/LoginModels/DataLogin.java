package com.smartboxtv.smartboxtest.bdd.LoginModels;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataLogin implements Serializable
{

    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("expiresIn")
    @Expose
    private String expiresIn;
    @SerializedName("tokenType")
    @Expose
    private String tokenType;
    @SerializedName("user")
    @Expose
    private User user;

    public DataLogin(String accessToken, String expiresIn, String tokenType, User user) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.tokenType = tokenType;
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
