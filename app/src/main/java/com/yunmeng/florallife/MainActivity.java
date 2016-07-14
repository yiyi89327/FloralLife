package com.yunmeng.florallife;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yunmeng.florallife.frg.MineFragment;
import com.yunmeng.florallife.frg.ShopFragment;
import com.yunmeng.florallife.frg.SimpleTitleFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    @Bind(R.id.rg)
    RadioGroup rg;
    FragmentManager manager;
    FragmentTransaction transaction;

    private SimpleTitleFragment simpleTitleFragment;
    private ShopFragment shopFragment;
    private MineFragment mineFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //获取fragment的manager
        manager = getSupportFragmentManager();
        rg.setOnCheckedChangeListener(this);
        ((RadioButton)rg.getChildAt(0)).setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction = manager.beginTransaction();
        //设置显示与隐藏的fragment
        hindAll(transaction);
        switch (checkedId){
            case R.id.simpletitle:
                if (simpleTitleFragment == null){
                    simpleTitleFragment = SimpleTitleFragment.newInstance();
                    transaction.add(R.id.main_ll,simpleTitleFragment);
                }else {
                    transaction.show(simpleTitleFragment);
                }
                break;
            case R.id.shop:
                if (shopFragment == null){
                    shopFragment = ShopFragment.newInstance();
                    transaction.add(R.id.main_ll,shopFragment);
                }else {
                    transaction.show(shopFragment);
                }
                break;
            case R.id.mine:
                if (mineFragment == null){
                    mineFragment = MineFragment.newInstance();
                    transaction.add(R.id.main_ll,mineFragment);
                }else {
                    transaction.show(mineFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hindAll(FragmentTransaction transaction) {
        if (simpleTitleFragment != null){
            transaction.hide(simpleTitleFragment);
        }
        if (shopFragment != null) {
            transaction.hide(shopFragment);
        }
        if (mineFragment != null){
        transaction.hide(mineFragment);
        }
    }
}
