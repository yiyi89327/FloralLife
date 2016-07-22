package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.activity.AuthorActivity;
import com.yunmeng.florallife.bean.ZtListItemValue;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 首页专题的List所用的bean类
 * Created by my on 2016/7/12.
 */
public class ZtListItemAdapter extends BaseAdapter {

    private List<ZtListItemValue.ResultBean> data;
    private LayoutInflater layoutInflater;
    private Context context;
    public List<ZtListItemValue.ResultBean> getResult() {
        return data;
    }

    public ZtListItemAdapter(List<ZtListItemValue.ResultBean> data, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if(null == convertView){
            convertView = layoutInflater.inflate(R.layout.zhuanti_list_item,null);
            viewHolder = new ViewHolder(convertView);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ZtListItemValue.ResultBean item = data.get(position);
        Picasso.with(context).load(item.getSmallIcon()).into(viewHolder.iv_zt_icon);
        Picasso.with(context).load(item.getAuthor().getHeadImg()).into(viewHolder.cv_zt_author_img);
        viewHolder.tv_zt_author_name.setText(item.getAuthor().getUserName());
        viewHolder.tv_zt_author_class.setText(item.getAuthor().getIdentity());

        viewHolder.tv_zt_tag.setText("["+item.getCategory().getName()+"]");
        viewHolder.tv_zt_title.setText(item.getTitle());
        viewHolder.tv_zt_explain.setText(item.getDesc());
        viewHolder.tv_zt_collect_num.setText(item.getAppoint()+"");
        viewHolder.tv_zt_discuss_num.setText(item.getFnCommentNum()+"");
        viewHolder.tv_zt_eye_num.setText(item.getRead()+"");


        viewHolder.cv_zt_author_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, AuthorActivity.class);
                intent1.putExtra("id",data.get(position).getAuthor().getId());
                context.startActivity(intent1);
            }
        });
        return convertView;
    }

    public static class ViewHolder {
        //"smallIcon"
        //"author"-"headImg"
        //"author":   "userName":"一窝时光",
        //"author":   "identity":"资深设计师"
        //"category":  "name":"家居庭院",
        //"title":"那一抹迷人的红｜乌木杂",
        //"desc"
        //"read"
        //"share"
        //"fnCommentNum"
        @Bind(R.id.iv_zt_icon)
        ImageView iv_zt_icon;
        @Bind(R.id.cv_zt_author_img)
        CircleImageView cv_zt_author_img;

        @Bind(R.id.tv_zt_author_name)
        TextView tv_zt_author_name;
        @Bind(R.id.tv_zt_author_class)
        TextView tv_zt_author_class;

        @Bind(R.id.tv_zt_tag)
        TextView tv_zt_tag;
        @Bind(R.id.tv_zt_title)
        TextView tv_zt_title;
        @Bind(R.id.tv_zt_explain)
        TextView tv_zt_explain;

        @Bind(R.id.tv_zt_eye_num)
        TextView tv_zt_eye_num;
        @Bind(R.id.tv_zt_collect_num)
        TextView tv_zt_collect_num;
        @Bind(R.id.tv_zt_discuss_num)
        TextView tv_zt_discuss_num;

        public ViewHolder(View view) {
            view.setTag(this);
            ButterKnife.bind(this,view);
        }

    }
}
