package com.empire.vince.vokers.yoworld.db.data;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class Data <T>
{
    private T mDataObject;


    public Data()
    {
    }


    public T getDataObject()
    {
        return mDataObject;
    }


    public void setDataObject(T dataObject)
    {
        mDataObject = dataObject;
    }
}
