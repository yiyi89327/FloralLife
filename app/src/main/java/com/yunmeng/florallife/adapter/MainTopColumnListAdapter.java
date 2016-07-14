package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.TopColumn;

import java.util.ArrayList;
import java.util.List;

/**
 * Top中作者一栏的ListView的适配器
 * Created by hanyiyi on 2016/7/14.
 * 注意：此处可优化，此适配器的convertView每次都是新new一个，而不是复用
 */
public class MainTopColumnListAdapter extends BaseAdapter {

    private List<TopColumn.ResultBean> columnList = new ArrayList();
    private Context context;

    public MainTopColumnListAdapter(List<TopColumn.ResultBean> columnList, Context context) {
        this.columnList = columnList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return null == columnList ? 0 : columnList.size();
    }

    @Override
    public Object getItem(int position) {
        return columnList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        int rank = position + 1;
//        if (null == convertView){
            viewHolder = new ViewHolder();
            // 前三名使用前三名的item布局
            if (position < 3){
                convertView = LayoutInflater.from(context).inflate(
                        R.layout.item_lv_main_top_column_forward, parent, false);
                viewHolder.ivIcon = (ImageView) convertView.
                        findViewById(R.id.iv_main_top_column1_icon);
                viewHolder.tvRank = (TextView) convertView.
                        findViewById(R.id.tv_main_top_column1_rank);
                viewHolder.tvTitle = (TextView) convertView.
                        findViewById(R.id.tv_main_top_column1_title);
                viewHolder.topLine = convertView.findViewById(
                        R.id.view_main_top_column1_top_line);
                viewHolder.bottomLine = convertView.findViewById(
                        R.id.view_main_top_column1_bottom_line);
                viewHolder.tvSign = (TextView) convertView.
                        findViewById(R.id.tv_main_top_column1_sign);
                viewHolder.tvSign2 = (TextView) convertView.
                        findViewById(R.id.tv_main_top_column1_sign);
            }
            // 第四名及以后使用后面的item布局
            else {
                convertView = LayoutInflater.from(context).inflate(
                        R.layout.item_lv_main_top_column_backward, parent, false);
                viewHolder.ivIcon = (ImageView) convertView.
                        findViewById(R.id.iv_main_top_column2_icon);
                viewHolder.tvRank = (TextView) convertView.
                        findViewById(R.id.tv_main_top_column2_rank);
                viewHolder.tvTitle = (TextView) convertView.
                        findViewById(R.id.tv_main_top_column2_title);
                viewHolder.topLine = convertView.findViewById(
                        R.id.view_main_top_column2_top_line);
                viewHolder.bottomLine = convertView.findViewById(
                        R.id.view_main_top_column2_bottom_line);
                viewHolder.tvSign = (TextView) convertView.
                        findViewById(R.id.tv_main_top_column2_sign);
                viewHolder.tvSign2 = (TextView) convertView.
                        findViewById(R.id.tv_main_top_column2_sign2);
            }
//            convertView.setTag(viewHolder);
//        }
//        else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
        //填充各个控件的内容
        TopColumn.ResultBean columnBean = columnList.get(position);
        Picasso.with(context).load(columnBean.getSmallIcon()).into(viewHolder.ivIcon);
        viewHolder.tvTitle.setText(columnBean.getTitle());
        if (position < 3){
            viewHolder.tvRank.setText("TOP " + rank);
        } else {
            viewHolder.tvRank.setText(rank + "");
        }
        return convertView;
    }

    class ViewHolder{
        ImageView ivIcon;
        TextView tvRank;
        TextView tvTitle;
        View topLine;
        View bottomLine;
        TextView tvSign;
        TextView tvSign2;

    }
}
