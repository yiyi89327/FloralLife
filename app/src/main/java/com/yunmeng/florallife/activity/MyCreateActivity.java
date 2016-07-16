package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yunmeng.florallife.R;

/**
 * Created by my on 2016/7/14.
 */
public class MyCreateActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_create);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_my_create_agreement:
                Intent intent = new Intent(this, MyAgreementActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_my_create_back:
                finish();
                break;
            case R.id.btn_my_create_close:
                finish();
                break;
        }
    }

}
