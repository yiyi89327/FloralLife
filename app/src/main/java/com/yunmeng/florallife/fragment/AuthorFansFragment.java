package com.yunmeng.florallife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunmeng.florallife.R;

/**
 * 作者个人中心的订阅者Fragment
 * Created by my on 2016/7/14.
 */
public class AuthorFansFragment extends Fragment {

    private View view;

    public static AuthorFansFragment newInstance() {
        Bundle args = new Bundle();
        AuthorFansFragment fragment = new AuthorFansFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_author_fans, container, false);
        return view;
    }
}
