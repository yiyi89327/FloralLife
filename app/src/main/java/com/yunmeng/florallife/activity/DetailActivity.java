package com.yunmeng.florallife.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @Bind(R.id.image_detail)
    ImageView imageView;
    @Bind(R.id.btn_main_detail_back)
    ImageView back;
    @Bind(R.id.btn_main_detail_share)
    ImageView share;
    @Bind(R.id.detail_title)
    TextView title;
    @Bind(R.id.detail_category_name)
    TextView category_neme;
    @Bind(R.id.detail_time)
    TextView times;
    @Bind(R.id.detail_read_num)
    RadioButton readnum;
    @Bind(R.id.detail_like_num)
    CheckBox likenum;
    @Bind(R.id.detail_speak_num)
    Button speaknum;
    @Bind(R.id.vedio_detail)
    VideoView video;
    @Bind(R.id.wb_detail)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        initview();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initview() {
        final Bundle bundle = getIntent().getBundleExtra("bundle");
        //  String vediourl = bundle.getString("vediourl");
        // if (vediourl.isEmpty()) {
        webView.loadUrl(bundle.getString("weburl"));

        Picasso.with(this).load(bundle.getString("img")).into(imageView);
        //}else {
        //    video.setVisibility(View.VISIBLE);
        //    imageView.setVisibility(View.GONE);
        //    media(vediourl);
        // }
        String time = bundle.getString("time");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try
        {
            long currenttime = System.currentTimeMillis();
            Date d1 = df.parse(time);
            long diff = currenttime-d1.getTime();//这样得到的差值是微秒级别

            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);

            if (days > 1){
                times.setText(days+"天前");
            }
            if(days== 0 && hours >=1){
                times.setText(hours + "小时前");
            }
            if (days==0&&hours == 0){
                times.setText(minutes + "分钟前");
            }
        }
        catch (Exception e)
        {
        }
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        title.setText(bundle.getString("title"));
        category_neme.setText(bundle.getString("name"));
        readnum.setText(bundle.getString("readnum"));
        likenum.setText(bundle.getString("likenum"));
        final int likenum1 = Integer.parseInt(bundle.getString("likenum")) + 1;
        likenum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    likenum.setText(likenum1+"");
                }else{
                    likenum.setText(bundle.getString("likenum"));
                }
            }
        });
        speaknum.setText(bundle.getString("commentnum"));

        speaknum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CommentActicity.class);
                intent.putExtra("id",bundle.getString("id"));
                startActivity(intent);
            }
        });

    }

    private void media(String vediourl) {
        MediaController controller = new MediaController(this);
        video.setMediaController(controller);
        video.setVideoPath(vediourl);
        video.setFocusable(true);
        video.start();
        //  video.requestFocus();
    }
}
