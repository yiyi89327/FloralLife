package com.yunmeng.florallife.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.ZtListItemAdapter;
import com.yunmeng.florallife.bean.UrlConfig;
import com.yunmeng.florallife.bean.ZtListItemValue;
import com.yunmeng.florallife.utils.Commentway;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SimpleGuideActivity extends AppCompatActivity {

    @Bind(R.id.btn_detail_back)
    ImageView back;
    @Bind(R.id.tv_main_guide_title)
    TextView title;
    @Bind(R.id.sipmletitle_guide_pull_lv)
    PullToRefreshListView listView;
    private ZtListItemAdapter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_guide);
        ButterKnife.bind(this);
        String name = getIntent().getStringExtra("title");
        String id = getIntent().getStringExtra("id");
        title.setText(name);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setadpter(id);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                Commentway commentway = new Commentway();
                Bundle bundle = commentway.onclickway(data, position);
                intent.putExtra("bundle",bundle);
                startActivity(intent);

            }
        });

        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                adpter.notifyDataSetChanged();
                String label = DateUtils.formatDateTime(getApplicationContext(),System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME|DateUtils.FORMAT_SHOW_DATE|DateUtils.FORMAT_ABBREV_ALL);
                listView.getLoadingLayoutProxy().setLastUpdatedLabel("最后更新时间："+ label);
                listView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listView .onRefreshComplete();
                    }
                },1000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
        listView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        ILoadingLayout startLayout = listView.getLoadingLayoutProxy(true,false);
        startLayout.setPullLabel("下拉可以刷新");
        startLayout.setRefreshingLabel("松开立即刷新");
        startLayout.setReleaseLabel("正在刷新数据中...");
    }

    List<ZtListItemValue.ResultBean> data = new ArrayList();

    public void setadpter(final String id) {
        OkHttpTool.newInstance().start(UrlConfig.URL_SIMPLE_GUIDE_LIST + id).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                ZtListItemValue ztListItemValue = gson.fromJson(result, ZtListItemValue.class);
                data = ztListItemValue.getResult();
                adpter = new ZtListItemAdapter(data, getApplicationContext());
                listView.setAdapter(adpter);
            }
        });
    }
}
