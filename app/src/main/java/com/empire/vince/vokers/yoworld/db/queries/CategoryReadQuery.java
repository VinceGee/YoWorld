package com.empire.vince.vokers.yoworld.db.queries;

import com.empire.vince.vokers.yoworld.db.dao.CategoryDAO;
import com.empire.vince.vokers.yoworld.db.data.Data;
import com.empire.vince.vokers.yoworld.db.models.CategoryModel;

import java.sql.SQLException;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class CategoryReadQuery extends Query
{
    private long mId;


    public CategoryReadQuery(long id)
    {
        mId = id;
    }


    @Override
    public Data<CategoryModel> processData() throws SQLException
    {
        Data<CategoryModel> data = new Data<>();
        data.setDataObject(CategoryDAO.read(mId));
        return data;
    }
}
