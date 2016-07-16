package com.yunmeng.florallife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.AuthorIntroListAdapter;
import com.yunmeng.florallife.bean.PersonalCenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者个人中心的介绍Fragment
 * Created by hanyiyi on 2016/7/14.
 */
public class AuthorIntroFragment extends Fragment {

    private View view;
    private ListView lvAuthorIntro;

    private ArrayList<PersonalCenter.ResultBean.ListContentBean> introList = new ArrayList<>();
    private AuthorIntroListAdapter authorIntroListAdapter;

    public static AuthorIntroFragment newInstance() {
        Bundle args = new Bundle();
        AuthorIntroFragment fragment = new AuthorIntroFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static Fragment newInstance(ArrayList<PersonalCenter.ResultBean.ListContentBean> introList) {
        Bundle args = new Bundle();
        args.putSerializable("introList",introList);
        AuthorIntroFragment fragment = new AuthorIntroFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_author_intro,container,false);
        lvAuthorIntro = (ListView) view.findViewById(R.id.lv_author_intro);
//        bindAdapter();
        initData();
        return view;
    }

    private void bindAdapter() {
        authorIntroListAdapter = new AuthorIntroListAdapter(introList, getContext());
        lvAuthorIntro.setAdapter(authorIntroListAdapter);
    }

    private void initData() {
        introList = (ArrayList<PersonalCenter.ResultBean.ListContentBean>) getArguments().
                getSerializable("introList");
        bindAdapter();
    }
}
