package com.yunmeng.florallife.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.yunmeng.florallife.MainActivity;
import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.Databean;
import com.yunmeng.florallife.db.SqliteHelper;
import com.yunmeng.florallife.db.dao.Dao;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by my on 2016/7/14.
 */
public class MyLoginActivity extends AppCompatActivity {

    @Bind(R.id.et_my_phone)
    EditText phonenum;
    @Bind(R.id.et_my_psw)
    EditText psws;
    @Bind(R.id.btn_my_login)
    Button btn;
    @Bind(R.id.btn_my_back)
    Button back;
    @Bind(R.id.btn_my_close)
    Button close;
    private Dao dao;
    private List<Databean> list;
    String getpsw = "";

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        dao = new Dao(this);
        List<Databean> d = dao.quary();
        list.addAll(d);


        closeWay();

        final List<String> one = new ArrayList<>();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = phonenum.getText().toString();
                String psw = psws.getText().toString();

                for (int i = 0;i < list.size();i++){
                    one.add(list.get(i).getNum());
                }
                if (one.contains(num)){
                    for (int i = 0;i < list.size();i++){
                        if (list.get(i).getNum().equals(num)){
                            getpsw = list.get(i).getPsw();
                        }
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"用户名有误",Toast.LENGTH_LONG).show();
                }
                if (getpsw.equals(psw)){
                    SharedPreferences preferences = getSharedPreferences("Islog", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("islog",true);
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"密码格式不正确",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void closeWay() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_my_agreement:
                Intent intent = new Intent(this, MyAgreementActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_my_close:
                finish();
                break;
            case R.id.tv_my_create:
                Intent intent2 = new Intent(this, MyCreateActivity.class);
                startActivity(intent2);
                break;
            case R.id.tv_my_forget:
                Intent intent3 = new Intent(this, MyForgetActivity.class);
                startActivity(intent3);
                break;
        }
    }

}


