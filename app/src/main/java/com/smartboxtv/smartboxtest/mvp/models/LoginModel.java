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

public class LoginModel {
    Context context;

    public LoginModel(Context context) {
        this.context = context;
        EventBus.getDefault().register(context);
    }

    private void postLogin() {

        String versionApp = "1.0.0";

        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionApp = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        String language = Locale.getDefault().getLanguage();
        String deviceId = Settings.Secure.getString(context.getContentResolver(),Settings.Secure.ANDROID_ID);
        String namePhone = android.os.Build.USER;
        String version = Utils.getAndroidVersion(Build.VERSION.SDK_INT);
        String width = String.valueOf(Utils.getScreenResolution(context).widthPixels);
        String height = String.valueOf(Utils.getScreenResolution(context).heightPixels);
        String modelPhone = android.os.Build.MODEL;
        String platform = "android";


        LoginBody requestLogin = new LoginBody(new User(new Profile(language)),
                                                new Device(deviceId, namePhone, version, width, height, modelPhone, platform),
                                                new App(versionApp));
        ServiceController.postLogin(requestLogin).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    String token = response.body().getData().getAccessToken();
                    PreferencesManager.getInstance(context).setToken(token);
                    EventBus.getDefault().post(new Object[]{EventType.SUCCESS_API, response.code()});
                }else
                    EventBus.getDefault().post(new Object[]{EventType.ERROR_API, response.code()});
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                EventBus.getDefault().post(new Object[]{EventType.ERROR_API, 500});
            }
        });

    }

    @Subscribe
    public void onEvent(Object[] args) {
        if (!(args[0] instanceof Integer)) return;

        int type = (int) args[0];

        switch (type) {
            case EventType.POST_LOGIN:
                postLogin();
                break;
        }
    }
}
