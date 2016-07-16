package com.yunmeng.florallife.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yunmeng.florallife.R;

/**
 * Created by my on 2016/7/14.
 */
public class MyForgetActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_forget);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_my_forget_back:
                finish();
                break;
            case R.id.btn_my_forget_close:
                finish();
                break;
        }
    }


}
