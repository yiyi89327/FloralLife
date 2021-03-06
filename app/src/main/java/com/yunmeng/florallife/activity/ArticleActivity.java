package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

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

public class ArticleActivity extends AppCompatActivity {

    @Bind(R.id.sipmletitle_centervideo_pull_lv)
    PullToRefreshListView listView;
    @Bind(R.id.btn_articles_back)
    ImageView back;
    private ZtListItemAdapter adpter;
    List<ZtListItemValue.ResultBean> data = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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

        OkHttpTool.newInstance().start(UrlConfig.URL_ZT_ARTICLE).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                ZtListItemValue ztListItemValue = gson.fromJson(result, ZtListItemValue.class);
                data = ztListItemValue.getResult();
                adpter = new ZtListItemAdapter(data, getApplicationContext());
                listView.setAdapter(adpter);
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
}
