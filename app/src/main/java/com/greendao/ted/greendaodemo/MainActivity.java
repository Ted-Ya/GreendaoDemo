package com.greendao.ted.greendaodemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TradeTable";

    public static  final int ADD_DATA=1;

    private Button addData;
    private Button queryData;

    private  EditText inputItem;
    private EditText inputPrice;
    private String inputItemString;
    private int inputPriceInt;
    private TradeDateApplication application;
    private DateBaseHelper mDateBaseHelper;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
           switch (msg.what){
               case ADD_DATA:
                   Toast.makeText(MainActivity.this,"already add data succeed",Toast.LENGTH_SHORT).show();
                   break;
               default:
                   break;
           }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userName = findViewById(R.id.username_text1);
        inputItem =(EditText) findViewById(R.id.inputItem);
        inputPrice =(EditText) findViewById(R.id.inputPrice);

        addData = findViewById(R.id.insertData);
        addData.setOnClickListener(this);

        queryData = findViewById(R.id.queryData);
        queryData.setOnClickListener(this);

        application = (TradeDateApplication) getApplication();

        mDateBaseHelper = new DateBaseHelper(application,handler);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
          case R.id.insertData:
              inputItemString =inputItem.getText().toString();
              Log.d(TAG,"user input Item data"+inputItemString);
              try {
                  inputPriceInt = Integer.parseInt(inputPrice.getText().toString());
                  Log.d(TAG,"user input data price" + inputPriceInt);
              }catch (Exception ignored){
                  Log.d(TAG,"user yet input data");
              }

              mDateBaseHelper.insertData(inputItemString,inputPriceInt);
              break;

           case R.id.queryData:
               Intent intent =new Intent(MainActivity.this,QueryDataActivity.class);
               startActivity(intent);
               break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //do nothing in here
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //do nothing in here
    }
}
