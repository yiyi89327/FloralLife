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
import com.yunmeng.florallife.bean.MallChosenItem;

import java.util.List;

/**
 * Created by my on 2016/7/12.
 */
public class PullToRefreshAdapter extends BaseAdapter {


    //请添加商城和积分的数据类型
    private List<MallChosenItem.ResultBean> data;
    private Context context;
    private LayoutInflater inflater;

    public PullToRefreshAdapter(List<MallChosenItem.ResultBean> scoreList, Context mContext) {
        this.data = scoreList;
        this.context = mContext;
        inflater = LayoutInflater.from(context);
    }


    //请添加商城和积分的数据类型
    public List<? extends MallChosenItem.ResultBean> getData() {
        return data;
    }

//    //请添加商城和积分的数据类型
//    public PullToRefreshAdapter(List<? extends MallChosenItem.ResultBean> data, Context context) {
//        this.data = data;
//        this.context = context;
//        inflater = LayoutInflater.from(context);
//    }

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
        ChosenViewHolder chosenViewHolder;
        if (null == convertView) {
            chosenViewHolder = new ChosenViewHolder();
            convertView = inflater.inflate(R.layout.mall_chosen_item, null);
            //"fnAttachment"
            chosenViewHolder.iv_chosen_icon = (ImageView) convertView.findViewById(R.id.iv_chosen_icon);
            //"fnEnName":"A SURPRISE"
            chosenViewHolder.tv_chosen_entitle = (TextView) convertView.findViewById(R.id.tv_chosen_entitle);
            //"fnName":"文艺生活－神秘箱（包月4次）"
            chosenViewHolder.tv_chosen_title = (TextView) convertView.findViewById(R.id.tv_chosen_title);
            //"fnMarketPrice":398
            chosenViewHolder.tv_chosen_price = (TextView) convertView.findViewById(R.id.tv_chosen_price);
            convertView.setTag(chosenViewHolder);
        } else {
            chosenViewHolder = (ChosenViewHolder) convertView.getTag();
        }
        MallChosenItem.ResultBean item = data.get(position);
        Picasso.with(context).load(item.getFnAttachment()).into(chosenViewHolder.iv_chosen_icon);
        chosenViewHolder.tv_chosen_title.setText(item.getFnName());
        chosenViewHolder.tv_chosen_entitle.setText(item.getFnEnName());
        chosenViewHolder.tv_chosen_price.setText(item.getFnMarketPrice() + "");

        return convertView;
    }

    public static class ChosenViewHolder {
        //精选页面的数据
        ImageView iv_chosen_icon;
        TextView tv_chosen_entitle;
        TextView tv_chosen_title;
        TextView tv_chosen_price;
    }


}
