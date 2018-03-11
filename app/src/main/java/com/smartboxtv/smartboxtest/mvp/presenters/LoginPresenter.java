package com.smartboxtv.smartboxtest.mvp.presenters;

import android.content.Context;

import com.smartboxtv.smartboxtest.mvp.models.EventModel;
import com.smartboxtv.smartboxtest.mvp.models.LoginModel;
import com.smartboxtv.smartboxtest.utils.MessageEventType;
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
//        eventModel = new EventModel(context);
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEvent(Object[] args) {
        if (!(args[0] instanceof Integer)) return;

        int type = (int) args[0];

        switch (type) {
            case MessageEventType.HEY_PRESENTER_DO_LOGIN:
                EventBus.getDefault().post(new Object[]{MessageEventType.HEY_MODEL_POST_LOGIN});
                break;
            case MessageEventType.HEY_PRESENTER_API_LOGIN_ERROR:
                int errorCode = (int) args[1];
                ServiceController.handlerRequestError(context, errorCode);
                break;
            case MessageEventType.HEY_PRESENTER_API_LOGIN_SUCCESS:
                EventBus.getDefault().post(new Object[]{MessageEventType.HEY_PRESENTER_GET_EVENTS, 0});
                break;


        }
    }
}
