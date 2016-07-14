package com.yunmeng.florallife.frg;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.activity.TopActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


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
    @Bind(R.id.simpletitle_listview)
    ListView listView;
    @Bind(R.id.simpletitle_ll)
    LinearLayout ll;
    @Bind(R.id.simpletitle_toolbar_rl)
    RelativeLayout rl;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_simple_title, container, false);
        ButterKnife.bind(this, view);
        //所有点击事件
        clickway();


        return view;
    }


    private void clickway() {
        //toolbar中中间专题的点击事件
        selecter.setOnClickListener(new View.OnClickListener() {
            PopupWindow popupWindow;
            @Override
            public void onClick(View v) {
                if (selecter.isChecked()) {
                    View views = LayoutInflater.from(mContext).inflate(R.layout.popupwindow_selecter, null);
                    popupWindow = new PopupWindow(views);
                    popupWindow.setWidth(250);
                    popupWindow.setHeight(250);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.showAtLocation(ll, Gravity.TOP, 0, 200);
                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            selecter.setChecked(false);
                        }
                    });
                }else {
                    popupWindow.dismiss();
                }
            }
        });
        listbtn.setOnClickListener(new View.OnClickListener() {
            PopupWindow window;
            @Override
            public void onClick(View v) {
                if (listbtn.isChecked()) {
                    View listbtnview = LayoutInflater.from(mContext).inflate(R.layout.popupwindow_list, null);
                    window = new PopupWindow(listbtnview);
                    window.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                    window.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                    window.setOutsideTouchable(true);
                    window.setFocusable(true);
                    ColorDrawable dw = new ColorDrawable(0xb0000000);
                    window.setBackgroundDrawable(dw);
//                    window.setAnimationStyle(R.style.popupwindow_anim_style);
                    window.showAtLocation(ll, Gravity.TOP, 0, 220);
                    window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            listbtn.setChecked(false);
                        }
                    });
                }else {
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



}
