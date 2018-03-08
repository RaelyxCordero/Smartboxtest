package com.smartboxtv.smartboxtest.mvp.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.smartboxtv.smartboxtest.R;
import com.smartboxtv.smartboxtest.mvp.presenters.EventsPresenter;
import com.smartboxtv.smartboxtest.mvp.presenters.LoginPresenter;
import com.smartboxtv.smartboxtest.utils.EventType;
import com.smartboxtv.smartboxtest.utils.PreferencesManager;
import com.smartboxtv.smartboxtest.utils.Utils;
import com.smartboxtv.smartboxtest.webService.ServiceController;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.container)
    FrameLayout fragmentsContainer;


    private PreferencesManager mPreferences;
    private static FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fm = getSupportFragmentManager();
        mPreferences = PreferencesManager.getInstance(this);

        if (mPreferences.getToken().isEmpty())
            replaceFragment(Utils.LOGIN);
        else
            replaceFragment(Utils.EVENTS);
    }

    public void replaceFragment(int frag) {
        Fragment fragment = null;
        switch (frag) {
            case Utils.LOGIN:
                fragment = LoginFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, fragment, LoginFragment.TAG)
                        .commit();
                return;

            case Utils.EVENTS:
                fragment = ListFragment.newInstance();
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
            case EventType.LAUNCH_EVENTS:
                replaceFragment(Utils.EVENTS);
                break;


        }
    }

}
