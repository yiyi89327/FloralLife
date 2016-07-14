package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.MyViewPagerAdapter;
import com.yunmeng.florallife.fragment.AuthorFragment;
import com.yunmeng.florallife.fragment.ColumnFragment;

import java.util.ArrayList;
import java.util.List;

public class TopActivity extends AppCompatActivity {

    private ImageView btnBack;
    private ImageView btnSearch;
    private TabLayout tlMainTop;
    private ViewPager vpMainTop;

    private List<String> tabTitle = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();
    private MyViewPagerAdapter myViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        initTabData();
        initView();
        initFragment();
        bindAdapter();
        tlMainTop.setupWithViewPager(vpMainTop);

        intentView();

    }
    //点击跳转
    private void intentView() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    /**
     * 加载Top中TabLayout的标题
     */
    private void initTabData() {
        tabTitle.add("专栏");
        tabTitle.add("作者");
    }

    /**
     * 初始化本页面的控件
     * 1、最上方的两个Button
     * 2、上方TabLayout
     * 3、中间ViewPager
     */
    private void initView() {
        btnBack = (ImageView) findViewById(R.id.btn_main_top_back);
        btnSearch = (ImageView) findViewById(R.id.btn_main_top_search);
        tlMainTop = (TabLayout) findViewById(R.id.tl_main_top);
        vpMainTop = (ViewPager) findViewById(R.id.vp_main_top);
    }

    /**
     * 初始化本业的2个Fragment
     */
    private void initFragment(){
        mFragmentList.add(ColumnFragment.newInstance());
        mFragmentList.add(AuthorFragment.newInstance());
    }

    /**
     * 绑定适配器
     * 1、ViewPager的适配器
     */
    public void bindAdapter(){
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),
                mFragmentList, tabTitle);
        vpMainTop.setAdapter(myViewPagerAdapter);
    }


}
