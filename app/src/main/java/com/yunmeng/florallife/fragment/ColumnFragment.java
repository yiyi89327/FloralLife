package com.yunmeng.florallife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunmeng.florallife.R;

/**
 * Top中专栏一栏的Fragment
 * Created by hanyiyi on 2016/7/12.
 */
public class ColumnFragment extends Fragment {

    private View view;

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
        return view;
    }
}
