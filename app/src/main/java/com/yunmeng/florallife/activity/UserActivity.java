package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.AuthorColumnRVAdapter;
import com.yunmeng.florallife.bean.UrlConfig;
import com.yunmeng.florallife.bean.ZtListItemValue;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserActivity extends AppCompatActivity {

    private ImageView ivUserIconBig;
    private ImageView ivUserBack;
    private CircleImageView civUserIcon;
    private TextView tvUserName;
    private TextView tvUserSlogan;
    private TextView tvUserSubscribe;
    private RecyclerView rvUser;

    private String userName;
    private int userIcon;

    private List<ZtListItemValue.ResultBean> columnList = new ArrayList<>();
    private AuthorColumnRVAdapter authorColumnRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initData();
        initView();
        initListener();
    }

    private void initData() {
        // 由传值得来的用户信息
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        userName = bundle.getString("userName");
        userIcon = bundle.getInt("userIcon");

        // 由网络上获取的专题信息
        OkHttpTool.newInstance().start(UrlConfig.URL_ZT_ARTICLE).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                final ZtListItemValue authorColumnBean = gson.fromJson(result, ZtListItemValue.class);
                // 获取首页显示的所有的专栏列表
                columnList.addAll(authorColumnBean.getResult());
                OkHttpTool.newInstance().start(UrlConfig.URL_ZT_VIDEO).callback(new IOKCallBack() {
                    @Override
                    public void success(String result) {
                        Gson gson1 = new Gson();
                        ZtListItemValue authorColumnBean1 = gson1.fromJson(result, ZtListItemValue.class);
                        columnList.addAll(authorColumnBean1.getResult());
                        bindAdapter();
                    }
                });
            }
        });

    }

    private void bindAdapter() {
        authorColumnRVAdapter = new AuthorColumnRVAdapter(this, columnList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rvUser.setLayoutManager(gridLayoutManager);
        rvUser.setAdapter(authorColumnRVAdapter);
    }

    private void initView() {
        // 获取控件
        ivUserIconBig = (ImageView) findViewById(R.id.iv_user_icon_big);
        ivUserBack = (ImageView) findViewById(R.id.iv_user_back);
        civUserIcon = (CircleImageView) findViewById(R.id.civ_user_icon);
        tvUserName = (TextView) findViewById(R.id.tv_user_name);
        tvUserSlogan = (TextView) findViewById(R.id.tv_user_slogan);
        tvUserSubscribe = (TextView) findViewById(R.id.tv_user_subscribe);    // 这个是订阅按钮
        rvUser = (RecyclerView) findViewById(R.id.rv_user_article);

        // 设置控件内容
        civUserIcon.setImageResource(userIcon);
        ivUserIconBig.setImageResource(userIcon);
        tvUserName.setText(userName);
        tvUserSlogan.setText("这家伙很懒什么都没写");

    }

    private void initListener() {
        // 顶部返回键
        ivUserBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // 圆形头像点击
        civUserIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUserIconBig.setVisibility(View.VISIBLE);
            }
        });
        // 大头像点击
        ivUserIconBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUserIconBig.setVisibility(View.GONE);
            }
        });


        // 点击订阅   这里要登录  没写！！！！！！！！！！！！！！！！！！！！
        tvUserSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
