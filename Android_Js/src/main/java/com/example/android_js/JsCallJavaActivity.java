package com.example.android_js;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by jian on 2016/10/31.
 */
public class JsCallJavaActivity extends Activity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javacalljs2);

        initWebView();
    }

    private void initWebView() {
        mWebView = (WebView) findViewById(R.id.java_call_js2_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");

        // 添加一个对象，让js对象可以访问该对象的方法
        mWebView.addJavascriptInterface(new MyObject(), "niejian_android");
        mWebView.loadUrl("file:///android_asset/JsCallJava.html");
    }

    class MyObject {
        /**
         * API 17必须添加 @JavascriptInterface注解，否则会导致反射失败，调用无效
         */
        @JavascriptInterface
        public void javaCallJsMethod1() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mWebView.loadUrl("javascript:javaCallJsNoArgs()");
                }
            });
        }

        @JavascriptInterface
        public void javaCallJsMethod2() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mWebView.loadUrl("javascript:javaCallJsExistArgs('我是聂建')");
                }
            });
        }
    }
}
