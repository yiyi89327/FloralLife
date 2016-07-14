package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yunmeng.florallife.R;

/**
 * Created by my on 2016/7/13.
 */
public class MyActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.tv_my_agreement:
                Intent intent = new Intent(this,MyAgreementActivity.class);
                startActivity(intent);
                break;
        }
    }

}
