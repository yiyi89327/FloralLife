package com.yunmeng.florallife.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.MyViewPagerAdapter;
import com.yunmeng.florallife.fragment.AuthorFragment;
import com.yunmeng.florallife.fragment.ColumnFragment;

import java.util.ArrayList;
import java.util.List;

public class TopActivity extends AppCompatActivity {

    private View llTopParent;
    private View rlTopbar;
    private ImageView ivBack;
    private ImageView ivSearch;

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

        initListener();

    }
    //点击跳转
    private void initListener() {
        // 返回键的监听
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        // 搜索键的监听
        ivSearch.setOnClickListener(new View.OnClickListener() {
            PopupWindow popupWindow;
            @Override
            public void onClick(View v) {
                final View popupView = LayoutInflater.from(TopActivity.this).inflate(
                        R.layout.popupwindow_top_search,null);
                LinearLayout wholeView = (LinearLayout) popupView.
                        findViewById(R.id.ll_main_top_search_parent);
                TextView tvSearchCancel = (TextView) popupView.
                        findViewById(R.id.tv_main_top_search_cancel);
                popupWindow = new PopupWindow(popupView);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAtLocation(llTopParent, Gravity.NO_GRAVITY,0,0);
                wholeView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (popupWindow.isShowing()){
                            popupWindow.dismiss();
                        }
                    }
                });
                tvSearchCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (popupWindow.isShowing()){
                            popupWindow.dismiss();
                        }
                    }
                });
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
     * 1、最上方的两个可点击ImageView
     * 2、上方TabLayout
     * 3、中间ViewPager
     */
    private void initView() {
        llTopParent = findViewById(R.id.ll_main_top_parent);
        rlTopbar = findViewById(R.id.rl_main_top_bar);
        ivBack = (ImageView) findViewById(R.id.iv_main_top_back);
        ivSearch = (ImageView) findViewById(R.id.iv_main_top_search);
        tlMainTop = (TabLayout) findViewById(R.id.tl_main_top);
        vpMainTop = (ViewPager) findViewById(R.id.vp_main_top);
    }

    /**
     * 初始化本页的2个Fragment
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
