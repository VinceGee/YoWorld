package com.empire.vince.vokers.yoworld.utilities;

import com.empire.vince.vokers.yoworld.YoWorldConfig;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class Logcat {
    public static final String TAG = "CITYGUIDE";


    public static void d(String msg)
    {
        if(YoWorldConfig.LOGS) android.util.Log.d(TAG, msg);
    }

    public static void d(String tag, String msg)
    {
        if(YoWorldConfig.LOGS) android.util.Log.d(tag, msg);
    }

    public static void e(String msg)
    {
        if(YoWorldConfig.LOGS) android.util.Log.e(TAG, msg);
    }

    public static void e(String tag, String msg)
    {
        if(YoWorldConfig.LOGS) android.util.Log.e(tag, msg);
    }

    public static void e(String msg, Throwable tr)
    {
        if(YoWorldConfig.LOGS) android.util.Log.e(TAG, msg, tr);
    }

    public static void e(String tag, String msg, Throwable tr)
    {
        if(YoWorldConfig.LOGS) android.util.Log.e(tag, msg, tr);
    }

    public static void i(String msg)
    {
        if(YoWorldConfig.LOGS) android.util.Log.i(TAG, msg);
    }

    public static void i(String tag, String msg)
    {
        if(YoWorldConfig.LOGS) android.util.Log.i(tag, msg);
    }

    public static void v(String msg)
    {
        if(YoWorldConfig.LOGS) android.util.Log.v(TAG, msg);
    }

    public static void v(String tag, String msg)
    {
        if(YoWorldConfig.LOGS) android.util.Log.v(tag, msg);
    }

    public static void w(String msg)
    {
        if(YoWorldConfig.LOGS) android.util.Log.w(TAG, msg);
    }

    public static void w(String tag, String msg)
    {
        if(YoWorldConfig.LOGS) android.util.Log.w(tag, msg);
    }
}
