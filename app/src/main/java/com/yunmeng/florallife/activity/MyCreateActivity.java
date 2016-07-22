package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yunmeng.florallife.R;
import com.yunmeng.florallife.bean.Databean;
import com.yunmeng.florallife.db.dao.Dao;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by my on 2016/7/14.
 */
public class MyCreateActivity extends AppCompatActivity {

    @Bind(R.id.et_create_my_phone)
    EditText phone;
    @Bind(R.id.et_my_create_psw)
    EditText text;
    @Bind(R.id.btn_my_create_register)
    Button btn;
    private Dao dao;
    private Databean databean;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_create);
        ButterKnife.bind(this);
        dao = new Dao(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databean = new Databean();
                String num = phone.getText().toString();
                String psw = text.getText().toString();
                databean.setNum(num);
                databean.setPsw(psw);
                dao.add(databean);
                finish();
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_my_create_agreement:
                Intent intent = new Intent(this, MyAgreementActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_my_create_back:
                finish();
                break;
            case R.id.btn_my_create_close:
                finish();
                break;
        }
    }

}
