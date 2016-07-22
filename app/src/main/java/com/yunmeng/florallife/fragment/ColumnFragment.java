package com.yunmeng.florallife.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.activity.DetailActivity;
import com.yunmeng.florallife.adapter.MainTopColumnListAdapter;
import com.yunmeng.florallife.bean.TopColumn;
import com.yunmeng.florallife.bean.UrlConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Top中专栏一栏的Fragment
 * Created by hanyiyi on 2016/7/12.
 */
public class ColumnFragment extends Fragment {

    private View view;
    private ListView lvColumn;

    private List<TopColumn.ResultBean> columnList = new ArrayList<>();
    private MainTopColumnListAdapter columnListAdapter;

    public static ColumnFragment newInstance() {
        Bundle args = new Bundle();
        ColumnFragment fragment = new ColumnFragment();
        fragment.setArguments(args);
        return fragment;
    }

    Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_column, container, false);
        lvColumn = (ListView) view.findViewById(R.id.lv_main_top_column);
        bindAdapter();
        initData();
        initListener();
        return view;
    }

    private void bindAdapter() {
        columnListAdapter = new MainTopColumnListAdapter(columnList, getContext());
        lvColumn.setAdapter(columnListAdapter);
    }

    private void initData(){
        OkHttpTool.newInstance().start(UrlConfig.URL_TOPBASE + UrlConfig.URL_SIMPLELIST).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                TopColumn topColumn = gson.fromJson(result,TopColumn.class);
                columnList.addAll(topColumn.getResult());
                columnListAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initListener(){
        lvColumn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("img",columnList.get(position).getSmallIcon());
                bundle.putString("title",columnList.get(position).getTitle());
                bundle.putString("name","家居庭院");
                bundle.putString("vediourl",columnList.get(position).getVideoUrl());
                bundle.putString("weburl",columnList.get(position).getPageUrl());
                bundle.putString("time",columnList.get(position).getCreateDate());
                bundle.putString("readnum",columnList.get(position).getRead()+"");
                bundle.putString("likenum",columnList.get(position).getAppoint()+"");
                bundle.putString("commentnum",columnList.get(position).getFnCommentNum()+"");
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
    }
}
