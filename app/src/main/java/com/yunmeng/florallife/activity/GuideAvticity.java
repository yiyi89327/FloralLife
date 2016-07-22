package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.yunmeng.florallife.MainActivity;
import com.yunmeng.florallife.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GuideAvticity extends AppCompatActivity {

    @Bind(R.id.guide_viewpager)
    ViewPager viewPager;
    @Bind(R.id.enter_btn)
    Button enter;


    private MyPagerAdpter adpter;
    private List<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide_avticity);

        ButterKnife.bind(this);


        list = new ArrayList<>();

        list.add(getLayoutInflater().inflate(R.layout.viewpager_1, null));
        list.add(getLayoutInflater().inflate(R.layout.viewpager_2, null));
        list.add(getLayoutInflater().inflate(R.layout.viewpager_3,null));


        adpter = new MyPagerAdpter();
        viewPager.setAdapter(adpter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                if (position == 2){
                    enter.setVisibility(View.VISIBLE);
                    enter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                    });
                }else {
                    enter.setVisibility(View.GONE);
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    class MyPagerAdpter extends PagerAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }

    }
}
