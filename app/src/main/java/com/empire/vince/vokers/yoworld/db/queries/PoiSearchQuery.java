package com.empire.vince.vokers.yoworld.db.queries;

import com.empire.vince.vokers.yoworld.db.dao.PoiDAO;
import com.empire.vince.vokers.yoworld.db.data.Data;
import com.empire.vince.vokers.yoworld.db.models.PoiModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class PoiSearchQuery extends Query
{
    private String mQuery;
    private long mSkip = -1l;
    private long mTake = -1l;


    public PoiSearchQuery(String query)
    {
        mQuery = query;
    }


    public PoiSearchQuery(String query, long skip, long take)
    {
        mQuery = query;
        mSkip = skip;
        mTake = take;
    }


    @Override
    public Data<List<PoiModel>> processData() throws SQLException
    {
        Data<List<PoiModel>> data = new Data<>();
        data.setDataObject(PoiDAO.search(mQuery, mSkip, mTake));
        return data;
    }
}
