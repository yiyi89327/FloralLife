package com.yunmeng.florallife.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.utils.URLConstant;

/**
 * Created by my on 2016/7/14.
 */
public class MyAgreementActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_agreement);

        WebView webView = (WebView)findViewById(R.id.wv_my_agreement);
        //支持js,用于打开WebView页面
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(URLConstant.MYAGREEMENT);
    }
}
