package com.xz.tbswebviewdemo;


import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.lys.studyrecord.R;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * author: lys
 * date: 2017/3/30 16:26
 * email: njzy_lys@163.com
 */

public class TbsActivity extends AppCompatActivity {
    private String url = "http://www.qq.com";
    private String msg = "Hello world!";
    private int num = 0;

    WebView tbsWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbs);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        initView();
    }

    private void initView() {
        tbsWebView = (WebView) findViewById(R.id.tbs_webview);
        tbsWebView.loadUrl(url);
        WebSettings webSettings = tbsWebView.getSettings();
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        tbsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                webView.loadUrl(s);
                return true;
            }
        });
        tbsWebView.addJavascriptInterface(new WebViewJavaScriptFunction() {
            @Override
            public void onJsFunctionCalled(String tag) {

            }

        }, "Android");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && tbsWebView.canGoBack()) {
            tbsWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
