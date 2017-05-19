package com.example.yls.test;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by HJG on 2017/5/18.
 */

public class WelcomePage extends Activity{
    boolean isFirstIn = false;
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;
    //延迟3秒
    private static final long WELCOME_DELAY_MILLIS = 3000;
    private static final String SHAREDPREFERENCES_NAME = "first_pref";
    
    /*Handler:转跳页面*/
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_HOME:
                    goHome();
                break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
               setContentView(R.layout.welcome);

               init();
           }

    private void init() {
        // 读取SharedPreferences中需要的数据
        // 使用SharedPreferences来记录程序的使用次数
        SharedPreferences preferences = getSharedPreferences(SHAREDPREFERENCES_NAME,MODE_PRIVATE);

        // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
        isFirstIn = preferences.getBoolean("isFirstIn", true);

        if (!isFirstIn){
            mHandler.sendEmptyMessageDelayed(GO_HOME,WELCOME_DELAY_MILLIS);
        }else {
            mHandler.sendEmptyMessageDelayed(GO_GUIDE,WELCOME_DELAY_MILLIS);
        }
    }

    private void goHome() {
        Intent intent = new Intent(WelcomePage.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void goGuide() {
        Log.i("aaaaaa","i am here");
        Intent intent = new Intent(WelcomePage.this,GuideActivity.class);
        startActivity(intent);
        finish();
    }
}
