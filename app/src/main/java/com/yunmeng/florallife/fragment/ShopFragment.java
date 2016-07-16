package com.yunmeng.florallife.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.PullToRefreshAdapter;
import com.yunmeng.florallife.bean.MallChosenItem;
import com.yunmeng.florallife.bean.MallScore;
import com.yunmeng.florallife.utils.URLConstant;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 商城那一整页的Fragment
 * create by qianyuling on 2016/7/16.
 */
public class ShopFragment extends Fragment {

    Context mContext;
    @Bind(R.id.shop_list_btn)
    CheckBox shopck;
    @Bind(R.id.shop_search)
    ImageView shopsc;
    @Bind(R.id.shop_ll)
    LinearLayout ll;

    @Bind(R.id.shop_pull_lv)
    PullToRefreshListView mPullToRefreshListView;
    private ExpandableListView guidelistView;
    private HeaderViewHolder headerViewHolder;
    private View headerView;
    public  LinearLayout f_linearGone;

    private PullToRefreshAdapter adapter;
    private List<MallChosenItem.ResultBean> chosenList = new ArrayList<>();
    private List<MallScore.ResultBean> scoreList = new ArrayList();
    public static int TYPE_MALL = 0;
    //dataList里的数据为精选、商城、积分的数据List,请在括号后自主添加继承的bean类
    private List<List<?>> dataList = new ArrayList<>();

    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this,view);

        //初始化PullToRefreshListView的头部视图
        initHeaderView();
        //初始化商城—精选页面的数据
        setChosenData();
        //初始化商城—商城页面的数据
        setShoppingData();
        //初始化商城—积分页面的数据
        setScoresData();

        //根据TYPE_MALL的值从总数据中取出当前页面的数据List，默认TYPE_MALL = 0，即加载精选页面数据
        adapter = new PullToRefreshAdapter(dataList.get(TYPE_MALL), getContext());
        //绑定PullToRefreshListViewAdapter
        mPullToRefreshListView.setAdapter(adapter);

        initListener();

        return view;
    }

    private void initHeaderView() {
        headerView = LayoutInflater.from(getActivity()).inflate(R.layout.item_mall_headview,null);
        headerViewHolder = new HeaderViewHolder(headerView);
        f_linearGone = headerViewHolder.linearGone;

        //PullToRefreshListView必须先执行getRefreshableView()方法才能添加头部视图
        mPullToRefreshListView.getRefreshableView().addHeaderView(headerView);
    }

    //定义一个初始化视图控件的类
    class HeaderViewHolder {

        @Bind(R.id.iv_mall_head_icon)
        ImageView headIcon;
        @Bind(R.id.ll_mall_head_btngroup)
        LinearLayout linearBtnGroup;
        @Bind(R.id.v_headview_line)
        View vLine;
        @Bind(R.id.ll_headview_gone)
        LinearLayout linearGone;

        public HeaderViewHolder(View headerView) {
            ButterKnife.bind(this,headerView);
        }

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_mall_head_icon:

                break;
            case R.id.tv_mall_chosen:
                TYPE_MALL = 0;
                break;
            case R.id.tv_mall_shopping:
                TYPE_MALL = 1;
                break;
            case R.id.tv_mall_scores:
                //f_linearGone.setVisibility(View.VISIBLE);
                TYPE_MALL = 2;
                break;
        }
    }

    //初始化商城精选页面的数据
    private void setChosenData() {
        OkHttpTool.newInstance().start(URLConstant.MALLCHOSEN).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                if(result ==null){
                    return;
                }
                Gson gson = new Gson();
                MallChosenItem chosenItem = gson.fromJson(result, MallChosenItem.class);
                chosenList.addAll(chosenItem.getResult());
                adapter.notifyDataSetChanged();
            }
        });

        dataList.add(chosenList);
    }

    //初始化商城商城页面的数据
    private void setScoresData() {

    }

    //初始化商城积分页面的数据
    private void setShoppingData() {
        OkHttpTool.newInstance().start(URLConstant.MALL_SCORE).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                if(result ==null){
                    return;
                }
                Gson gson = new Gson();
                MallScore mallScore = gson.fromJson(result,MallScore.class);
                scoreList.addAll(mallScore.getResult());
                adapter.notifyDataSetChanged();
            }
        });

        dataList.add(scoreList);
    }

    private void initListener() {
        shopck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                PopupWindow popupWindow;
                if (isChecked){
                    View shopckview = LayoutInflater.from(mContext).inflate(R.layout.popupwindow_shop_list,null);
                    popupWindow = new PopupWindow(shopckview);
                    popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                    popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setFocusable(true);
                    ColorDrawable dw = new ColorDrawable(0xb00CCBBB);
                    popupWindow.setBackgroundDrawable(dw);
//                    window.setAnimationStyle(R.style.popupwindow_anim_style);
                    popupWindow.showAtLocation(ll, Gravity.TOP, 0, 220);
                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            shopck.setChecked(false);
                        }
                    });
                    guidelistView = (ExpandableListView) shopckview.findViewById(R.id.shop_guide_expandelv);
                }
            }
        });
    }


}
