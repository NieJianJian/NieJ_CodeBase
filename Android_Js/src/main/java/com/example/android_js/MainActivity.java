package com.example.android_js;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button javaCallJsBtn, jsCallJavaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        javaCallJsBtn = (Button) findViewById(R.id.javaCallJsBtn);
        javaCallJsBtn.setOnClickListener(this);
        jsCallJavaBtn = (Button) findViewById(R.id.jsCallJavaBtn);
        jsCallJavaBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.javaCallJsBtn:
                Intent intent1 = new Intent(this, JavaCallJsActivity.class);
                startActivity(intent1);
                break;
            case R.id.jsCallJavaBtn:
                Intent intent2 = new Intent(this, JsCallJavaActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
