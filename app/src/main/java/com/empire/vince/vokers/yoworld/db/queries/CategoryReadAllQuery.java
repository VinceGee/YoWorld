package com.empire.vince.vokers.yoworld.db.queries;

import com.empire.vince.vokers.yoworld.db.dao.CategoryDAO;
import com.empire.vince.vokers.yoworld.db.data.Data;
import com.empire.vince.vokers.yoworld.db.models.CategoryModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class CategoryReadAllQuery extends Query
{
    private long mSkip = -1l;
    private long mTake = -1l;


    public CategoryReadAllQuery()
    {
    }


    public CategoryReadAllQuery(long skip, long take)
    {
        mSkip = skip;
        mTake = take;
    }


    @Override
    public Data<List<CategoryModel>> processData() throws SQLException
    {
        Data<List<CategoryModel>> data = new Data<>();
        data.setDataObject(CategoryDAO.readAll(mSkip, mTake));
        return data;
    }
}
