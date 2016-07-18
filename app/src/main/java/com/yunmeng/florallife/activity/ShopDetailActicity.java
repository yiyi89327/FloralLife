package com.yunmeng.florallife.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShopDetailActicity extends AppCompatActivity {

    @Bind(R.id.btn_shop_detail_back)
    ImageView back;
    @Bind(R.id.shopdetail_title)
    TextView titles;
    @Bind(R.id.shopdetail_add)
    Button add;
    @Bind(R.id.shopdetail_buy)
    Button buy;
    @Bind(R.id.shop_detail_price)
    TextView prices;
    @Bind(R.id.shopdetail_web)
    WebView webView;
    @Bind(R.id.btn_shop_detail_share)
    ImageView share;
    @Bind(R.id.shopdetail_img)
    ImageView imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail_acticity);
        ButterKnife.bind(this);

        String img = getIntent().getStringExtra("img");
        String title = getIntent().getStringExtra("title");
        String first = getIntent().getStringExtra("first");
        String price = getIntent().getStringExtra("price");
        String second = getIntent().getStringExtra("second");
        String three = getIntent().getStringExtra("three");
        String four = getIntent().getStringExtra("four");
        String five = getIntent().getStringExtra("five");

        titles.setText(title);
        Picasso.with(this).load(img).into(imgs);
        webView.loadUrl(first);
        prices.setText(price);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
