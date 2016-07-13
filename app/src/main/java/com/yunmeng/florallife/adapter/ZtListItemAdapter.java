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
import com.yunmeng.florallife.bean.ZtListItem;

import java.util.List;

/**
 * Created by my on 2016/7/12.
 */
public class ZtListItemAdapter extends BaseAdapter {

    private List<ZtListItem.ResultBean> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public List<ZtListItem.ResultBean> getResult() {
        return data;
    }

    public ZtListItemAdapter(List<ZtListItem.ResultBean> data, Context context) {
        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
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

        ViewHolder viewHolder;

        if(null == convertView){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.zhuanti_list_item,null);
            //"smallIcon"
            viewHolder.iv_zt_icon = (ImageView) convertView.findViewById(R.id.iv_zt_icon);
            //"author"-"headImg"
            viewHolder.cv_zt_author_img = (ImageView) convertView.findViewById(R.id.cv_zt_author_img);

            //"author":   "userName":"一窝时光",
            viewHolder.tv_zt_author_name = (TextView) convertView.findViewById(R.id.tv_zt_author_name);
            //"author":   "identity":"资深设计师"
            viewHolder.tv_zt_author_class = (TextView) convertView.findViewById(R.id.tv_zt_author_class);

            //"category":  "name":"家居庭院",
            viewHolder.tv_zt_tag = (TextView) convertView.findViewById(R.id.tv_zt_tag);
            //"title":"那一抹迷人的红｜乌木杂",
            viewHolder.tv_zt_title = (TextView) convertView.findViewById(R.id.tv_zt_title);
            //"desc"
            viewHolder.tv_zt_explain = (TextView) convertView.findViewById(R.id.tv_zt_explain);
            //"read"
            viewHolder.tv_zt_eye_num = (TextView) convertView.findViewById(R.id.tv_zt_eye_num);
            //"share"
            viewHolder.tv_zt_collect_num = (TextView) convertView.findViewById(R.id.tv_zt_collect_num);
            //"fnCommentNum"
            viewHolder.tv_zt_discuss_num = (TextView) convertView.findViewById(R.id.tv_zt_discuss_num);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ZtListItem.ResultBean item = data.get(position);
        Picasso.with(context).load(item.getSmallIcon()).into(viewHolder.iv_zt_icon);
        Picasso.with(context).load(item.getAuthor().getHeadImg()).into(viewHolder.cv_zt_author_img);
        viewHolder.tv_zt_author_name.setText(item.getAuthor().getUserName());
        viewHolder.tv_zt_author_class.setText(item.getAuthor().getIdentity());

        viewHolder.tv_zt_tag.setText(item.getCategory().getName());
        viewHolder.tv_zt_title.setText(item.getTitle());
        viewHolder.tv_zt_explain.setText(item.getDesc());
        viewHolder.tv_zt_collect_num.setText(item.getRead());
        viewHolder.tv_zt_discuss_num.setText(item.getShare());
        viewHolder.tv_zt_eye_num.setText(item.getFnCommentNum());

        return convertView;
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
