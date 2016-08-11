package com.empire.vince.vokers.yoworld.content;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class PoiSearchRecentSuggestionsProvider extends SearchRecentSuggestionsProvider
{
    public final static String AUTHORITY = "com.empire.vince.vokers.yoworld.content.PoiSearchRecentSuggestionsProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;


    public PoiSearchRecentSuggestionsProvider()
    {
        setupSuggestions(AUTHORITY, MODE);
    }
}
