package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.activity.MallScoreDetailActivity;
import com.yunmeng.florallife.bean.MallScore;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by my on 2016/7/16.
 */
public class MallScoreRecyclerViewAdapter extends RecyclerView.Adapter<MallScoreRecyclerViewAdapter.MallScoreRecyclerViewHolder> {

    private Context context;
    private List<MallScore.ResultBean> scoreGoodList = new ArrayList<>();
    private View view;

    public MallScoreRecyclerViewAdapter(Context context, List<MallScore.ResultBean> scoreGoodList) {
        this.context = context;
        this.scoreGoodList = scoreGoodList;
    }

    @Override
    public MallScoreRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_rv_mall_score, parent, false);
        return new MallScoreRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MallScoreRecyclerViewHolder holder, final int position) {
        MallScore.ResultBean scoreGoodBean = scoreGoodList.get(position);
        Picasso.with(context).load(scoreGoodBean.getFnAttachment1()).into(holder.ivIcon);
        holder.tvEnName.setText(scoreGoodBean.getFnEnName());
        holder.tvName.setText(scoreGoodBean.getFnName());
        holder.tvRequireScore.setText("积分  " + scoreGoodBean.getFnMarketPrice());
        holder.llWhole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(context,MallScoreDetailActivity.class);
                intent3.putExtra("big_title", scoreGoodList.get(position).getFnName());
                intent3.putExtra("en_title", scoreGoodList.get(position).getFnEnName());
                intent3.putExtra("first", scoreGoodList.get(position).getFnFirstDesc());
                intent3.putExtra("second", scoreGoodList.get(position).getFnSecondDesc());
                intent3.putExtra("third", scoreGoodList.get(position).getFnThreeDesc());
                intent3.putExtra("fourth", scoreGoodList.get(position).getFnFourthDesc());
                intent3.putExtra("fifth", scoreGoodList.get(position).getFnFifthDesc());
                intent3.putExtra("img", scoreGoodList.get(position).getFnAttachment());
                intent3.putExtra("price", scoreGoodList.get(position).getFnMarketPrice()+"");
                context.startActivity(intent3);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == scoreGoodList ? 0 : scoreGoodList.size();
    }

    public static class MallScoreRecyclerViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.ll_mall_score_whole)
        LinearLayout llWhole;
        @Bind(R.id.iv_mall_score_icon)
        ImageView ivIcon;
        @Bind(R.id.tv_mall_score_en_name)
        TextView tvEnName;
        @Bind(R.id.tv_mall_score_name)
        TextView tvName;
        @Bind(R.id.tv_mall_score_require_score)
        TextView tvRequireScore;

        public MallScoreRecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
