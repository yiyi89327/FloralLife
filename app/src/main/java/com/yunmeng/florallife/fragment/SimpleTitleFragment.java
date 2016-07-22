package com.yunmeng.florallife.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.activity.ArticleActivity;
import com.yunmeng.florallife.activity.AuthorActivity;
import com.yunmeng.florallife.activity.DetailActivity;
import com.yunmeng.florallife.activity.SimpleGuideActivity;
import com.yunmeng.florallife.activity.TopActivity;
import com.yunmeng.florallife.activity.VideoActivity;
import com.yunmeng.florallife.adapter.GuideSimpleAdapter;
import com.yunmeng.florallife.adapter.ZtListItemAdapter;
import com.yunmeng.florallife.bean.GuidelistValue;
import com.yunmeng.florallife.bean.UrlConfig;
import com.yunmeng.florallife.bean.ZtListItemValue;
import com.yunmeng.florallife.utils.Commentway;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class SimpleTitleFragment extends Fragment {

    public static SimpleTitleFragment newInstance() {
        SimpleTitleFragment fragment = new SimpleTitleFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Bind(R.id.simpletitle_list_btn)
    CheckBox listbtn;
    @Bind(R.id.simpletitle_top)
    TextView top;
    @Bind(R.id.simpletitle_title_selecter)
    CheckBox selecter;
    @Bind(R.id.sipmletitle_pull_lv)
    PullToRefreshListView listView;
    @Bind(R.id.simpletitle_ll)
    LinearLayout ll;
    @Bind(R.id.simpletitle_toolbar_rl)
    RelativeLayout rl;
    View view;
    List<ZtListItemValue.ResultBean> ztlist = new ArrayList<>();
    ZtListItemAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_simple_title, container, false);
        ButterKnife.bind(this, view);
        clickway();
        listadpter();

        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                adapter.notifyDataSetChanged();
                String label = DateUtils.formatDateTime(mContext,System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME|DateUtils.FORMAT_SHOW_DATE|DateUtils.FORMAT_ABBREV_ALL);
                SharedPreferences preferences = mContext.getSharedPreferences("lastupdatetime",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("label",label);
                editor.commit();

                String uptime = preferences.getString("label","");
                listView.getLoadingLayoutProxy().setLastUpdatedLabel("最后更新时间："+ uptime);
                listView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       listView .onRefreshComplete();
                    }
                },1000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
        listView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        ILoadingLayout startLayout = listView.getLoadingLayoutProxy(true,false);
        startLayout.setPullLabel("下拉可以刷新");
        startLayout.setRefreshingLabel("正在刷新数据中...");
        startLayout.setReleaseLabel("松开立即刷新");


        return view;
    }

    //专题listview适配器
    private void listadpter() {
        OkHttpTool.newInstance().start(UrlConfig.URL_SIMPLE_LIST).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                ZtListItemValue ztListItemValue = gson.fromJson(result, ZtListItemValue.class);
                ztlist = ztListItemValue.getResult();
                adapter = new ZtListItemAdapter(ztlist, mContext);
                listView.setAdapter(adapter);
            }
        });
    }

    private ListView classfylv;
    private TextView carticle;
    private TextView cvideo;

    List<String> classfyName = new ArrayList<>();
    GuidelistValue guidelistValue;
    List<GuidelistValue.ResultBean> classfyvl = new ArrayList<>();

    //toolbar上的所有点击事件
    private void clickway() {

        //list 点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                Commentway commentway = new Commentway();
                Bundle bundle = commentway.onclickway(ztlist, position);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
        //toolbar中中间专题的点击事件
        selecter.setOnClickListener(new View.OnClickListener() {
            PopupWindow popupWindow;

            @Override
            public void onClick(View v) {
                if (selecter.isChecked()) {
                    View views = LayoutInflater.from(mContext).inflate(R.layout.popupwindow_selecter, null);
                    popupWindow = new PopupWindow(views);
                    popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
                    popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.showAsDropDown(rl,rl.getWidth()/2-50,0);
                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            selecter.setChecked(false);
                        }
                    });
                    carticle = (TextView) views.findViewById(R.id.topcenter_article);
                    cvideo = (TextView) views.findViewById(R.id.topcenter_video);

                    carticle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1 = new Intent(mContext, ArticleActivity.class);
                            startActivity(intent1);
                        }
                    });
                    cvideo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1 = new Intent(mContext, VideoActivity.class);
                            startActivity(intent1);
                        }
                    });

                }else {
                    popupWindow.dismiss();
                }
            }
        });

        //左上角点击事件
        listbtn.setOnClickListener(new View.OnClickListener() {
            PopupWindow window;
            @Override
            public void onClick(View v) {
                if (listbtn.isChecked()) {
                    View listbtnview = LayoutInflater.from(mContext).inflate(R.layout.popupwindow_list, null);
                    window = new PopupWindow(listbtnview);
                    window.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                    window.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
                    window.setOutsideTouchable(true);
                    window.setFocusable(true);
                    ColorDrawable dw = new ColorDrawable(0xebcccccc);
                    window.setBackgroundDrawable(dw);
                    window.showAsDropDown(rl);
                    window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            listbtn.setChecked(false);
                        }
                    });
                    //为导航栏的list设置内容
                    classfylv = (ListView) listbtnview.findViewById(R.id.classfy_list);
                    classfylv.setDivider(null);
                    classfylv.setDividerHeight(120);
                    OkHttpTool.newInstance().start(UrlConfig.URL_SIMPLE_GUIDE).callback(new IOKCallBack() {
                        @Override
                        public void success(String result) {
                            Gson gson = new Gson();
                            guidelistValue = gson.fromJson(result, GuidelistValue.class);
                            classfyvl = guidelistValue.getResult();
                            for (int i = 0; i < classfyvl.size();i++) {
                                    classfyName.add(classfyvl.get(i).getName());
                            }
                            GuideSimpleAdapter adpter = new GuideSimpleAdapter(classfyName,mContext);
                            classfylv.setAdapter(adpter);
                        }
                    });
                    classfylv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(mContext, SimpleGuideActivity.class);
                            intent.putExtra("title", classfyvl.get(position).getName());
                            intent.putExtra("id", classfyvl.get(position).getId());
                            startActivity(intent);
                        }
                    });
                } else {
                    window.dismiss();
                }
            }
        });

        //TOP的点击事件
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TopActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        classfyvl.clear();
        ztlist.clear();
    }


}
