package com.yunmeng.florallife.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.yunmeng.florallife.MainActivity;
import com.yunmeng.florallife.R;

public class WelcomeActivity extends AppCompatActivity {

    private Runnable runnable;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

        runnable = new Runnable(){
            @Override
            public void run() {

                SharedPreferences preferences = getApplicationContext().getSharedPreferences("firstlog", Context.MODE_PRIVATE);
                boolean isfirst = preferences.getBoolean("isfirst",true);
                if (isfirst){
                    Intent intent = new Intent(getApplicationContext(),GuideAvticity.class);
                    startActivity(intent);
                    SharedPreferences preferences1 = getApplicationContext().getSharedPreferences("firstlog",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences1.edit();
                    editor.putBoolean("isfirst",false);
                    editor.commit();
                    finish();
                }else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        handler = new Handler();
        handler.postDelayed(runnable,2000);
    }
}
