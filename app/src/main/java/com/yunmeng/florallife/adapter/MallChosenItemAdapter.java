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
 * Created by my on 2016/7/13.
 */
public class MallChosenItemAdapter extends BaseAdapter {

    private List<MallChosenItem.ResultBean> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public List<MallChosenItem.ResultBean> getResult() {
        return data;
    }

    public MallChosenItemAdapter(List<MallChosenItem.ResultBean> data, Context context) {
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
        if(null == convertView) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.mall_chosen_item, null);
            //"fnAttachment"
            viewHolder.iv_chosen_icon = (ImageView) convertView.findViewById(R.id.iv_chosen_icon);
            //"fnEnName":"A SURPRISE"
            viewHolder.tv_chosen_entitle = (TextView) convertView.findViewById(R.id.tv_chosen_entitle);
            //"fnName":"文艺生活－神秘箱（包月4次）"
            viewHolder.tv_chosen_title = (TextView) convertView.findViewById(R.id.tv_chosen_title);
            //"fnMarketPrice":398
            viewHolder.tv_chosen_price = (TextView) convertView.findViewById(R.id.tv_chosen_price);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MallChosenItem.ResultBean item = data.get(position);

        Picasso.with(context).load(item.getFnAttachment()).into(viewHolder.iv_chosen_icon);
        viewHolder.tv_chosen_title.setText(item.getFnName());
        viewHolder.tv_chosen_entitle.setText(item.getFnEnName());
        viewHolder.tv_chosen_price.setText((int) item.getFnMarketPrice());

        return convertView;
    }

    public static class ViewHolder {
        ImageView iv_chosen_icon;

        TextView tv_chosen_entitle;
        TextView tv_chosen_title;
        TextView tv_chosen_price;
    }

}
