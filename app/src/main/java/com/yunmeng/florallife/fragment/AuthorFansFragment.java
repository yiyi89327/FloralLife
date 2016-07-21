package com.yunmeng.florallife.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.activity.UserActivity;
import com.yunmeng.florallife.adapter.AuthorFansListAdapter;
import com.yunmeng.florallife.bean.AuthorFans;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者个人中心的订阅者Fragment
 * Created by hanyiyi on 2016/7/14.
 */
public class AuthorFansFragment extends Fragment {

    private List<AuthorFans> fansList = new ArrayList<>();

    private View view;
    private ListView lvFans;
    private AuthorFansListAdapter authorFansListAdapter;

    public static AuthorFansFragment newInstance() {
        Bundle args = new Bundle();
        AuthorFansFragment fragment = new AuthorFansFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    /**
     * 由于没有接口，此处数据均为虚构！！！！！！！！！！
     */
    private void initData() {

        fansList.add(new AuthorFans("ZzzZ滢",R.drawable.fake_icon1));
        fansList.add(new AuthorFans("tangx1010101010",R.drawable.fake_icon2));
        fansList.add(new AuthorFans("叶子童鞋",R.drawable.fake_icon3));
        fansList.add(new AuthorFans("木易",R.drawable.fake_icon4));
        fansList.add(new AuthorFans("Nicola",R.drawable.fake_icon5));
        fansList.add(new AuthorFans("骆媛媛",R.drawable.fake_icon6));
        fansList.add(new AuthorFans("_Cynthia雅",R.drawable.fake_icon7));
        fansList.add(new AuthorFans("叮叮猫_JQ",R.drawable.fake_icon8));
        fansList.add(new AuthorFans("匿名用户",R.drawable.personal_shoucang_default));
        fansList.add(new AuthorFans("---胡萝卜---",R.drawable.fake_icon9));
        fansList.add(new AuthorFans("din",R.drawable.fake_icon10));
        fansList.add(new AuthorFans("米喵咪喵咪",R.drawable.fake_icon11));
        fansList.add(new AuthorFans("匿名用户",R.drawable.personal_shoucang_default));
        fansList.add(new AuthorFans("聿梓翀_乙苯",R.drawable.fake_icon12));
        fansList.add(new AuthorFans("Clover",R.drawable.fake_icon13));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_author_fans, container, false);
        lvFans = (ListView) view.findViewById(R.id.lv_author_fans);
        bindAdapter();
        initListener();
        return view;
    }

    private void bindAdapter() {
        authorFansListAdapter = new AuthorFansListAdapter(getContext(),fansList);
        lvFans.setAdapter(authorFansListAdapter);
    }

    private void initListener(){
        lvFans.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), UserActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("userName", fansList.get(position).getUserName());
                bundle.putInt("userIcon", fansList.get(position).getUserIconId());
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
    }
}
