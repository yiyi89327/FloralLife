package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yunmeng.florallife.R;

/**
 * Created by my on 2016/7/16.
 */
public class MallIconDetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_icon_detail);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.btn_my_icon_close:
                finish();
                break;
            case R.id.btn_my_icon_login:
                Intent intent = new Intent(this,MyLoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_my_icon_register:
                Intent intent2 = new Intent(this,MyCreateActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
