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

public class EventsPresenter {
    Context context;
    EventModel eventModel;

    public EventsPresenter(Context context) {
        this.context = context;
        eventModel = new EventModel(context);
        EventBus.getDefault().register(context);
    }

    @Subscribe
    public void onEvent(Object[] args) {
        if (!(args[0] instanceof Integer)) return;

        int type = (int) args[0];

        switch (type) {

            case EventType.EVENTS:
                EventBus.getDefault().post(new Object[]{EventType.GET_EVENTS});
                break;


        }
    }
}
