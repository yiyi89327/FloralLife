package com.yunmeng.florallife.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.MallAssortRVAdapter;
import com.yunmeng.florallife.bean.ShopmallValue;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 主题列表类
 * （在商城中点击商城Fragment中的不同主题所跳转的页面）
 * Created by hanyiyi on 2016/7/19.
 */
public class MallAssortActivity extends AppCompatActivity {

    private ImageView ivBack;
    private TextView tvTitle;
    private RecyclerView rvMallAssortList;
    private ArrayList<ShopmallValue.ResultBean.ChildrenListBean> goodsList;
    private MallAssortRVAdapter mallAssortRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_assort);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        ivBack = (ImageView) findViewById(R.id.iv_mall_assort_back);
        tvTitle = (TextView) findViewById(R.id.tv_mall_assort_title);
        rvMallAssortList = (RecyclerView) findViewById(R.id.rv_mall_assort_list);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rvMallAssortList.setLayoutManager(gridLayoutManager);
    }

    /**
     * 根据intent获取数据
     */
    private void initData(){
        Bundle bundle = getIntent().getBundleExtra("bundle");
        String title = bundle.getString("title");

        goodsList = (ArrayList<ShopmallValue.ResultBean.ChildrenListBean>)
                        bundle.getSerializable("goodsList");
        tvTitle.setText(title);
        bindAdapter();
    }

    private void bindAdapter(){
        mallAssortRVAdapter = new MallAssortRVAdapter(MallAssortActivity.this,goodsList);
        rvMallAssortList.setAdapter(mallAssortRVAdapter);
    }

    private void initListener(){
        // 返回键的监听
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
