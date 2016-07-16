package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.yunmeng.florallife.R;

/**
 * Created by my on 2016/7/14.
 */
public class MyLoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_my_agreement:
                Intent intent = new Intent(this, MyAgreementActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_my_back:
                finish();
                break;
            case R.id.btn_my_close:
                finish();
                break;
            case R.id.tv_my_create:
                Intent intent2 = new Intent(this, MyCreateActivity.class);
                startActivity(intent2);
                break;
            case R.id.tv_my_forget:
                Intent intent3 = new Intent(this, MyForgetActivity.class);
                startActivity(intent3);
                break;
        }
    }

}


