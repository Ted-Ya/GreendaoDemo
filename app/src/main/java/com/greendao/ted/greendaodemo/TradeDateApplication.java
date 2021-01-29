package com.greendao.ted.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;


import com.ted.greendao.DaoMaster;
import com.ted.greendao.DaoSession;
import com.ted.greendao.TradeDateDao;


public class TradeDateApplication extends Application {
    private DaoSession daoSession;
    private SQLiteDatabase db;
    private TradeDateDao tradeDao;
    private DaoMaster daoMaster;

    public TradeDateDao getTradeDateDao(){
        return this.tradeDao;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        db = new DaoMaster.DevOpenHelper(getBaseContext(),"transaction.db",null).getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        tradeDao = daoSession.getTradeDateDao();
    }
}
