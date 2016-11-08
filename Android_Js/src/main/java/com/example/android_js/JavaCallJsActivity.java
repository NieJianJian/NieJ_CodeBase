package com.example.android_js;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Created by jian on 2016/10/31.
 */
public class JavaCallJsActivity extends Activity {

    private Button btn1, btn2, btn3;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javacalljs1);

        initView();

        // 设置webview的javascript可用
        mWebView.getSettings().setJavaScriptEnabled(true);
        // 加载html，可网络，可本地
        mWebView.loadUrl("file:///android_asset/JavaCallJs.html");
        // 不加下面这句话，是无法调起alert的
        mWebView.setWebChromeClient(new WebChromeClient());
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.java_call_js1_btn1);
        btn2 = (Button) findViewById(R.id.java_call_js1_btn2);
        btn3 = (Button) findViewById(R.id.java_call_js1_btn3);
        mWebView = (WebView) findViewById(R.id.java_call_js1_webview);

        btn1.setOnClickListener(mOnClickListener);
        btn2.setOnClickListener(mOnClickListener);
        btn3.setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.java_call_js1_btn1:
                    mWebView.loadUrl("javascript:javaCallJsNoArgs()");
                    break;
                case R.id.java_call_js1_btn2:
                    mWebView.loadUrl("javascript:javaCallJsExistArgs('我是聂建')");
                    break;
                case R.id.java_call_js1_btn3:
                    mWebView.loadUrl("javascript:showAlert('出现了alert！')");
                    break;
            }
        }
    };

}
