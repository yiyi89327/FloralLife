package com.yunmeng.florallife.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.yunmeng.florallife.activity.DetailActivity;
import com.yunmeng.florallife.adapter.ZtListItemAdapter;
import com.yunmeng.florallife.bean.UrlConfig;
import com.yunmeng.florallife.bean.ZtListItemValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 59857 on 2016/7/15.
 */
public class Commentway {

    public Bundle onclickway(  List<ZtListItemValue.ResultBean> data,int position) {
        Bundle bundle = new Bundle();
        bundle.putString("img", data.get(position).getSmallIcon());
        bundle.putString("title", data.get(position).getTitle());
        bundle.putString("name", data.get(position).getCategory().getName());
        bundle.putString("weburl", data.get(position).getPageUrl());
        bundle.putString("time", data.get(position).getCreateDate());
        bundle.putString("readnum", data.get(position).getRead() + "");
        bundle.putString("vediourl", data.get(position).getVideoUrl());
        bundle.putString("likenum", data.get(position).getAppoint() + "");
        bundle.putString("commentnum", data.get(position).getFnCommentNum() + "");
        return bundle;
    }
}
