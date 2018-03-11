package com.smartboxtv.smartboxtest.mvp.views;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.smartboxtv.smartboxtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by raelyx on 10/03/18.
 */

public class DetailDialog extends DialogFragment {
    public static final String TAG = DetailDialog.class.getSimpleName();
    public static final String PHASE = "PHASE";
    public static final String NAME_GROUP = "NAME_GROUP";
    public static final String STATUS = "STATUS";
    public static final String DURATION = "DURATION";
    public static final String ESTADIUM = "ESTADIUM";
    @BindView(R.id.tvPhase)
    TextView tvPhase;
    @BindView(R.id.tvNameGroup)
    TextView tvNameGroup;
    @BindView(R.id.tvStatus)
    TextView tvStatus;
    @BindView(R.id.tvDuration)
    TextView tvDuration;
    @BindView(R.id.tvEstadium)
    TextView tvEstadium;

    public static DetailDialog newInstance(String phase, String nameGroup,
                                            String status, String duration, String estadium) {
        Bundle args = new Bundle();
        args.putString(PHASE, phase);
        args.putString(NAME_GROUP, nameGroup);
        args.putString(STATUS, status);
        args.putString(DURATION, duration);
        args.putString(ESTADIUM, estadium);

        DetailDialog fragment = new DetailDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().getAttributes().windowAnimations = R.style.Animation_AppCompat_DropDownUp;
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_detail, null);
        getDialog().requestWindowFeature(Window.FEATURE_SWIPE_TO_DISMISS);
        ButterKnife.bind(this, view);

        tvPhase.setText(getArguments().getString(PHASE));
        tvNameGroup.setText(getArguments().getString(NAME_GROUP));
        tvDuration.setText(getArguments().getString(DURATION));
        tvStatus.setText(getArguments().getString(STATUS));
        tvEstadium.setText(getArguments().getString(ESTADIUM));

        return view;
    }

}
