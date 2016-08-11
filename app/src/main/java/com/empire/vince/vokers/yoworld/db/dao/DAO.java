package com.empire.vince.vokers.yoworld.db.dao;

import com.empire.vince.vokers.yoworld.db.DatabaseHelper;
import com.empire.vince.vokers.yoworld.utilities.Logcat;

import java.sql.SQLException;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class DAO {
    public static void printDatabaseInfo()
    {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        try
        {
            Logcat.d("DAO.printDatabaseInfo(): categories " + databaseHelper.getCategoryDao().countOf());
            Logcat.d("DAO.printDatabaseInfo(): pois " + databaseHelper.getPoiDao().countOf());
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
