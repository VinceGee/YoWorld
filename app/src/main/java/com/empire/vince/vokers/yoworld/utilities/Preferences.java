package com.empire.vince.vokers.yoworld.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.empire.vince.vokers.yoworld.YoWorldApplication;
import com.empire.vince.vokers.yoworld.R;
import com.google.android.gms.maps.GoogleMap;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class Preferences {
    private SharedPreferences mSharedPreferences;
    private Context mContext;


    public Preferences(Context context)
    {
        if(context==null) context = YoWorldApplication.getContext();
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mContext = context;
    }


    public void clearPreferences()
    {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.commit();
    }


    // getters


    public int getMapType()
    {
        String key = mContext.getString(R.string.prefs_key_map_type);
        int value = mSharedPreferences.getInt(key, GoogleMap.MAP_TYPE_NORMAL);
        return value;
    }


    // setters


    public void setMapType(int mapType)
    {
        String key = mContext.getString(R.string.prefs_key_map_type);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, mapType);
        editor.commit();
    }
}
