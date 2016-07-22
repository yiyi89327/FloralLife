package com.yunmeng.florallife;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yunmeng.florallife.activity.MyLoginActivity;
import com.yunmeng.florallife.fragment.MineFragment;
import com.yunmeng.florallife.fragment.ShopFragment;
import com.yunmeng.florallife.fragment.SimpleTitleFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.rg)
    RadioGroup rg;
    FragmentManager manager;
    FragmentTransaction transaction;
    Boolean islog ;

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
        ((RadioButton) rg.getChildAt(0)).setChecked(true);

        SharedPreferences preferences = getSharedPreferences("Islog", Context.MODE_PRIVATE);
        islog = preferences.getBoolean("islog", false);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction = manager.beginTransaction();
        //设置显示与隐藏的fragment
        hindAll(transaction);
        switch (checkedId) {
            case R.id.simpletitle:
                if (simpleTitleFragment == null) {
                    simpleTitleFragment = SimpleTitleFragment.newInstance();
                    transaction.add(R.id.main_ll, simpleTitleFragment);
                } else {
                    transaction.show(simpleTitleFragment);
                }
                break;
            case R.id.shop:
                if (shopFragment == null) {
                    shopFragment = ShopFragment.newInstance();
                    transaction.add(R.id.main_ll, shopFragment);
                } else {
                    transaction.show(shopFragment);
                }
                break;
            case R.id.mine:
                if (islog) {
                    if (mineFragment == null) {
                        mineFragment = MineFragment.newInstance();
                        transaction.add(R.id.main_ll, mineFragment);
                    } else {
                        transaction.show(mineFragment);
                    }
                } else {
                    Intent intent = new Intent(this, MyLoginActivity.class);
                    startActivity(intent);
                }
                break;
        }
        transaction.commit();
    }

    private void hindAll(FragmentTransaction transaction) {
        if (simpleTitleFragment != null) {
            transaction.hide(simpleTitleFragment);
        }
        if (shopFragment != null) {
            transaction.hide(shopFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            // 创建退出对话框
            AlertDialog isExit = new AlertDialog.Builder(this).create();
            // 设置对话框标题
            isExit.setTitle("系统提示");
            // 设置对话框消息
            isExit.setMessage("确定要退出吗");
            // 添加选择按钮并注册监听
            isExit.setButton("确定", listener);
            isExit.setButton2("取消", listener);
            // 显示对话框
            isExit.show();
        }
        return false;
    }

    /**监听对话框里面的button点击事件*/
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int which)
        {
            switch (which)
            {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    SharedPreferences preferences = getSharedPreferences("Islog",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("islog",false);
                    editor.commit();
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
