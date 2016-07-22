package com.yunmeng.florallife.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.yunmeng.florallife.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShopCarActivity extends AppCompatActivity {

    @Bind(R.id.btn_shopcar_back)
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_car);
        ButterKnife.bind(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
