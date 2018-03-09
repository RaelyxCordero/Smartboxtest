package com.smartboxtv.smartboxtest.mvp.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.ybq.android.spinkit.SpinKitView;
import com.smartboxtv.smartboxtest.R;
import com.smartboxtv.smartboxtest.mvp.presenters.LoginPresenter;
import com.smartboxtv.smartboxtest.utils.MessageEventType;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

public class LoginFragment extends Fragment {
    public final static String TAG = LoginFragment.class.getSimpleName();
    @BindView(R.id.tvLogin)
    TextView tvLogin;
    @BindView(R.id.spin_kit)
    SpinKitView spinKit;

    LoginPresenter loginPresenter;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenter(getContext());
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        EventBus.getDefault().post(new Object[]{MessageEventType.HEY_PRESENTER_DO_LOGIN});
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
