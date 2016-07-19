package com.yunmeng.florallife.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_chosen_detail);
        ButterKnife.bind(this);
        mContext = this;

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
        webView1.getSettings().setDefaultTextEncodingName("UTF -8");
        webView2.getSettings().setDefaultTextEncodingName("UTF -8");
        webView2.loadData(second, "text/html; charset=UTF-8", null);
        webView3.getSettings().setDefaultTextEncodingName("UTF -8");
        webView2.getSettings().getUseWideViewPort();
        webView2.getSettings().setSupportZoom(true);
        webView2.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView3.loadData(three, "text/html; charset=UTF-8", null);
        webView4.getSettings().setDefaultTextEncodingName("UTF -8");
        webView4.loadData(four, "text/html; charset=UTF-8", null);
        prices.setText(price);

        initListener();
    }

    private void initListener() {

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
                popupWindow.showAtLocation(rv_mall_chosen_detail, Gravity.NO_GRAVITY, 0,0);
                shareView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(popupWindow.isShowing()){
                            popupWindow.dismiss();
                        }
                    }
                });

            }
        });

    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.shopdetail_add:
                Toast.makeText(this, "您尚未登录，请先登录", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this,MallIconDetailActivity.class);
                startActivity(intent2);
                break;
            case R.id.shopdetail_buy:
                Toast.makeText(this, "您尚未登录，请先登录", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,MyLoginActivity.class);
                startActivity(intent);
                break;
        }
    }

}
