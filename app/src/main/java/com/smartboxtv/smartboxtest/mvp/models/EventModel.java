package com.smartboxtv.smartboxtest.mvp.models;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;

import com.smartboxtv.smartboxtest.bdd.LoginModels.App;
import com.smartboxtv.smartboxtest.bdd.LoginModels.Device;
import com.smartboxtv.smartboxtest.bdd.LoginModels.LoginBody;
import com.smartboxtv.smartboxtest.bdd.LoginModels.LoginResponse;
import com.smartboxtv.smartboxtest.bdd.LoginModels.Profile;
import com.smartboxtv.smartboxtest.bdd.LoginModels.User;
import com.smartboxtv.smartboxtest.utils.EventType;
import com.smartboxtv.smartboxtest.utils.PreferencesManager;
import com.smartboxtv.smartboxtest.utils.Utils;
import com.smartboxtv.smartboxtest.webService.ServiceController;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by XPECTRA on 8/3/2018.
 */

public class EventModel {
    Context context;

    public EventModel(Context context) {
        this.context = context;
        EventBus.getDefault().register(context);
    }

    public void getEvents(int page) {
//        ServiceController.getEvents(PreferencesManager.getInstance(mContext).getToken(),
//                page).enqueue(new Callback<DataEvents>() {
//            @Override
//            public void onResponse(Call<DataEvents> call, Response<DataEvents> response) {
//                if (response.isSuccessful())
//                    mListener.successApi(response.body());
//                else
//                    mListener.errorApi(response.code());
//            }
//
//            @Override
//            public void onFailure(Call<DataEvents> call, Throwable t) {
//                mListener.errorApi(400);
//            }
//        });


    }

    @Subscribe
    public void onEvent(Object[] args) {
        if (!(args[0] instanceof Integer)) return;

        int type = (int) args[0];

        switch (type) {
            case EventType.GET_EVENTS:
                getEvents(0);
                break;
        }
    }
}
