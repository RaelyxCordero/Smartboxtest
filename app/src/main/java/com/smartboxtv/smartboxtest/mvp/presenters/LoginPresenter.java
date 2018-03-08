package com.smartboxtv.smartboxtest.mvp.presenters;

import android.content.Context;

import com.smartboxtv.smartboxtest.mvp.models.EventModel;
import com.smartboxtv.smartboxtest.mvp.models.LoginModel;
import com.smartboxtv.smartboxtest.utils.EventType;
import com.smartboxtv.smartboxtest.webService.ServiceController;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by XPECTRA on 8/3/2018.
 */

public class LoginPresenter {
    Context context;
    LoginModel loginModel;
    EventModel eventModel;

    public LoginPresenter(Context context) {
        this.context = context;
        loginModel = new LoginModel(context);
        eventModel = new EventModel(context);
        EventBus.getDefault().register(context);
    }

    @Subscribe
    public void onEvent(Object[] args) {
        if (!(args[0] instanceof Integer)) return;

        int type = (int) args[0];

        switch (type) {
            case EventType.LOGIN:
                EventBus.getDefault().post(new Object[]{EventType.POST_LOGIN});
                break;
            case EventType.ERROR_API:
                int errorCode = (int) args[1];
                ServiceController.handlerRequestError(context, errorCode);
                break;
            case EventType.SUCCESS_API:
                EventBus.getDefault().post(new Object[]{EventType.LAUNCH_EVENTS});
                break;


        }
    }
}
