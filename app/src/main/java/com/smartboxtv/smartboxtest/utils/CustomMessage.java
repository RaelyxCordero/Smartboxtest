package com.smartboxtv.smartboxtest.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.smartboxtv.smartboxtest.R;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by XPECTRA on 7/3/2018.
 */

public class CustomMessage {

    public static final int TYPE_ERROR = 0;
    public static final int TYPE_INFORMATION = 1;
    public static final int TYPE_WARNING = 2;
    public static final int TYPE_PROBLEMS = 3;
    public static final int TYPE_WARNING_OK_CANCEL = 4;
    public static final int TYPE_NO_SUCH_USER = 5;
    public static final int TYPE_PROGRESSBAR = 6;
    public static final int TYPE_UNAUTHORIZED = 7;
    public static final int TYPE_SUCCESS = 8;
    public static final int TYPE_QUESTION = 9;
    public static final int TYPE_EDITTEXT = 10;
    public static final int TYPE_EDITTEXT_IP = 11;


    public static MaterialDialog.Builder get(final Context context, int type, String message) {
        MaterialDialog.Builder dialog = null;

        if (context == null) {
            return null;
        }

        switch (type) {
            case TYPE_ERROR:
                dialog = new MaterialDialog.Builder(context)
                        .title(R.string.error)
                        .iconRes(R.drawable.ic_error)
                        .titleColorRes(R.color.colorPrimaryDark)
                        .contentColor(context.getResources().getColor(R.color.colorText))
                        .positiveColorRes(android.R.color.white)
                        .backgroundColorRes(R.color.colorPrimaryDark)
                        .maxIconSizeRes(R.dimen.dialog_max_icon_size)
                        .content(message)
                        .positiveText(R.string.accept);
                break;

            case TYPE_INFORMATION:
                dialog = new MaterialDialog.Builder(context)
                        .title(R.string.information)
                        .iconRes(R.drawable.ic_information)
                        .titleColorRes(R.color.colorPrimaryDark)
                        .contentColor(context.getResources().getColor(R.color.colorText))
                        .positiveColorRes(android.R.color.white)
                        .backgroundColorRes(R.color.colorPrimaryDark)
                        .maxIconSizeRes(R.dimen.dialog_max_icon_size)
                        .content(message)
                        .positiveText(R.string.accept);
                break;

            case TYPE_WARNING:
                dialog = new MaterialDialog.Builder(context)
                        .title(R.string.warning)
                        .iconRes(R.drawable.ic_warning)
                        .titleColorRes(R.color.colorPrimaryDark)
                        .contentColor(context.getResources().getColor(R.color.colorText))
                        .positiveColorRes(android.R.color.white)
                        .backgroundColorRes(R.color.colorPrimaryDark)
                        .maxIconSizeRes(R.dimen.dialog_max_icon_size)
                        .content(message)
                        .positiveText(R.string.accept);
                break;

            case TYPE_PROBLEMS:
                dialog = new MaterialDialog.Builder(context)
                        .title(R.string.problems)
                        .iconRes(R.drawable.ic_problems)
                        .titleColorRes(R.color.colorPrimaryDark)
                        .contentColor(context.getResources().getColor(R.color.colorText))
                        .positiveColorRes(android.R.color.white)
                        .backgroundColorRes(R.color.colorPrimaryDark)
                        .maxIconSizeRes(R.dimen.dialog_max_icon_size)
                        .content(message)
                        .positiveText(R.string.accept);
                break;

            case TYPE_WARNING_OK_CANCEL:
                dialog = new MaterialDialog.Builder(context)
                        .title(R.string.warning)
                        .iconRes(R.drawable.ic_warning)
                        .titleColorRes(R.color.colorPrimaryDark)
                        .contentColor(context.getResources().getColor(R.color.colorText))
                        .positiveColorRes(android.R.color.white)
                        .backgroundColorRes(R.color.colorPrimaryDark)
                        .maxIconSizeRes(R.dimen.dialog_max_icon_size)
                        .content(message)
                        .positiveText(R.string.accept)
                        .negativeText(R.string.cancel);
                break;

            case TYPE_NO_SUCH_USER:
                dialog = new MaterialDialog.Builder(context)
                        .title(R.string.error)
                        .iconRes(R.drawable.ic_no_such_user)
                        .titleColorRes(R.color.colorPrimaryDark)
                        .contentColor(context.getResources().getColor(R.color.colorText))
                        .positiveColorRes(android.R.color.white)
                        .backgroundColorRes(R.color.colorPrimaryDark)
                        .maxIconSizeRes(R.dimen.dialog_max_icon_size)
                        .content(message)
                        .positiveText(R.string.accept);
                break;

            case TYPE_PROGRESSBAR:
                dialog = new MaterialDialog.Builder(context)
                        .title(R.string.please_wait)
                        .content(message)
                        .cancelable(false)
                        .autoDismiss(false)
                        .progress(true, 0);
                break;

            case TYPE_UNAUTHORIZED:
                dialog = new MaterialDialog.Builder(context)
                        .title(R.string.unauthorized)
                        .iconRes(R.drawable.ic_prohibition)
                        .titleColorRes(R.color.colorPrimaryDark)
                        .contentColor(context.getResources().getColor(R.color.colorText))
                        .positiveColorRes(android.R.color.white)
                        .backgroundColorRes(R.color.colorPrimaryDark)
                        .maxIconSizeRes(R.dimen.dialog_max_icon_size)
                        .content(message)
                        .positiveText(R.string.accept);
                break;
            case TYPE_QUESTION:
                dialog = new MaterialDialog.Builder(context)
                        .title(R.string.question)
                        .iconRes(R.drawable.ic_question)
                        .titleColorRes(R.color.colorPrimaryDark)
                        .contentColor(context.getResources().getColor(R.color.colorText))
                        .positiveColorRes(android.R.color.white)
                        .backgroundColorRes(R.color.colorPrimaryDark)
                        .maxIconSizeRes(R.dimen.dialog_max_icon_size)
                        .content(message)
                        .positiveText(R.string.accept)
                        .negativeText(R.string.cancel);
                break;

        }
        dialog.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                EventBus.getDefault().post(new Object[]{MessageEventType.ON_CLICK_DIALOG});
            }
        });
        return dialog;
    }
}
