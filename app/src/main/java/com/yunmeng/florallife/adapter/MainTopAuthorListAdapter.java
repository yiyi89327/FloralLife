package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.TopAuthor;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Top中作者一栏的ListView的适配器
 * Created by hanyiyi on 2016/7/13.
 */
public class MainTopAuthorListAdapter extends BaseAdapter {

    private List<TopAuthor.ResultBean> authorList = new ArrayList();
    private Context context;

    public MainTopAuthorListAdapter(List<TopAuthor.ResultBean> authorList, Context context) {
        this.authorList = authorList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return null == authorList ? 0 : authorList.size();
    }

    @Override
    public Object getItem(int position) {
        return authorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView){
            viewHolder = new ViewHolder();
            // 获取item中的各个控件
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_lv_main_top_author, parent, false);

            viewHolder.civAuthorIcon = (CircleImageView) convertView.
                    findViewById(R.id.civ_main_top_author_user_icon);
            viewHolder.tvAuthorName = (TextView) convertView.
                    findViewById(R.id.tv_main_top_author_user_name);
            viewHolder.tvAuthorRank = (TextView) convertView.
                    findViewById(R.id.tv_main_top_author_user_rank);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TopAuthor.ResultBean authorBean = authorList.get(position);
        Picasso.with(context).load(authorBean.getHeadImg()).into(viewHolder.civAuthorIcon);
        viewHolder.tvAuthorName.setText(authorBean.getUserName());
        int rank = position+1;
        viewHolder.tvAuthorRank.setText(rank+"");
        return convertView;
    }

    class ViewHolder{
        CircleImageView civAuthorIcon;
        TextView tvAuthorName;
        TextView tvAuthorRank;
    }
}
