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
import com.yunmeng.florallife.adapter.MallChosenItemAdapter;
import com.yunmeng.florallife.bean.MallChosenItem;
import com.yunmeng.florallife.utils.URLConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/7/13.
 */
public class MallChosenFragment extends Fragment{

    private ListView mListView;
    private List<MallChosenItem.ResultBean> list = new ArrayList<>();
    private MallChosenItemAdapter adapter;

    //创建静态工厂
    public static MallChosenFragment newInstance() {
        Bundle args = new Bundle();
        MallChosenFragment fragment = new MallChosenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mall_chosen_listview,container,false);

        initData();

        mListView = (ListView)view.findViewById(R.id.lv_mall_chosen);
        adapter = new MallChosenItemAdapter(list,getContext());
        mListView.setAdapter(adapter);
        return view;
    }

    private void initData() {
        OkHttpTool.newInstance().start(URLConstant.MALLCHOSEN).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                if(result == null){
                    return;
                }
                Gson gson = new Gson();
                MallChosenItem item = gson.fromJson(result,MallChosenItem.class);
                list.addAll(item.getResult());
                adapter.notifyDataSetChanged();
            }
        });


    }


}
