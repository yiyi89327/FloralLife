package com.yunmeng.florallife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.MainTopColumnListAdapter;
import com.yunmeng.florallife.bean.TopColumn;
import com.yunmeng.florallife.utils.URLConstant;

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
        OkHttpTool.newInstance().start(URLConstant.topBase + URLConstant.coulmnJoint).callback(new IOKCallBack() {
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

    }
}
