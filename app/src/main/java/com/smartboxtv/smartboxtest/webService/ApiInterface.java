package com.smartboxtv.smartboxtest.webService;

import com.smartboxtv.smartboxtest.bdd.DataModels.Data;
import com.smartboxtv.smartboxtest.bdd.LoginModels.LoginBody;
import com.smartboxtv.smartboxtest.bdd.LoginModels.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by XPECTRA on 6/3/2018.
 */

public interface ApiInterface {

    @POST("/api/1.0/auth/users/login/anonymous")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<LoginResponse> postLogin(@Header("Authorization") String basic,
                                  @Body LoginBody requestLogin);

    @GET("/api/1.0/sport/events")
    Call<Data> getEvents(@Header("Authorization") String bearer,
                         @Query("page") int page);



}
