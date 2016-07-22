package com.yunmeng.florallife.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by my on 2016/7/19.
 */
public class MallScoreDetailActivity extends AppCompatActivity {

    @Bind(R.id.btn_score_detail_back)
    ImageView back;
    @Bind(R.id.tv_score_detail_bigtitle)
    TextView bigTitle;
    @Bind(R.id.btn_score_detail_share)
    ImageView score_share;

    @Bind(R.id.iv_score_detail_pic)
    ImageView imgs;
    @Bind(R.id.tv_score_detail_enname)
    TextView score_enName;
    @Bind(R.id.tv_score_detail_name)
    TextView score_name;

    @Bind(R.id.tv_score_detail_firstDesc)
    TextView fnFirstDesk;

    @Bind(R.id.wv_score_detail_web1)
    WebView score_web1;
    @Bind(R.id.wv_score_detail_web2)
    WebView score_web2;
    @Bind(R.id.wv_score_detail_web3)
    WebView score_web3;
    @Bind(R.id.wv_score_detail_web4)
    WebView score_web4;

    @Bind(R.id.tv_score_detail_price)
    TextView score_price;

    private Context mContext;
    @Bind(R.id.rl_mall_score_layout)
    RelativeLayout rl_mall_score_layout;
    private boolean islog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_score_detail);
        ButterKnife.bind(this);
        mContext = this;


        SharedPreferences preferences = getSharedPreferences("Islog", Context.MODE_PRIVATE);
        islog = preferences.getBoolean("islog", false);

        String big_title = getIntent().getStringExtra("big_title");
        String en_title = getIntent().getStringExtra("en_title");
        String first = getIntent().getStringExtra("first");
        String second = getIntent().getStringExtra("second");
        String third = getIntent().getStringExtra("third");
        String fourth = getIntent().getStringExtra("fourth");
        String fifth = getIntent().getStringExtra("fifth");
        String img = getIntent().getStringExtra("img");
        String price = getIntent().getStringExtra("price");

        bigTitle.setText(big_title);
        score_enName.setText(en_title);
        score_name.setText(big_title);
        fnFirstDesk.setText(first);
        score_price.setText(price);
        Picasso.with(this).load(img).into(imgs);

        score_web1.getSettings().setDefaultTextEncodingName("UTF-8");
        score_web1.loadData(second, "text/html; charset=UTF-8", null);
        score_web2.getSettings().setDefaultTextEncodingName("UT-8");
        score_web2.loadData(third, "text/html; charset=UTF-8", null);
        score_web3.getSettings().setDefaultTextEncodingName("UTF -8");
        score_web3.loadData(fourth, "text/html; charset=UTF-8", null);
        score_web4.getSettings().setDefaultTextEncodingName("UTF -8");
        score_web4.loadData(fifth, "text/html; charset=UTF-8", null);

        initListener();

    }

    private void initListener() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        score_share.setOnClickListener(new View.OnClickListener() {
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
                popupWindow.showAtLocation(rl_mall_score_layout, Gravity.NO_GRAVITY, 0, 0);
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
            case R.id.btn_score_detail_get:
                if (islog) {
                    AlertDialog isExit = new AlertDialog.Builder(this).create();
                    // 设置对话框消息
                    isExit.setMessage("提示");
                    isExit.setMessage("您的积分不足点击查看积分规则");
                    // 添加选择按钮并注册监听
                    isExit.setButton("查看", listener);
                    isExit.setButton2("取消", listener);
                    // 显示对话框
                    isExit.show();

                } else {
                    Toast.makeText(this, "您尚未登录，请先登录", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MyLoginActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    /**
     * 监听对话框里面的button点击事件
     */
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮进入规则界面
                    Intent intent = new Intent(getApplicationContext(),MallScoreDetailActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
            }
        }
    };


}
