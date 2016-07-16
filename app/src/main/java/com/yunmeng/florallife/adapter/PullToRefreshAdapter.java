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
import com.yunmeng.florallife.fragment.ShopFragment;

import java.util.List;

/**
 * Created by my on 2016/7/12.
 */
public class PullToRefreshAdapter extends BaseAdapter {

    //请添加商城和积分的数据类型
    private List<? extends MallChosenItem.ResultBean> data;
    private Context context;
    private LayoutInflater inflater;

    //请添加商城和积分的数据类型
    public List<? extends MallChosenItem.ResultBean> getData() {
        return data;
    }

    //请添加商城和积分的数据类型
    public PullToRefreshAdapter(List<? extends MallChosenItem.ResultBean> data, Context context) {
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
        ViewHolder viewHolder;
        if(ShopFragment.TYPE_MALL == 0) {
            if (null == convertView) {
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.mall_chosen_item, null);
                //"fnAttachment"
                viewHolder.iv_chosen_icon = (ImageView) convertView.findViewById(R.id.iv_chosen_icon);
                //"fnEnName":"A SURPRISE"
                viewHolder.tv_chosen_entitle = (TextView) convertView.findViewById(R.id.tv_chosen_entitle);
                //"fnName":"文艺生活－神秘箱（包月4次）"
                viewHolder.tv_chosen_title = (TextView) convertView.findViewById(R.id.tv_chosen_title);
                //"fnMarketPrice":398
                viewHolder.tv_chosen_price = (TextView) convertView.findViewById(R.id.tv_chosen_price);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            MallChosenItem.ResultBean item = data.get(position);
            Picasso.with(context).load(item.getFnAttachment()).into(viewHolder.iv_chosen_icon);
            viewHolder.tv_chosen_title.setText(item.getFnName());
            viewHolder.tv_chosen_entitle.setText(item.getFnEnName());
            viewHolder.tv_chosen_price.setText(item.getFnMarketPrice()+"");
        }


        return convertView;
    }

    public static class ViewHolder {
        //精选页面的数据
        ImageView iv_chosen_icon;
        TextView tv_chosen_entitle;
        TextView tv_chosen_title;
        TextView tv_chosen_price;
        //商城页面的数据

        //积分页面的数据
    }


}
