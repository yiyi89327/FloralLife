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
import com.yunmeng.florallife.adapter.MainTopAuthorListAdapter;
import com.yunmeng.florallife.bean.TopAuthor;
import com.yunmeng.florallife.utils.URLConstant;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * Top中作者一栏的Fragment
 * Created by hanyiyi on 2016/7/12.
 */
public class AuthorFragment extends Fragment {

    private View view;
    private ListView lvAuthor;
    private List<TopAuthor.ResultBean> authorList = new ArrayList<>();
    private MainTopAuthorListAdapter authorListAdapter;

    public static AuthorFragment newInstance() {
        Bundle args = new Bundle();
        AuthorFragment fragment = new AuthorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_author, container, false);
        lvAuthor = (ListView) view.findViewById(R.id.lv_main_top_author);
        bindAdapter();
        initData();
        return view;
    }

    private void initData() {
        OkHttpTool.newInstance().start(URLConstant.topBase + URLConstant.authorJoint).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                TopAuthor topAuthor = gson.fromJson(result, TopAuthor.class);
                authorList.addAll(topAuthor.getResult());
                authorListAdapter.notifyDataSetChanged();
            }
        });
    }

    private void bindAdapter() {
        authorListAdapter = new MainTopAuthorListAdapter(authorList,getContext());
        lvAuthor.setAdapter(authorListAdapter);
    }
}