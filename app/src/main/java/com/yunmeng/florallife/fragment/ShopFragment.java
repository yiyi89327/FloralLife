package com.yunmeng.florallife.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.activity.MallAssortUpActivity;
import com.yunmeng.florallife.activity.MallChosenDetailActivity;
import com.yunmeng.florallife.adapter.MallScoreAdpter;
import com.yunmeng.florallife.adapter.PullToRefreshAdapter;
import com.yunmeng.florallife.adapter.ShopmallAdapter;
import com.yunmeng.florallife.bean.HeadImgValue;
import com.yunmeng.florallife.bean.MallChosenItem;
import com.yunmeng.florallife.bean.MallScore;
import com.yunmeng.florallife.bean.ShopGuideValue;
import com.yunmeng.florallife.bean.ShopmallValue;
import com.yunmeng.florallife.bean.UrlConfig;
import com.yunmeng.florallife.utils.URLConstant;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ShopFragment extends Fragment {

    private LinearLayout.LayoutParams lp;         // 设置View使用的布局参数

    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();
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

    @Bind(R.id.shop_list_btn)
    CheckBox shopck;
    @Bind(R.id.shop_search)
    ImageView shopsc;
    @Bind(R.id.shop_ll)
    LinearLayout ll;
    @Bind(R.id.shop_toolbar_rl)
    RelativeLayout rl;
    @Bind(R.id.shop_pull_lv)
    PullToRefreshListView listView;

    private ShopGuideAdapter adpter;
    private List<String> groupName = new ArrayList<>();
    List<ShopGuideValue.ResultBean> data = new ArrayList<>();


    private ExpandableListView guidelistView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this, view);

        shopck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                PopupWindow popupWindow;
                if (isChecked) {
                    View shopckview = LayoutInflater.from(mContext).inflate(R.layout.popupwindow_shop_list, null);
                    popupWindow = new PopupWindow(shopckview);
                    popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                    popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setFocusable(true);
                    ColorDrawable dw = new ColorDrawable(0xebcccccc);
                    popupWindow.setBackgroundDrawable(dw);
//                    window.setAnimationStyle(R.style.popupwindow_anim_style);
                    popupWindow.showAsDropDown(rl);
                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            shopck.setChecked(false);
                        }
                    });
                    guidelistView = (ExpandableListView) shopckview.findViewById(R.id.shop_guide_expandelv);
                    expandeview();
                }
            }
        });
        setShoppingData();
        initHeaderView();
        return view;
    }

    private View headerView;
    public  LinearLayout f_linearGone;

    private void initHeaderView() {
        HeaderViewHolder  headerViewHolder = null;
        headerView = LayoutInflater.from(getActivity()).inflate(R.layout.item_mall_headview,null);

        headerViewHolder = new HeaderViewHolder(headerView);
        f_linearGone = headerViewHolder.linearGone;

        final HeaderViewHolder finalHeaderViewHolder = headerViewHolder;

        // 获取indicator并设置初始margin
        final View indicator = headerView.findViewById(R.id.v_headview_line);
        View rg = headerView.findViewById(R.id.ll_mall_head_btngroup);
        lp = new LinearLayout.LayoutParams(80,2);
        ////////////////////////////////////////////////////////////////////
        /////////////////////////这里的初始margin设置是失败的/////////////////
        ////////////////////////////////////////////////////////////////////
        lp.setMargins(rg.getWidth()/6-40,0,0,0);


        indicator.setLayoutParams(lp);
        indicator.setBackgroundColor(Color.BLACK);

        OkHttpTool.newInstance().start(UrlConfig.URL_SHOP_HEAD).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                HeadImgValue headImgValue = gson.fromJson(result,HeadImgValue.class);
                List<HeadImgValue.ResultBean> result2 = headImgValue.result;
                Picasso.with(mContext).load(result2.get(0).getFnImageUrl()).into(finalHeaderViewHolder.headIcon);
                indicator.setLayoutParams(lp);
            }
        });
        headerViewHolder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.tv_mall_chosen:
                        setShoppingData();
                        f_linearGone.setVisibility(View.GONE);
                        // 设置indicator
                        lp.setMargins(group.getWidth()/6-40,0,0,0);
                        indicator.setLayoutParams(lp);
                        break;
                    case R.id.tv_mall_shopping:
                        testview();
                        f_linearGone.setVisibility(View.GONE);
                        lp.setMargins(group.getWidth()/2-40,0,0,0);
                        indicator.setLayoutParams(lp);
                        break;
                    case R.id.tv_mall_scores:
                        mallScore();
                        f_linearGone.setVisibility(View.VISIBLE);
                        lp.setMargins(group.getWidth()/6*5-40,0,0,0);
                        indicator.setLayoutParams(lp);
                        break;
                }
            }


        });
        //PullToRefreshListView必须先执行getRefreshableView()方法才能添加头部视图
        listView.getRefreshableView().addHeaderView(headerView);
    }
    class HeaderViewHolder {

        @Bind(R.id.iv_mall_head_icon)
        ImageView headIcon;
        @Bind(R.id.v_headview_line)
        View vLine;
        @Bind(R.id.ll_headview_gone)
        LinearLayout linearGone;
        @Bind(R.id.ll_mall_head_btngroup)
        RadioGroup radioGroup;
        public HeaderViewHolder(View headerView) {
            ButterKnife.bind(this,headerView);
        }

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_mall_head_icon:
                break;
        }
    }

    //精选的适配器及其数据
    private List<MallChosenItem.ResultBean> scoreList = new ArrayList();
    private PullToRefreshAdapter adapter;
    private void setShoppingData() {
        OkHttpTool.newInstance().start(URLConstant.MALLCHOSEN).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                if(result ==null){
                    return;
                }
                Gson gson = new Gson();
                MallChosenItem mallScore = gson.fromJson(result,MallChosenItem.class);
                scoreList = mallScore.getResult();
                //根据TYPE_MALL的值从总数据中取出当前页面的数据List，默认TYPE_MALL = 0，即加载精选页面数据
                adapter = new PullToRefreshAdapter(scoreList,mContext);
                //绑定PullToRefreshListViewAdapter
                listView.setAdapter(adapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, MallChosenDetailActivity.class);
                intent.putExtra("title", scoreList.get(position-2).getFnName());
                intent.putExtra("en_title", scoreList.get(position-2).getFnEnName());
                intent.putExtra("first", scoreList.get(position-2).getFnFirstDesc());
                intent.putExtra("second", scoreList.get(position-2).getFnSecondDesc());
                intent.putExtra("three", scoreList.get(position-2).getFnThreeDesc());
                intent.putExtra("four", scoreList.get(position-2).getFnFourthDesc());
                intent.putExtra("five", scoreList.get(position-2).getFnFifthDesc());
                intent.putExtra("img", scoreList.get(position-2).getFnAttachment());
                intent.putExtra("price", scoreList.get(position-2).getSkuList().get(0).getFnPrice()+"");
                startActivity(intent);
            }
        });
    }

    //商城list
    //商城适配器及其data
    List<ShopmallValue.ResultBean> testdata = new ArrayList<>();
    private ShopmallAdapter testadpter;
    private void testview() {
        OkHttpTool.newInstance().start(UrlConfig.URL_SHOP_BUY).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                if(result ==null){
                    return;
                }
                Gson gson = new Gson();
                ShopmallValue shopmallValue = gson.fromJson(result, ShopmallValue.class);
                testdata = shopmallValue.getResult();
                testadpter = new ShopmallAdapter(testdata, mContext);
                listView.setAdapter(testadpter);
            }
        });
    }
    //积分list
    //积分适配器及其data
    List<MallScore.ResultBean> result1 = new ArrayList<>();
    private MallScoreAdpter malladpter;
    private void mallScore() {
        OkHttpTool.newInstance().start(UrlConfig.URL_SHOP_SCORE).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                if (result == null){
                return;}
                Gson gson = new Gson();
                MallScore mallScore = gson.fromJson(result,MallScore.class);
                result1 = mallScore.getResult();
                malladpter = new MallScoreAdpter(mContext,result1);
                listView.setAdapter(malladpter);
            }

        });

    }

    private void expandeview() {
        OkHttpTool.newInstance().start(UrlConfig.URL_SHOP_GUIDE).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                ShopGuideValue shopGuideValue = gson.fromJson(result, ShopGuideValue.class);
                data = shopGuideValue.getResult();
                if (groupName.isEmpty()) {
                    for (int i = 0; i < data.size(); i++) {
                        groupName.add(data.get(i).getFnName());
                    }
                }
                adpter = new ShopGuideAdapter();
                guidelistView.setAdapter(adpter);
            }
        });

    }


    private class ShopGuideAdapter extends BaseExpandableListAdapter {
        @Override
        public int getGroupCount() {
            return groupName == null ? 0 : groupName.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            List<ShopGuideValue.ResultBean.ChildrenListBean> childrenList = new ArrayList<>();
            childrenList.addAll(data.get(groupPosition).getChildrenList());
            return childrenList == null ? 0 : childrenList.size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groupName.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            List<ShopGuideValue.ResultBean.ChildrenListBean> childrenList = new ArrayList<>();
            childrenList.addAll(data.get(groupPosition).getChildrenList());
            return childrenList.get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupViewHoder groupViewHoder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.expandelistview_out_shop_guide, null);
                groupViewHoder = new GroupViewHoder(convertView);
            } else {
                groupViewHoder = (GroupViewHoder) convertView.getTag();
            }
            groupViewHoder.textView.setText(groupName.get(groupPosition));
            return convertView;
        }

        @Override
        public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ChildViewHolder childViewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.expandelistview_inner_shop_guide, null);
                childViewHolder = new ChildViewHolder(convertView);
            } else {
                childViewHolder = (ChildViewHolder) convertView.getTag();
            }
            childViewHolder.textView.setText(data.get(groupPosition).getChildrenList().get(childPosition).getFnName());
            // 点击自条目的跳转（111）
            childViewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), MallAssortUpActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("title","分组列表");
                    bundle.putString("fnId",data.get(groupPosition).getChildrenList().get(childPosition).getFnId());
                    intent.putExtra("bundle",bundle);
                    getContext().startActivity(intent);
                }
            });
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }

    class GroupViewHoder {
        @Bind(R.id.out_title)
        TextView textView;

        public GroupViewHoder(View view) {
            view.setTag(this);
            ButterKnife.bind(this, view);
        }
    }

    class ChildViewHolder {
        @Bind(R.id.inner_title)
        TextView textView;

        public ChildViewHolder(View view) {
            view.setTag(this);
            ButterKnife.bind(this, view);
        }
    }




}
