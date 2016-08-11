package com.empire.vince.vokers.yoworld.db.queries;

import com.empire.vince.vokers.yoworld.db.dao.CategoryDAO;
import com.empire.vince.vokers.yoworld.db.data.Data;

import java.sql.SQLException;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class CategoryDeleteQuery extends Query
{
    private long mId;


    public CategoryDeleteQuery(long id)
    {
        mId = id;
    }


    @Override
    public Data<Integer> processData() throws SQLException
    {
        Data<Integer> data = new Data<>();
        data.setDataObject(CategoryDAO.delete(mId));
        return data;
    }
}
