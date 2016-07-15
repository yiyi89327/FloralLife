package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.ZtListItemAdapter;
import com.yunmeng.florallife.bean.UrlConfig;
import com.yunmeng.florallife.bean.ZtListItemValue;

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
                Bundle bundle = new Bundle();
                bundle.putString("img",data.get(position).getSmallIcon());
                bundle.putString("title",data.get(position).getTitle());
                bundle.putString("name",data.get(position).getCategory().getName());
                bundle.putString("weburl",data.get(position).getPageUrl());
                bundle.putString("time",data.get(position).getCreateDate());
                bundle.putString("readnum",data.get(position).getRead()+"");
                bundle.putString("vediourl",data.get(position).getVideoUrl());
                bundle.putString("likenum",data.get(position).getAppoint()+"");
                bundle.putString("commentnum",data.get(position).getFnCommentNum()+"");
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
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
