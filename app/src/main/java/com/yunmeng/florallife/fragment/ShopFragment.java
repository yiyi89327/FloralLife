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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.yunmeng.florallife.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ShopFragment extends Fragment {


    public ShopFragment() {

    }


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this,view);

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
                }
            }
        });
        return view;
    }



}
