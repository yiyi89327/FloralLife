package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.activity.MallChosenDetailActivity;
import com.yunmeng.florallife.activity.ShopDetailActicity;
import com.yunmeng.florallife.bean.ShopmallValue;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 商城商城中分类的Adapter
 * Created by hanyiyi on 2016/7/19.
 */
public class MallAssortRVAdapter extends RecyclerView.Adapter<MallAssortRVAdapter.MallAssortViewHolder> {

    private Context context;
    private List<ShopmallValue.ResultBean.ChildrenListBean> goodsList = new ArrayList<>();
    private View view;

    public MallAssortRVAdapter(Context context, List<ShopmallValue.ResultBean.ChildrenListBean> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
    }

    @Override
    public MallAssortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_rv_mall_assort,parent, false);
        return new MallAssortViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MallAssortViewHolder holder, final int position) {
        // 设置视图
        ShopmallValue.ResultBean.ChildrenListBean goodsBean = goodsList.get(position);
        Picasso.with(context).load(goodsBean.getpGoods().getFnAttachment1()).into(holder.ivIcon);
        holder.tvSort.setText(goodsBean.getpGoods().getFnEnName());
        holder.tvName.setText(goodsBean.getpGoods().getFnName());
        holder.tvPrice.setText("¥  " + goodsBean.getpGoods().getFnMarketPrice());
        // 设置监听
        // 每个Item点击跳转至详情页面
        holder.llAssortItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MallChosenDetailActivity.class);
                intent.putExtra("title", goodsList.get(position).getpGoods().getFnName());
                intent.putExtra("en_title", goodsList.get(position).getpGoods().getFnEnName());
                intent.putExtra("first", goodsList.get(position).getpGoods().getFnFirstDesc());
                intent.putExtra("second", goodsList.get(position).getpGoods().getFnSecondDesc());
                intent.putExtra("three", goodsList.get(position).getpGoods().getFnThreeDesc());
                intent.putExtra("four", goodsList.get(position).getpGoods().getFnFourthDesc());
                intent.putExtra("five", goodsList.get(position).getpGoods().getFnFifthDesc());
                intent.putExtra("img", goodsList.get(position).getpGoods().getFnAttachment());
                intent.putExtra("price", goodsList.get(position).getpGoods().getSkuList().get(0).getFnPrice()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == goodsList ? 0 :goodsList.size();
    }

    public static class MallAssortViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.ll_mall_assort_item)
        LinearLayout llAssortItem;

        @Bind(R.id.iv_mall_assort_item_icon)
        ImageView ivIcon;
        @Bind(R.id.tv_mall_assort_item_sort)
        TextView tvSort;
        @Bind(R.id.tv_mall_assort_item_name)
        TextView tvName;
        @Bind(R.id.tv_mall_assort_item_price)
        TextView tvPrice;

        public MallAssortViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
