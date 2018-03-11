package com.smartboxtv.smartboxtest.utils;

/**
 * Created by XPECTRA on 8/3/2018.
 */

public class MessageEventType {

    public static final int ON_CLICK_DIALOG = 4000;
    ///CALL TO MODELS
    public static final int HEY_MODEL_POST_LOGIN = 1;
    public static final int HEY_MODEL_GET_EVENTS = 2;

    ///CALL TO PRESENTERS
    public static final int HEY_PRESENTER_DO_LOGIN = 1000;
    public static final int HEY_PRESENTER_API_LOGIN_ERROR = 1001;
    public static final int HEY_PRESENTER_API_LOGIN_SUCCESS =1002 ;

    public static final int HEY_PRESENTER_GET_EVENTS = 2000;
    public static final int HEY_PRESENTER_API_GET_EVENTS_ERROR = 2001 ;
    public static final int HEY_PRESENTER_API_GET_EVENTS_SUCCESS = 2002 ;

    ///CALL TO VIEWS
    public static final int HEY_VIEW_LAUNCH_EVENTS = 3000;
    public static final int HEY_VIEW_LAUNCH_EVENT_DETAIL = 3001;
    public static final int HEY_VIEW_ADD_EVENTS = 3002;
}
