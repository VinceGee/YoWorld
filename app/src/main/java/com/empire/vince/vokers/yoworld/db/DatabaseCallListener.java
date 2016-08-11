package com.empire.vince.vokers.yoworld.db;

import com.empire.vince.vokers.yoworld.db.data.Data;

/**
 * Created by VinceGee on 08/04/2016.
 */
public interface DatabaseCallListener {

    public void onDatabaseCallRespond(DatabaseCallTask task, Data<?> data);
    public void onDatabaseCallFail(DatabaseCallTask task, Exception exception);

}
