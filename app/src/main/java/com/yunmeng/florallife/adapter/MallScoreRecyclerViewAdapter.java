package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.MallScore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/7/16.
 */
public class MallScoreRecyclerViewAdapter extends RecyclerView.Adapter<MallScoreRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<MallScore.ResultBean> scoreGoodList = new ArrayList<>();
    private View view;

    public MallScoreRecyclerViewAdapter(Context context, List<MallScore.ResultBean> scoreGoodList) {
        this.context = context;
        this.scoreGoodList = scoreGoodList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_rv_mall_score, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MallScore.ResultBean scoreGoodBean = scoreGoodList.get(position);
        Picasso.with(context).load(scoreGoodBean.getFnAttachment1()).
                into(holder.ivIcon);
        holder.tvEnName.setText(scoreGoodBean.getFnEnName());
        holder.tvName.setText(scoreGoodBean.getFnName());
        holder.tvRequireScore.setText("积分  " + scoreGoodBean.getFnMarketPrice());
    }

    @Override
    public int getItemCount() {
        return null == scoreGoodList ? 0 : scoreGoodList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        ImageView ivIcon;
        TextView tvEnName;
        TextView tvName;
        TextView tvRequireScore;

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }
}
