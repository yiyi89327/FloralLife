package com.yunmeng.florallife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunmeng.florallife.R;

/**
 * Created by my on 2016/7/12.
 */
public class AuthorFragment extends Fragment {

    private View view;

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
        return view;
    }
}
