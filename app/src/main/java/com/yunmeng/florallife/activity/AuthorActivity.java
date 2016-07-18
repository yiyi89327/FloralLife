package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.adapter.MyViewPagerAdapter;
import com.yunmeng.florallife.bean.PersonalCenter;
import com.yunmeng.florallife.fragment.AuthorColumnFragment;
import com.yunmeng.florallife.fragment.AuthorFansFragment;
import com.yunmeng.florallife.fragment.AuthorIntroFragment;
import com.yunmeng.florallife.utils.URLConstant;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者个人中心的Activity
 * Created by hanyiyi on 2016/7/14.
 */
public class AuthorActivity extends AppCompatActivity {

    private List<String> tabTitle = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private ArrayList<PersonalCenter.ResultBean.ListContentBean> introList = new ArrayList<>();
    private String userName;

    private ImageView ivAuthorIconBig;
    private ImageView ivAuthorBack;
    private CircleImageView civAuthorIcon;
    private TextView tvAuthorName;
    private TextView tvAuthorCall;
    private TextView tvAuthorSlogan;
    private TextView tvAuthorSubscribeNum;
    private TextView tvAuthorSubscribe;
    private TabLayout tlAuthor;
    private ViewPager vpAuthor;

    private MyViewPagerAdapter myViewPagerAdapter;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initFragment();
            bindAdapter();
            tlAuthor.setupWithViewPager(vpAuthor);
            setupViewWithData();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        initTabData();
        initView();
        initFragmentBundle();

        initListener();

    }

    //点击跳转
    private void initListener() {
        // 顶部返回键
        ivAuthorBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // 圆形头像点击
        civAuthorIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivAuthorIconBig.setVisibility(View.VISIBLE);
            }
        });
        // 大头像点击
        ivAuthorIconBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivAuthorIconBig.setVisibility(View.GONE);
            }
        });

        // 点击订阅   这里要登录  没写！！！！！！！！！！！！！！！！！！！！
        tvAuthorSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    /**
     * 加载Top中TabLayout的标题
     */
    private void initTabData() {
        tabTitle.add("专栏");
        tabTitle.add("介绍");
        tabTitle.add("订阅者");
    }

    /**
     * 初始化本页面的控件
     * 1、最上方的Bar（仅初始化可点击的Back图片）
     * 2、上方视图（含有头像civ、用户名tv、用户称号tv、用户座右铭tv、用户订阅量tv、可点击的订阅tv）
     * 3、中间TabLayout
     * 4、下部ViewPager
     */
    private void initView() {
        ivAuthorIconBig = (ImageView) findViewById(R.id.iv_author_user_icon_big);
        ivAuthorBack = (ImageView) findViewById(R.id.iv_author_back);
        civAuthorIcon = (CircleImageView) findViewById(R.id.civ_author_user_icon);
        tvAuthorName = (TextView) findViewById(R.id.tv_author_user_name);
        tvAuthorCall = (TextView) findViewById(R.id.tv_author_user_call);
        tvAuthorSlogan = (TextView) findViewById(R.id.tv_author_user_slogan);
        tvAuthorSubscribeNum = (TextView) findViewById(R.id.tv_author_subscribe_number);    // 这个是作者被订阅的数量
        tvAuthorSubscribe = (TextView) findViewById(R.id.tv_author_subscribe);    // 这个是订阅按钮
        tlAuthor = (TabLayout) findViewById(R.id.tl_author);
        vpAuthor = (ViewPager) findViewById(R.id.vp_author);
    }

    /**
     * 获取需要传给Fragment的值
     */
    private void initFragmentBundle() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String url = URLConstant.AUTHOR_CENTER_BASE + id;
        OkHttpTool.newInstance().start(url).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                PersonalCenter personalCenter = gson.fromJson(result, PersonalCenter.class);
                PersonalCenter.ResultBean resultBean = personalCenter.getResult();
                // 获取介绍Fragment的内容，分解为可以传递的类型，以供传值
                introList = (ArrayList<PersonalCenter.ResultBean.ListContentBean>) resultBean.getListContent();
                userName = resultBean.getUserName();
                handler.sendEmptyMessage(1);

            }
        });
    }

    /**
     * 初始化本页的3个Fragment
     */
    private void initFragment(){

        // 实例化Fragment，传递上述的值
        fragmentList.add(AuthorColumnFragment.newInstance(userName));
        fragmentList.add(AuthorIntroFragment.newInstance(introList));
        fragmentList.add(AuthorFansFragment.newInstance());
    }

    /**
     * 绑定适配器
     * 1、ViewPager的适配器
     */
    public void bindAdapter(){
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),
                fragmentList,tabTitle);
        vpAuthor.setAdapter(myViewPagerAdapter);
    }

    /**
     * 装填各个控件的数据
     */
    public void setupViewWithData(){
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String url = URLConstant.AUTHOR_CENTER_BASE + id;
        OkHttpTool.newInstance().start(url).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                PersonalCenter personalCenter = gson.fromJson(result, PersonalCenter.class);
                PersonalCenter.ResultBean resultBean = personalCenter.getResult();
                RequestCreator load = Picasso.with(AuthorActivity.this).load(resultBean.getHeadImg());
                load.into(ivAuthorIconBig);
                load.into(civAuthorIcon);
                tvAuthorName.setText(resultBean.getUserName());
                tvAuthorCall.setText(resultBean.getIdentity());
                tvAuthorSlogan.setText(resultBean.getContent());
                tvAuthorSubscribeNum.setText("已有" + resultBean.getSubscibeNum() + "人订阅");

            }
        });
    }

}
