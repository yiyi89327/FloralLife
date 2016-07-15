package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.GuidelistValue;

import java.util.List;

/**
 * Created by my on 2016/7/13.
 */
public class GuideSimpleAdapter extends BaseAdapter {

    private List<String> list;
    private LayoutInflater inflater;
    public GuideSimpleAdapter(List<String> list, Context mContext) {
        this.list = list;
        inflater =  LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return list != null?list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return list != null? list.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.simple_listview,null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.title1);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(list.get(position));
        return convertView;
    }
    class ViewHolder{
        TextView name;
    }

}
