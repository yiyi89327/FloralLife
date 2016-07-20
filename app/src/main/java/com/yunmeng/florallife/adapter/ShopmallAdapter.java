package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.activity.MallChosenDetailActivity;
import com.yunmeng.florallife.activity.MallAssortActivity;
import com.yunmeng.florallife.bean.ShopmallValue;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 59857 on 2016/7/15.
 */
public class ShopmallAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<ShopmallValue.ResultBean> data;
    Context context;
    private ShopmallItemAdpter adpter;
    private String dessc;

    public ShopmallAdapter(List<ShopmallValue.ResultBean> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data == null? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return data == null ? null: data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.adpter_shopmall_start,null);
            viewHolder = new ViewHolder(convertView);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.desc.setText(data.get(position).getFnDesc());
        viewHolder.name.setText(data.get(position).getFnName());
        // 对分类的条目进行监听（111）
        viewHolder.rlTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MallAssortActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title","主题列表");
                bundle.putSerializable("goodsList",
                        (ArrayList<ShopmallValue.ResultBean.ChildrenListBean>)
                        data.get(position).getChildrenList());
                intent.putExtra("bundle",bundle);
                context.startActivity(intent);
            }
        });
        viewHolder.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        adpter = new ShopmallItemAdpter(data.get(position).getFnDesc(),data.get(position).getChildrenList());
        viewHolder.recyclerView.setAdapter(adpter);
        return convertView;
    }

    class ViewHolder{
        @Bind(R.id.rl_mall_mall_theme)
        RelativeLayout rlTheme;
        @Bind(R.id.shopmall_desc)
        TextView desc;
        @Bind(R.id.shopmall_name)
        TextView name;
        @Bind(R.id.shopmall_next_btn)
        ImageView btn;
        @Bind(R.id.shopmall_rcview)
        RecyclerView recyclerView;

        public ViewHolder(View view) {
            view.setTag(this);
            ButterKnife.bind(this,view);
        }
    }

    class InHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.shopmall_inner_name)
        TextView name;
        @Bind(R.id.shopmall_inner_desc)
        TextView desc;
        @Bind(R.id.shopmall_inner_price)
        TextView price;
        @Bind(R.id.shopmall_inner_img)
        ImageView imageView;
        @Bind(R.id.av_cardview)
        CardView cardView;


        public InHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private class ShopmallItemAdpter extends RecyclerView.Adapter<InHolder>{
        private List<ShopmallValue.ResultBean.ChildrenListBean> childrenList;
        private String fnDesc;
        public ShopmallItemAdpter(String fnDesc, List<ShopmallValue.ResultBean.ChildrenListBean> childrenList) {
            this.childrenList = childrenList;
            this.fnDesc = fnDesc;
        }

        @Override
        public InHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.adpter_shopmall_inner,null);
            return new InHolder(view);
        }

        @Override
        public void onBindViewHolder(InHolder holder, final int position) {
            holder.desc.setText(fnDesc);
            holder.name.setText(childrenList.get(position).getpGoods().getFnName());
            holder.price.setText(childrenList.get(position).getpGoods().getFnMarketPrice()+"");
            Picasso.with(context).load(childrenList.get(position).getpGoods().getFnAttachment1()).into(holder.imageView);
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent3 = new Intent(context,MallChosenDetailActivity.class);
                    intent3.putExtra("big_title", childrenList.get(position).getpGoods().getFnName());
                    intent3.putExtra("en_title", fnDesc);
                    intent3.putExtra("first", childrenList.get(position).getpGoods().getFnFirstDesc());
                    intent3.putExtra("second", childrenList.get(position).getpGoods().getFnSecondDesc());
                    intent3.putExtra("three", childrenList.get(position).getpGoods().getFnThreeDesc());
                    intent3.putExtra("four", childrenList.get(position).getpGoods().getFnFourthDesc());
                    intent3.putExtra("five", childrenList.get(position).getpGoods().getFnFifthDesc());
                    intent3.putExtra("img", childrenList.get(position).getpGoods().getFnAttachment());
                    intent3.putExtra("price", childrenList.get(position).getpGoods().getFnMarketPrice()+"");
                    context.startActivity(intent3);
                }
            });
        }
        @Override
        public int getItemCount() {
            if (childrenList != null){
                if (childrenList.size() < 4){
                    return childrenList.size();
                }else {
                    return 4;
                }
            }else {
                return 0;
            }
        }
    }

}
