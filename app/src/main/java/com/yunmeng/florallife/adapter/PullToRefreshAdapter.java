package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.MallChosenItem;
import com.yunmeng.florallife.bean.MallScore;
import com.yunmeng.florallife.fragment.ShopFragment;

import java.util.List;

/**
 * Created by my on 2016/7/12.
 */
public class PullToRefreshAdapter extends BaseAdapter {

    //请添加商城和积分的数据类型
    private List<?> data;
    private Context context;
    private LayoutInflater inflater;

    //请添加商城和积分的数据类型
    public List<?> getData() {
        return data;
    }

    //请添加商城和积分的数据类型
    public PullToRefreshAdapter(List<?> data, Context context) {
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
        switch (ShopFragment.TYPE_MALL){
            case 0:
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
                MallChosenItem.ResultBean item = (MallChosenItem.ResultBean) data.get(position);
                Picasso.with(context).load(item.getFnAttachment()).into(chosenViewHolder.iv_chosen_icon);
                chosenViewHolder.tv_chosen_title.setText(item.getFnName());
                chosenViewHolder.tv_chosen_entitle.setText(item.getFnEnName());
                chosenViewHolder.tv_chosen_price.setText(item.getFnMarketPrice()+"");
                break;
            case 1:
                ////////////////////////////////////
                /////////  赵佳荣加进去 /////////////
                ////////////////////////////////////
                break;
            case 2:
                ScoreViewHolder scoreViewHolder;
                if (null == convertView){
                    scoreViewHolder = new ScoreViewHolder();
                    convertView = inflater.inflate(R.layout.item_mall, null);
                    scoreViewHolder.rvMallScore = (RecyclerView) convertView.
                            findViewById(R.id.rv_mall);
                    convertView.setTag(scoreViewHolder);
                } else {
                    scoreViewHolder = (ScoreViewHolder) convertView.getTag();
                }
                /////////////////////!!!!!这里List有问题!!!!!!///////////////////////////
//                MallScoreRecyclerViewAdapter mallScoreRecyclerViewAdapter =
//                        new MallScoreRecyclerViewAdapter(
//                                context, (List<MallScore.ResultBean>) data.get(2));
//                scoreViewHolder.rvMallScore.setAdapter(mallScoreRecyclerViewAdapter);
                break;
        }

        return convertView;
    }

    public static class ChosenViewHolder {
        //精选页面的数据
        ImageView iv_chosen_icon;
        TextView tv_chosen_entitle;
        TextView tv_chosen_title;
        TextView tv_chosen_price;
    }
    //积分页面的数据

    ////////////////////////////////////
    /////////  赵佳荣加进去 /////////////
    ////////////////////////////////////

    //商城页面的数据
    public static class ScoreViewHolder {
        RecyclerView rvMallScore;
    }


}
