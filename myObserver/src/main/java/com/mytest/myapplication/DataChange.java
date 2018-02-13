package com.mytest.myapplication;

import java.util.Observable;

/**
 * Created by Administrator on 2017/12/27.
 */

public class DataChange extends Observable{
    private static DataChange instance = null;
    public static DataChange getInstance(){
        if (instance == null){
            instance = new DataChange();
        }
        return instance;
    }
    public void notifyDataChange(Data data){
        notifyObservers(data);
    }
}
