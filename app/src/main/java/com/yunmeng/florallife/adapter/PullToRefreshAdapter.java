package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by my on 2016/7/12.
 */
public class PullToRefreshAdapter extends BaseAdapter {

    private List<Object> data;
    private Context context;
    private LayoutInflater inflater;
    private static final int TYPE_DATE = 0;
    private static final int TYPE_CHANNELS_CONTENT = 1;
    public List<Object> getData() {
        return data;
    }

    public PullToRefreshAdapter(List<Object> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }



}
