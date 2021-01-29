package com.greendao.ted.greendaodemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class QueryDataActivity extends AppCompatActivity {

    private static final String TAG = "GreenDaoDemo";
    public ArrayList<TradeDate> tradeList;
    private LinearLayoutManager mLayoutManager;
    private  TradeDataListAdapter mAdapter;
    public DateBaseHelper mDateBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_layout);


        TradeDateApplication application = (TradeDateApplication) getApplication();

        mDateBaseHelper = new DateBaseHelper(application);
        tradeList = mDateBaseHelper.queryData();

        initView();
    }


    public  void initView(){

        RecyclerView recyclerView = this.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
         mAdapter = new TradeDataListAdapter(tradeList);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
          ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchCallBack(this, new ItemTouchCallBack.OnItemTouchListener() {
              @Override
              public void onSwiped(int position) {
                  Long  id = tradeList.get(position).getId();
                  mAdapter.removeTradeTable(position);
                  mDateBaseHelper.delteData(id);
              }
          }));

         recyclerView.addItemDecoration(new TradeTableDecoration(this, OrientationHelper.HORIZONTAL));

         itemTouchHelper.attachToRecyclerView(recyclerView);
    }

}
