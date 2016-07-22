package com.yunmeng.florallife.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidxx.yangjw.httplibrary.IOKCallBack;
import com.androidxx.yangjw.httplibrary.OkHttpTool;
import com.google.gson.Gson;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.PersonValue;
import com.yunmeng.florallife.bean.UrlConfig;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class MineFragment extends Fragment {

    public MineFragment() {
    }


    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
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

    @Bind(R.id.person_name)
    TextView name;
    @Bind(R.id.person_jifen)
    TextView jifen;
    @Bind(R.id.person_jinyanzhi)
    TextView jinyan;
    @Bind(R.id.person_img)
    CircleImageView img;
    @Bind(R.id.person_shopcar)
    ImageView shopcar;
    @Bind(R.id.person_alarm)
    ImageView alarm;
    @Bind(R.id.dengji)
    TextView dengji;
    @Bind(R.id.seekbar_date)
    LinearLayout seekbardate;
    @Bind(R.id.person_ryview)
    RecyclerView ry;

    List<PersonValue.ResultBean> date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, view);

        initdata();

        return view;
    }

    private void initdata() {
        OkHttpTool.newInstance().start(UrlConfig.URL_USER_LIST).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                PersonValue personValue = gson.fromJson(result,PersonValue.class);
               date = personValue.result;

            }
        });
    }


}
