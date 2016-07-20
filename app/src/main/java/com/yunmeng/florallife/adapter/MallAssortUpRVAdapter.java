package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.activity.MallChosenDetailActivity;
import com.yunmeng.florallife.activity.ShopDetailActicity;
import com.yunmeng.florallife.bean.MallGuideItem;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/7/20.
 */
public class MallAssortUpRVAdapter extends RecyclerView.Adapter<MallAssortRVAdapter.MallAssortViewHolder> {

    private Context context;
    private List<MallGuideItem.ResultBean.ResultBeanIn> goodsList = new ArrayList<>();
    private View view;

    public MallAssortUpRVAdapter(Context context, List<MallGuideItem.ResultBean.ResultBeanIn> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
    }

    @Override
    public MallAssortRVAdapter.MallAssortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_rv_mall_assort,parent, false);
        return new MallAssortRVAdapter.MallAssortViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MallAssortRVAdapter.MallAssortViewHolder holder, final int position) {
        // 设置视图
        MallGuideItem.ResultBean.ResultBeanIn goodsBean = goodsList.get(position);
        Picasso.with(context).load(goodsBean.getFnAttachment1()).into(holder.ivIcon);
        holder.tvSort.setText(goodsBean.getFnEnName());
        holder.tvName.setText(goodsBean.getFnName());
        holder.tvPrice.setText("¥  " + goodsBean.getFnMarketPrice());
        // 设置监听
        // 每个Item点击跳转至详情页面
        holder.llAssortItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MallChosenDetailActivity.class);
                intent.putExtra("title", goodsList.get(position).getFnName());
                intent.putExtra("en_title", goodsList.get(position).getFnEnName());
                intent.putExtra("first", goodsList.get(position).getFnFirstDesc());
                intent.putExtra("second", goodsList.get(position).getFnSecondDesc());
                intent.putExtra("three", goodsList.get(position).getFnThreeDesc());
                intent.putExtra("four", goodsList.get(position).getFnFourthDesc());
                intent.putExtra("five", goodsList.get(position).getFnFifthDesc());
                intent.putExtra("img", goodsList.get(position).getFnAttachment());
                intent.putExtra("price", goodsList.get(position).getSkuList().get(0).getFnPrice()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == goodsList ? 0 :goodsList.size();
    }
}
