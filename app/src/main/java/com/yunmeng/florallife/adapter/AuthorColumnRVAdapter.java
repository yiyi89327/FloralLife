package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.activity.DetailActivity;
import com.yunmeng.florallife.bean.ZtListItemValue;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Top中个人中心的专栏列表的Adapter
 * Created by hanyiyi on 2016/7/18.
 */
public class AuthorColumnRVAdapter extends RecyclerView.Adapter<AuthorColumnRVAdapter.AuthorColumnRVViewHolder> {

    private Context context;
    private List<ZtListItemValue.ResultBean> authorColumnList = new ArrayList<>();

    private View view;
    private String smallIcon;
    private String title;
    private String name;
    private String pageUrl;
    private String createDate;
    private int read;
    private String videoUrl;
    private int appoint;
    private int fnCommentNum;

    public AuthorColumnRVAdapter(Context context, List<ZtListItemValue.ResultBean> authorColumnList) {
        this.context = context;
        this.authorColumnList = authorColumnList;
    }

    @Override
    public AuthorColumnRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_rv_author_column, parent, false);
        return new AuthorColumnRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AuthorColumnRVViewHolder holder, final int position) {
        ZtListItemValue.ResultBean authorColumnBean = authorColumnList.get(position);

        // 获取跳转所需的属性
        smallIcon = authorColumnBean.getSmallIcon();
        title = authorColumnBean.getTitle();
        name = authorColumnBean.getCategory().getName();
        pageUrl = authorColumnBean.getPageUrl();
        createDate = authorColumnBean.getCreateDate();
        read = authorColumnBean.getRead();
        videoUrl = authorColumnBean.getVideoUrl();
        appoint = authorColumnBean.getAppoint();
        fnCommentNum = authorColumnBean.getFnCommentNum();

        // 设置视图
        Picasso.with(context).load(smallIcon).into(holder.ivImg);
        holder.tvTitle.setText(title);
        holder.tvSubtitle.setText(authorColumnBean.getDesc());
        holder.tvCollect.setText("  " + appoint);
        holder.tvWatch.setText("  " + read);

        // 设置监听
        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("img", authorColumnList.get(position).getSmallIcon());
                bundle.putString("title", authorColumnList.get(position).getTitle());
                bundle.putString("name", authorColumnList.get(position).getCategory().getName());
                bundle.putString("weburl", authorColumnList.get(position).getPageUrl());
                bundle.putString("time", authorColumnList.get(position).getCreateDate());
                bundle.putString("readnum", authorColumnList.get(position).getRead() + "");
                bundle.putString("vediourl", authorColumnList.get(position).getVideoUrl());
                bundle.putString("likenum", authorColumnList.get(position).getAppoint() + "");
                bundle.putString("commentnum", authorColumnList.get(position).getFnCommentNum() + "");
                intent.putExtra("bundle", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == authorColumnList ? 0 : authorColumnList.size();
    }

    class AuthorColumnRVViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.cv_author_column_item)
        CardView cvItem;

        @Bind(R.id.iv_author_column_item_img)
        ImageView ivImg;
        @Bind(R.id.tv_author_column_item_title)
        TextView tvTitle;
        @Bind(R.id.tv_author_column_item_subtitle)
        TextView tvSubtitle;
        @Bind(R.id.view_author_column_item_line)
        View line;
        @Bind(R.id.tv_author_column_item_collect)
        TextView tvCollect;
        @Bind(R.id.tv_author_column_item_watch)
        TextView tvWatch;

        public AuthorColumnRVViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}
