package com.empire.vince.vokers.yoworld.geolocation;

import android.location.Location;

/**
 * Created by VinceGee on 08/04/2016.
 */
public interface GeolocationListener {
    public void onGeolocationRespond(Geolocation geolocation, Location location);
    public void onGeolocationFail(Geolocation geolocation);
}
