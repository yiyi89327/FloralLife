package com.yunmeng.florallife.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.format.DateUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.CommentValue;
import com.yunmeng.florallife.bean.UrlConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class CommentActicity extends AppCompatActivity {

    @Bind(R.id.btn_comment_back)
    ImageView back;
    @Bind(R.id.comment_pull_lv)
    PullToRefreshListView listView;
    @Bind(R.id.comment_ll)
    LinearLayout ll;
    private CommentAdapter adpter;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_acticity);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("id");
        adddata();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    List<CommentValue.ResultBean> data = new ArrayList<>();

    private void adddata() {
        OkHttpTool.newInstance().start(UrlConfig.URL_COMMENT_START + id + UrlConfig.URL_COMMENT_END).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                CommentValue commentValue = gson.fromJson(result, CommentValue.class);
                data = commentValue.result;
                adpter = new CommentAdapter(data);
                listView.setAdapter(adpter);
            }
        });


        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                adpter.notifyDataSetChanged();
                String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                SharedPreferences preferences = getApplicationContext().getSharedPreferences("lastupdatetime", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("label", label);
                editor.commit();

                String uptime = preferences.getString("label", "");
                listView.getLoadingLayoutProxy().setLastUpdatedLabel("最后更新时间：" + uptime);
                listView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listView.onRefreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
        listView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        ILoadingLayout startLayout = listView.getLoadingLayoutProxy(true, false);
        startLayout.setPullLabel("下拉可以刷新");
        startLayout.setRefreshingLabel("正在刷新数据中...");
        startLayout.setReleaseLabel("松开立即刷新");
    }

    private class CommentAdapter extends BaseAdapter {

        private final List<CommentValue.ResultBean> data;

        public CommentAdapter(List<CommentValue.ResultBean> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data == null ? 0 : data.size();
        }

        @Override
        public Object getItem(int position) {
            return data == null ? null : data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ViewHolder viewHolder = null;
            if (view == null) {
                view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_comment_item, null);
                viewHolder = new ViewHolder(view);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            if (!data.get(position).writer.getHeadImg().isEmpty()) {
                Picasso.with(getApplicationContext()).load(data.get(position).writer.getHeadImg()).into(viewHolder.headimg);
            }
            viewHolder.username.setText(data.get(position).writer.getUserName());
            viewHolder.info.setText(data.get(position).getContent());


            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                long currenttime = System.currentTimeMillis();
                Date d1 = df.parse(data.get(position).getCreateDate());
                long diff = currenttime - d1.getTime();//这样得到的差值是微秒级别

                long days = diff / (1000 * 60 * 60 * 24);
                long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
                long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);

                if (days > 1) {
                    viewHolder.time.setText(days + "天前");
                }
                if (days == 0 && hours >= 1) {
                    viewHolder.time.setText(hours + "小时前");
                }
                if (days == 0 && hours == 0) {
                    viewHolder.time.setText(minutes + "分钟前");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            viewHolder.reback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.popupwindow_comment_reback, null);
                    PopupWindow popupWindow = new PopupWindow(view);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setFocusable(true);
                    popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                    popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                    popupWindow.showAtLocation(ll, Gravity.BOTTOM, 0, 0);

                    EditText editText = (EditText) view.findViewById(R.id.comment_edit);
                    TextView textView = (TextView) view.findViewById(R.id.comment_send);

                }
            });
            return view;
        }
    }

    class ViewHolder {

        @Bind(R.id.comment_headimg)
        CircleImageView headimg;
        @Bind(R.id.comment_user_name)
        TextView username;
        @Bind(R.id.comment_info)
        TextView info;
        @Bind(R.id.comment_time)
        TextView time;
        @Bind(R.id.comment_more)
        ImageView more;
        @Bind(R.id.comment_recall_btn)
        TextView reback;

        public ViewHolder(View view) {
            view.setTag(this);
            ButterKnife.bind(this, view);

        }
    }
}
