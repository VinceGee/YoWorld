package com.empire.vince.vokers.yoworld.db.queries;

import com.empire.vince.vokers.yoworld.db.dao.PoiDAO;
import com.empire.vince.vokers.yoworld.db.data.Data;

import java.sql.SQLException;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class PoiDeleteQuery extends Query
{
    private long mId;


    public PoiDeleteQuery(long id)
    {
        mId = id;
    }


    @Override
    public Data<Integer> processData() throws SQLException
    {
        Data<Integer> data = new Data<>();
        data.setDataObject(PoiDAO.delete(mId));
        return data;
    }
}
