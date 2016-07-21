package com.yunmeng.florallife.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.MallAssortRVAdapter;
import com.yunmeng.florallife.adapter.MallAssortUpRVAdapter;
import com.yunmeng.florallife.bean.MallGuideItem;
import com.yunmeng.florallife.bean.UrlConfig;

import java.util.ArrayList;

/**
 * 分类列表类
 * （在商城中点击下拉菜单的分类所跳转的页面）
 * Created by hanyiyi on 2016/7/20.
 */
public class MallAssortUpActivity extends AppCompatActivity {

    private ImageView ivBack;
    private TextView tvTitle;
    private RecyclerView rvMallAssortUpList;
    private ArrayList<MallGuideItem.ResultBean.ResultBeanIn> goodsList = new ArrayList<>();
    private MallAssortUpRVAdapter mallAssortUpRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_assort_up);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        ivBack = (ImageView) findViewById(R.id.iv_mall_assort_up_back);
        tvTitle = (TextView) findViewById(R.id.tv_mall_assort_up_title);
        rvMallAssortUpList = (RecyclerView) findViewById(R.id.rv_mall_assort_up_list);
    }

    /**
     * 根据intent获取数据
     */
    private void initData(){
        Bundle bundle = getIntent().getBundleExtra("bundle");
        String title = bundle.getString("title");
        String fnId = bundle.getString("fnId");
        OkHttpTool.newInstance().start(UrlConfig.URL_SHOP_GUIDE_LIST_BASE + fnId).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                MallGuideItem mallGuideItem = gson.fromJson(result, MallGuideItem.class);
                goodsList.addAll(mallGuideItem.getResult().getResult());
                bindAdapter();
            }
        });
        tvTitle.setText(title);
    }

    private void bindAdapter(){
        mallAssortUpRVAdapter = new MallAssortUpRVAdapter(MallAssortUpActivity.this,goodsList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rvMallAssortUpList.setLayoutManager(gridLayoutManager);
        rvMallAssortUpList.setAdapter(mallAssortUpRVAdapter);
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
