package com.empire.vince.vokers.yoworld.db.queries;

import com.empire.vince.vokers.yoworld.db.dao.CategoryDAO;
import com.empire.vince.vokers.yoworld.db.data.Data;
import com.empire.vince.vokers.yoworld.db.models.CategoryModel;

import java.sql.SQLException;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class CategoryCreateQuery extends Query
{
    private CategoryModel mCategory;


    public CategoryCreateQuery(CategoryModel category)
    {
        mCategory = category;
    }


    @Override
    public Data<Integer> processData() throws SQLException
    {
        Data<Integer> data = new Data<>();
        data.setDataObject(CategoryDAO.create(mCategory));
        return data;
    }
}
