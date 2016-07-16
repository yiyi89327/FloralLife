package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
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
    }
}
