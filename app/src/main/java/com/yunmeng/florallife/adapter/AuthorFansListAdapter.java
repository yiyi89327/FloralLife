package com.yunmeng.florallife.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.AuthorFans;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by my on 2016/7/21.
 */
public class AuthorFansListAdapter extends BaseAdapter {

    private Context context;
    private List<AuthorFans> fansList = new ArrayList<>();

    public AuthorFansListAdapter(Context context, List<AuthorFans> fansList) {
        this.context = context;
        this.fansList = fansList;
        Log.i("hyy", "AuthorFansListAdapter: fanslist.size = " + fansList.size());
    }

    @Override
    public int getCount() {
        return null == fansList ? 0 : fansList.size();
    }

    @Override
    public Object getItem(int position) {
        return fansList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_lv_author_fans, parent, false);
            viewHolder.civIcon = (CircleImageView) convertView.
                    findViewById(R.id.civ_author_fans_icon);
            viewHolder.tvUserName = (TextView) convertView.
                    findViewById(R.id.tv_author_fans_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.civIcon.setImageResource(fansList.get(position).getUserIconId());
        viewHolder.tvUserName.setText(fansList.get(position).getUserName());
        return convertView;
    }

    class ViewHolder {
        CircleImageView civIcon;
        TextView tvUserName;
    }
}
