package com.yunmeng.florallife.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yunmeng.florallife.R;

import butterknife.ButterKnife;

/**
 * Created by my on 2016/7/19.
 */
public class MallScoreDetailActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_score_detail);
        ButterKnife.bind(this);
        mContext = this;



    }

}
