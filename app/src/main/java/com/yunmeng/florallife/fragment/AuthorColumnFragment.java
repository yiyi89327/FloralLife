package com.yunmeng.florallife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.AuthorColumnRVAdapter;
import com.yunmeng.florallife.bean.UrlConfig;
import com.yunmeng.florallife.bean.ZtListItemValue;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者个人中心的专栏Fragment
 * Created by hanyiyi on 2016/7/14.
 */
public class AuthorColumnFragment extends Fragment {

    private View view;
    private RecyclerView rvAuthorColumn;

    List<ZtListItemValue.ResultBean> authorColumnList = new ArrayList<>();
    List<ZtListItemValue.ResultBean> curAuthorColumnList;
    private AuthorColumnRVAdapter authorColumnRVAdapter;

    public static AuthorColumnFragment newInstance() {
        Bundle args = new Bundle();
        AuthorColumnFragment fragment = new AuthorColumnFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static AuthorColumnFragment newInstance(String userName) {
        Bundle args = new Bundle();
        args.putString("userName",userName);
        AuthorColumnFragment fragment = new AuthorColumnFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_author_column,container, false);
        rvAuthorColumn = (RecyclerView) view.findViewById(R.id.rv_author_column);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rvAuthorColumn.setLayoutManager(gridLayoutManager);
        initData();
        return view;
    }

    private void bindAdapter() {
        authorColumnRVAdapter = new AuthorColumnRVAdapter(getContext(),curAuthorColumnList);
        rvAuthorColumn.setAdapter(authorColumnRVAdapter);
    }

    private void initData() {
        OkHttpTool.newInstance().start(UrlConfig.URL_SIMPLE_LIST).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                ZtListItemValue authorColumnBean = gson.fromJson(result, ZtListItemValue.class);
                // 获取首页显示的所有的专栏列表
                authorColumnList.addAll(authorColumnBean.getResult());
                String userName = getArguments().getString("userName");
                // 列表中作者等同于当前页面作者的专栏，添加到当前专栏列表中
                if (null == curAuthorColumnList){
                    curAuthorColumnList = new ArrayList<>();
                    for (int i = 0; i < authorColumnList.size(); i++) {
                        if (authorColumnList.get(i).getAuthor().getUserName().equals(userName)){
                            curAuthorColumnList.add(authorColumnList.get(i));
                        }
                    }
                }
                bindAdapter();
            }
        });

    }

}
