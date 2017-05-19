package com.example.yls.test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * Created by HJG on 2017/5/16.
 */

public class MyWebView extends Activity{
    private int temp = 0;
    private WebView myWebView;
    private String dataUrl;
    private ProgressDialog dialog1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_webview);
        android.webkit.WebView webView = new android.webkit.WebView(this);
        dataUrl = getIntent().getStringExtra("data");
        init();
    }
    private void init(){
        myWebView = (WebView) findViewById(R.id.forum_context);
        myWebView.loadUrl(dataUrl);
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }
        });
    }
}
