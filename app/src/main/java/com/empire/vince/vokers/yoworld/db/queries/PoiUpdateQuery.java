package com.empire.vince.vokers.yoworld.db.queries;

import com.empire.vince.vokers.yoworld.db.dao.PoiDAO;
import com.empire.vince.vokers.yoworld.db.data.Data;
import com.empire.vince.vokers.yoworld.db.models.PoiModel;

import java.sql.SQLException;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class PoiUpdateQuery extends Query
{
    private PoiModel mPoi;


    public PoiUpdateQuery(PoiModel poi)
    {
        mPoi = poi;
    }


    @Override
    public Data<Integer> processData() throws SQLException
    {
        Data<Integer> data = new Data<>();
        data.setDataObject(PoiDAO.update(mPoi));
        return data;
    }
}
