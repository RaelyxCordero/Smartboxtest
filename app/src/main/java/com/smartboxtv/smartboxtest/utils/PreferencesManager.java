package com.smartboxtv.smartboxtest.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by XPECTRA on 8/3/2018.
 */

public class PreferencesManager {

    // Preference instances
    private Context context;
    private static Map<Context, PreferencesManager> instances = new HashMap<>();

    private static final String KEY_TOKEN = "TOKEN";

    private final String TAG = PreferencesManager.class.getSimpleName();

    public SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private static final String PREFER_NAME = "PREFERENCE";


    // Constructor
    public PreferencesManager(Context context) {
        pref = context.getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
        this.context = context;
    }

    public static PreferencesManager getInstance(Context context) {
        if (!instances.containsKey(context))
            instances.put(context,
                    new PreferencesManager(context));
        return instances.get(context);
    }



    public void setToken(String token){
        editor.putString(KEY_TOKEN, token);
        editor.commit();
    }


    public String getToken() {
        return pref.getString(KEY_TOKEN, "");
    }





}


