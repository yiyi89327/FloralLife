package com.yunmeng.florallife.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.MyViewPagerAdapter;
import com.yunmeng.florallife.fragment.AuthorFragment;
import com.yunmeng.florallife.fragment.ColumnFragment;

import java.util.ArrayList;
import java.util.List;

public class TopActivity extends AppCompatActivity {

    private Button btnBack;
    private Button btnSearch;
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
        tlMainTop.setTabMode(TabLayout.MODE_FIXED);

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
        btnBack = (Button) findViewById(R.id.btn_main_top_back);
        btnSearch = (Button) findViewById(R.id.btn_main_top_search);
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
