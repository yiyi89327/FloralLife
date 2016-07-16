package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.PersonalCenter;
import com.yunmeng.florallife.bean.TopAuthor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 个人中心中介绍一栏的ListView的适配器
 * Created by my on 2016/7/15.
 */
public class AuthorIntroListAdapter extends BaseAdapter {

    private List<PersonalCenter.ResultBean.ListContentBean> introList = new ArrayList();
    private Context context;

    public AuthorIntroListAdapter(List<PersonalCenter.ResultBean.ListContentBean> introList, Context context) {
        this.introList = introList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return null == introList ? 0 : introList.size();
    }

    @Override
    public Object getItem(int position) {
        return introList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_lv_author_intro, parent, false);
            viewHolder.tvFirstContent = (TextView) convertView.
                    findViewById(R.id.tv_author_intro_first_content);
            viewHolder.tvSecondContent = (TextView) convertView.
                    findViewById(R.id.tv_author_intro_second_content);
            viewHolder.tvThirdContent = (TextView) convertView.
                    findViewById(R.id.tv_author_intro_third_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PersonalCenter.ResultBean.ListContentBean listContentBean = introList.get(position);
        viewHolder.tvFirstContent.setText(listContentBean.getContentFirst());
        // 二级标题如果为空则隐藏，不为空则显示并更改数据
        String contentSecond = listContentBean.getContentSecond();
        if ("".equals(contentSecond)){
            viewHolder.tvSecondContent.setVisibility(View.GONE);
        } else {
            viewHolder.tvSecondContent.setVisibility(View.VISIBLE);
            viewHolder.tvSecondContent.setText(contentSecond);
        }
        // 三级标题如果为空则隐藏，不为空则显示并更改数据
        String contentThird = listContentBean.getContentThird();
        if ("".equals(contentThird)){
            viewHolder.tvThirdContent.setVisibility(View.GONE);
        } else {
            viewHolder.tvThirdContent.setVisibility(View.VISIBLE);
            viewHolder.tvThirdContent.setText(contentSecond);
        }
        return convertView;
    }

    class ViewHolder{
        TextView tvFirstContent;
        TextView tvSecondContent;
        TextView tvThirdContent;
    }
}
