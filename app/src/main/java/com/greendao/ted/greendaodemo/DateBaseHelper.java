package com.greendao.ted.greendaodemo;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

class DateBaseHelper {

    public static  final int ADD_DATA=1;
    private TradeDateApplication application;

    public Handler handler;



    public DateBaseHelper(TradeDateApplication application, Handler handler) {
        this.application =application;
        this.handler = handler;
    }

    public DateBaseHelper(TradeDateApplication application){
        this.application =application;
    }

    public  void insertData(String inputItemString,int inputPriceInt){
        TradeDate tradeDate = new TradeDate();
        tradeDate.setItem(inputItemString);
        tradeDate.setPrice(inputPriceInt);
        application.getTradeDateDao().insert(tradeDate);
        Message message = new Message();
        message.what = ADD_DATA;
        handler.sendMessage(message);
    }

    public void  delteData(long id){
        application.getTradeDateDao().deleteByKey(id);
    }

    public ArrayList<TradeDate> queryData(){
        ArrayList<TradeDate> tradeDateList = (ArrayList<TradeDate>) application.getTradeDateDao().loadAll();
        return tradeDateList;
    }
}
