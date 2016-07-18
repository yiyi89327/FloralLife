package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.MallScore;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 59857 on 2016/7/18.
 */
public class MallScoreAdpter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    private MallScoreRecyclerViewAdapter adpter;
    List<MallScore.ResultBean> data;
    public MallScoreAdpter(Context mContext, List<MallScore.ResultBean> data) {
        this.data = data;
        this.context = mContext;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data == null? 0 : 1;
    }

    @Override
    public Object getItem(int position) {
        return data == null ? null: data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.shopmall_score_item,null);
            viewHolder = new ViewHolder(convertView);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        adpter = new MallScoreRecyclerViewAdapter(context,data);
        viewHolder.recyclerView.setAdapter(adpter);
        return convertView;
    }

    class ViewHolder{
        @Bind(R.id.shopmall_item)
        RecyclerView recyclerView;
        public ViewHolder(View view) {
            view.setTag(this);
            ButterKnife.bind(this,view);
        }
    }
}
