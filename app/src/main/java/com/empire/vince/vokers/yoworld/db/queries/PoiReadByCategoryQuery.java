package com.empire.vince.vokers.yoworld.db.queries;

import com.empire.vince.vokers.yoworld.db.dao.PoiDAO;
import com.empire.vince.vokers.yoworld.db.data.Data;
import com.empire.vince.vokers.yoworld.db.models.PoiModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class PoiReadByCategoryQuery extends Query
{
    private long mCategoryId;
    private long mSkip = -1l;
    private long mTake = -1l;


    public PoiReadByCategoryQuery(long categoryId)
    {
        mCategoryId = categoryId;
    }


    public PoiReadByCategoryQuery(long categoryId, long skip, long take)
    {
        mCategoryId = categoryId;
        mSkip = skip;
        mTake = take;
    }


    @Override
    public Data<List<PoiModel>> processData() throws SQLException
    {
        Data<List<PoiModel>> data = new Data<>();
        data.setDataObject(PoiDAO.readByCategory(mCategoryId, mSkip, mTake));
        return data;
    }
}
