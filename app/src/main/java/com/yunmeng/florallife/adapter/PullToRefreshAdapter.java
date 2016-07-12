package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

    public static class ViewHolder {
        ImageView iv_zt_icon;
        ImageView cv_zt_author_img;

        TextView tv_zt_author_name;
        TextView tv_zt_author_class;

        TextView tv_zt_tag;
        TextView tv_zt_title;
        TextView tv_zt_explain;

        TextView tv_zt_eye_num;
        TextView tv_zt_collect_num;
        TextView tv_zt_discuss_num;
    }


}
