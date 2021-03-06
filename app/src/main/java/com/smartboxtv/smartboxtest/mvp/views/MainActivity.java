package com.smartboxtv.smartboxtest.mvp.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.smartboxtv.smartboxtest.R;
import com.smartboxtv.smartboxtest.bdd.DataModels.EventResponse;
import com.smartboxtv.smartboxtest.mvp.presenters.EventsPresenter;
import com.smartboxtv.smartboxtest.utils.MessageEventType;
import com.smartboxtv.smartboxtest.utils.PreferencesManager;
import com.smartboxtv.smartboxtest.utils.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.container)
    FrameLayout fragmentsContainer;
    EventsPresenter eventsPresenter;

    private static FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        fm = getSupportFragmentManager();
        eventsPresenter = new EventsPresenter(this);
        replaceFragment(Utils.LOGIN, null);
    }

    public void replaceFragment(int frag, EventResponse data) {
        Fragment fragment = null;
        switch (frag) {
            case Utils.LOGIN:
                fragment = LoginFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, fragment, LoginFragment.TAG)
                        .commit();
                return;

            case Utils.EVENTS:
                fragment = ListFragment.newInstance(data);
                fm.beginTransaction().replace(R.id.container, fragment, ListFragment.TAG)
                        .commit();
                break;

        }
    }

    @Subscribe
    public void onEvent(Object[] args) {
        if (!(args[0] instanceof Integer)) return;

        int type = (int) args[0];

        switch (type) {
            case MessageEventType.HEY_VIEW_LAUNCH_EVENTS:
                EventResponse data = (EventResponse) args[1];
                replaceFragment(Utils.EVENTS, data);
                break;

            case MessageEventType.HEY_VIEW_LAUNCH_EVENT_DETAIL:
                String phase = (String) args[1];
                String nameGroup = (String) args[2];
                String status = (String) args[3];
                String duration = (String) args[4];
                String estadium = (String) args[5];
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(DetailDialog.newInstance(phase, nameGroup,status, duration, estadium),
                        DetailDialog.TAG);
                ft.commitAllowingStateLoss();
                break;

            case MessageEventType.ON_CLICK_DIALOG:
                onBackPressed();
                break;
        }
    }

}
