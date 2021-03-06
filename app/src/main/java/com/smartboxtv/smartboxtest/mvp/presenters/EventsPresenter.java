package com.smartboxtv.smartboxtest.mvp.presenters;

import android.content.Context;

import com.smartboxtv.smartboxtest.bdd.DataModels.EventResponse;
import com.smartboxtv.smartboxtest.mvp.models.EventModel;
import com.smartboxtv.smartboxtest.utils.MessageEventType;
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
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEvent(Object[] args) {
        if (!(args[0] instanceof Integer)) return;

        int type = (int) args[0];

        switch (type) {

            case MessageEventType.HEY_PRESENTER_GET_EVENTS:
                EventBus.getDefault().post(new Object[]{MessageEventType.HEY_MODEL_GET_EVENTS,
                                            (int) args[1]});
                break;

            case MessageEventType.HEY_PRESENTER_API_GET_EVENTS_ERROR:
                int errorCode = (int) args[1];
                ServiceController.handlerRequestError(context, errorCode);
                break;
            case MessageEventType.HEY_PRESENTER_API_GET_EVENTS_SUCCESS:
                EventResponse data = (EventResponse) args[1];
                if (data.getData().getPagination().getPage() == 1)
                    EventBus.getDefault().post(new Object[]{MessageEventType.HEY_VIEW_LAUNCH_EVENTS, data});
                else
                    EventBus.getDefault().post(new Object[]{MessageEventType.HEY_VIEW_ADD_EVENTS, data});
                break;
        }
    }
}
