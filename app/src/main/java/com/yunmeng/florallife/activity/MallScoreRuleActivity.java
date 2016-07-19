package com.yunmeng.florallife.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.utils.URLConstant;

/**
 * Created by my on 2016/7/19.
 */
public class MallScoreRuleActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_score_rule);

        WebView webView = (WebView)findViewById(R.id.wv_mall_score_rule);
        //支持js,用于打开WebView页面
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(URLConstant.MALLSCORERULE);
    }
}
