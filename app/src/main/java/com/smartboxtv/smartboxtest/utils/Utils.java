package com.smartboxtv.smartboxtest.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartboxtv.smartboxtest.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by XPECTRA on 7/3/2018.
 */

public class Utils {
    private static Gson mGsonBuilder;

    /**
     * Constants
     */

    public static final int LOGIN = 0;
    public static final int EVENTS = 1;


    public static Gson getGsonBuilder() {
        if (mGsonBuilder == null) {
            return new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
        }

        return mGsonBuilder;
    }

//    public static int getImageResource(String shortName) {
//        int id = 0;
//        switch (shortName) {
//            case "ALE":
//                id = R.drawable.ic_ger;
//                break;
//            case "CMR":
//                id = R.drawable.ic_cmr;
//                break;
//            case "CHI":
//                id = R.drawable.ic_chi;
//                break;
//            case "AUS":
//                id = R.drawable.ic_aus;
//                break;
//            case "POR":
//                id = R.drawable.ic_por;
//                break;
//            case "MEX":
//                id = R.drawable.ic_mex;
//                break;
//            case "NZL":
//                id = R.drawable.ic_nzl;
//                break;
//            case "RUS":
//                id = R.drawable.ic_rus;
//                break;
//        }
//        return id;
//    }

    public static String
    changeDate(String dateModel){

        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        DateFormat outputFormatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateModel);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputFormatter1.format(date);
    }

    public static String getAndroidVersion(int sdk) {
        switch (sdk) {
            case 16: return "4.1";
            case 17: return "4.2";
            case 18: return "4.3";
            case 19: return "4.4";
            case 20: return "4.4";
            case 21: return "5.0";
            case 22: return "5.1";
            case 23: return "6.0";
            case 24: return "7.0";
            case 25: return "7.1.1";
            case 26: return "8.0";
            default: return "";
        }
    }

    public static DisplayMetrics getScreenResolution(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        return metrics;
    }

    public static int mod(int x)
    {
        int result = x % 2;
        return result < 0? result + 2 : result;
    }


}
