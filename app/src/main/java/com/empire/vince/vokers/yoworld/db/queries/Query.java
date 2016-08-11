package com.empire.vince.vokers.yoworld.db.queries;

import android.os.Bundle;

import com.empire.vince.vokers.yoworld.db.data.Data;

import java.sql.SQLException;

/**
 * Created by VinceGee on 08/04/2016.
 */
public abstract class Query {
    private Bundle mMetaData = null;

    public abstract Data<?> processData() throws SQLException;


    public Bundle getMetaData()
    {
        return mMetaData;
    }


    public void setMetaData(Bundle metaData)
    {
        mMetaData = metaData;
    }

}
