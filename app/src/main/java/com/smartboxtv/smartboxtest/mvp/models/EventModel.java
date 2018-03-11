package com.smartboxtv.smartboxtest.mvp.models;

import android.content.Context;
import android.util.Log;

import com.smartboxtv.smartboxtest.bdd.DataModels.EventResponse;
import com.smartboxtv.smartboxtest.utils.MessageEventType;
import com.smartboxtv.smartboxtest.utils.PreferencesManager;
import com.smartboxtv.smartboxtest.webService.ServiceController;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by XPECTRA on 8/3/2018.
 */

public class EventModel {
    public static final String TAG = EventModel.class.getSimpleName();
    Context context;

    public EventModel(Context context) {
        this.context = context;
        EventBus.getDefault().register(this);
    }

    public void getEvents(int page) {
        ServiceController.getEvents(PreferencesManager.getInstance(context).getToken(),
                page).enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful())
                    EventBus.getDefault().post(new Object[]{MessageEventType.HEY_PRESENTER_API_GET_EVENTS_SUCCESS, response.body()});
                else {
                    EventBus.getDefault().post(new Object[]{MessageEventType.HEY_PRESENTER_API_GET_EVENTS_ERROR, response.code()});
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                EventBus.getDefault().post(new Object[]{MessageEventType.HEY_PRESENTER_API_GET_EVENTS_ERROR, 500});
                Log.e(TAG, t.getMessage());
            }
        });


    }

    @Subscribe
    public void onEvent(Object[] args) {
        if (!(args[0] instanceof Integer)) return;

        int type = (int) args[0];

        switch (type) {
            case MessageEventType.HEY_MODEL_GET_EVENTS:
                    getEvents((int) args[1]);
                break;
        }
    }
}
