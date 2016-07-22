package com.yunmeng.florallife.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MallChosenDetailActivity extends AppCompatActivity {

    @Bind(R.id.btn_shop_detail_back)
    ImageView back;
    @Bind(R.id.shopdetail_title)
    TextView titles;

    @Bind(R.id.shopdetail_enname)
    TextView enName;
    @Bind(R.id.shopdetail_name)
    TextView name;
    @Bind(R.id.shopdetail_fnfirstdesk)
    TextView fnFirstDesk;

    @Bind(R.id.shopcar_enter)
    ImageView car;
    @Bind(R.id.shopdetail_add)
    Button add;
    @Bind(R.id.shopdetail_buy)
    Button buy;
    @Bind(R.id.shop_detail_price)
    TextView prices;
    @Bind(R.id.shopdetail_web1)
    WebView webView1;
    @Bind(R.id.shopdetail_web2)
    WebView webView2;
    @Bind(R.id.shopdetail_web3)
    WebView webView3;
    @Bind(R.id.shopdetail_web4)
    WebView webView4;
    @Bind(R.id.btn_shop_detail_share)
    ImageView share;
    @Bind(R.id.shopdetail_img)
    ImageView imgs;

    private Context mContext;
    @Bind(R.id.rl_mall_chosen_layout)
    RelativeLayout rv_mall_chosen_detail;
    private boolean islog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_chosen_detail);
        ButterKnife.bind(this);
        mContext = this;

        SharedPreferences preferences = getSharedPreferences("Islog", Context.MODE_PRIVATE);
        islog = preferences.getBoolean("islog", false);

        String img = getIntent().getStringExtra("img");
        String title = getIntent().getStringExtra("title");
        String enTitle = getIntent().getStringExtra("en_title");
        String first = getIntent().getStringExtra("first");
        String price = getIntent().getStringExtra("price");
        String second = getIntent().getStringExtra("second");
        String three = getIntent().getStringExtra("three");
        String four = getIntent().getStringExtra("four");
        String five = getIntent().getStringExtra("five");

        titles.setText(title);
        enName.setText(enTitle);
        name.setText(title);
        fnFirstDesk.setText(first);
        prices.setText(price);
        Picasso.with(this).load(img).into(imgs);

        webView1.getSettings().setDefaultTextEncodingName("UTF -8");
        webView1.loadData(second, "text/html; charset=UTF-8", null);

        webView2.getSettings().setDefaultTextEncodingName("UTF -8");
        webView2.loadData(three, "text/html; charset=UTF-8", null);
        //任意比例缩放
//        webView2.getSettings().getUseWideViewPort();
//        webView2.getSettings().setSupportZoom(true);
//        webView2.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        webView3.getSettings().setDefaultTextEncodingName("UTF -8");
        webView3.loadData(four, "text/html; charset=UTF-8", null);

        webView4.getSettings().setDefaultTextEncodingName("UTF -8");
        webView4.loadData(five, "text/html; charset=UTF-8", null);

        initListener();
    }

    private void initListener() {

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShopCarActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupWindow popupWindow;
                View shareView = LayoutInflater.from(mContext).inflate(R.layout.activity_mall_share_detail, null);
                popupWindow = new PopupWindow(shareView);
                popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                ColorDrawable dw = new ColorDrawable(0xb0000000);
                popupWindow.setBackgroundDrawable(dw);
                popupWindow.showAtLocation(rv_mall_chosen_detail, Gravity.NO_GRAVITY, 0, 0);
                shareView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (popupWindow.isShowing()) {
                            popupWindow.dismiss();
                        }
                    }
                });

            }
        });

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shopdetail_add:
                if (islog) {

                } else {
                    Toast.makeText(this, "您尚未登录，请先登录", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(this, MallIconDetailActivity.class);
                    startActivity(intent2);
                }
                break;
            case R.id.shopdetail_buy:
                if (islog) {
                    Intent intent1 = new Intent(this, BuyActivity.class);
                    startActivity(intent1);
                } else {
                    Toast.makeText(this, "您尚未登录，请先登录", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MyLoginActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

}
