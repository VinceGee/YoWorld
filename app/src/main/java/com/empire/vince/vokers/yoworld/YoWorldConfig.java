package com.empire.vince.vokers.yoworld;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class YoWorldConfig {
    // true for enabling debug logs, should be false in production release
    public static final boolean LOGS = false;

    // true for enabling Google Analytics, should be true in production release
    public static final boolean ANALYTICS = true;

    // true for enabling Google AdMob banner on POI list screen, should be true in production release
    public static final boolean ADMOB_POI_LIST_BANNER = true;

    // true for enabling Google AdMob on POI detail screen, should be true in production release
    public static final boolean ADMOB_POI_DETAIL_BANNER = true;

    // true for enabling Google AdMob on map screen, should be true in production release
    public static final boolean ADMOB_MAP_BANNER = true;

    // file name of the SQLite database, this file should be placed in assets folder
    public static final String DATABASE_NAME = "yoworld.db";

    // database version, should be incremented if database has been changed
    public static final int DATABASE_VERSION = 1;
}
