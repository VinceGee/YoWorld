package com.empire.vince.vokers.yoworld.db.queries;

import com.empire.vince.vokers.yoworld.db.dao.PoiDAO;
import com.empire.vince.vokers.yoworld.db.data.Data;
import com.empire.vince.vokers.yoworld.db.models.PoiModel;

import java.sql.SQLException;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class PoiReadQuery extends Query
{
    private long mId;


    public PoiReadQuery(long id)
    {
        mId = id;
    }


    @Override
    public Data<PoiModel> processData() throws SQLException
    {
        Data<PoiModel> data = new Data<>();
        data.setDataObject(PoiDAO.read(mId));
        return data;
    }
}
