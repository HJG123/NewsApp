package com.example.yls.test.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.yls.test.MyWebView;
import com.example.yls.test.R;
import com.example.yls.test.adapter.adapter_fragment1_listitem;
import com.example.yls.test.javaBean.javaBean_fragment1;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by yls on 2017/5/16.
 */

public class fragment1 extends Fragment {
    private Handler mHandler;
    private int GETDATAFROMURL = 1001;
    private String dataReturn;
    private javaBean_fragment1 mJavaBean_fragment1;
    private ListView listView;

    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        initData();
        initHander();
    }

    private void initClickListener() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), MyWebView.class);
                intent.putExtra("data",mJavaBean_fragment1.getNewslist().get(position).getUrl());
                startActivity(intent);
            }
        });
    }

    private void initHander() {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what==GETDATAFROMURL){
                    dataReturn = (String) msg.obj;
                    initJsonData();
                    initListViewData();
                    initClickListener();
                }
                return true;
            }

            private void initJsonData() {
                Gson gson = new Gson();
                mJavaBean_fragment1 = gson.fromJson(dataReturn,javaBean_fragment1.class);
            }
        });
    }

    private void initListViewData() {
        listView = (ListView) getActivity().findViewById(R.id.listview_fragment1);
        listView.setAdapter(new adapter_fragment1_listitem(mJavaBean_fragment1,getActivity()));
    }

    private void initJsonData() {
        Gson gson = new Gson();
        mJavaBean_fragment1 = gson.fromJson(dataReturn,javaBean_fragment1.class);
    }
    private void initData() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://api.tianapi.com/meinv/?key=c0f870a43929d8233d46047439ba4bb1&num=10");
                    URLConnection rulConnection = url.openConnection();
                    HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
                    httpUrlConnection.connect();
                    InputStream is = httpUrlConnection.getInputStream();
                    int i = -1;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    while ((i = is.read()) != -1) {
                        baos.write(i);
                    }
                    String content = baos.toString();
                    Message message = Message.obtain();
                    message.obj = content;
                    message.what=GETDATAFROMURL;
                    mHandler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    }