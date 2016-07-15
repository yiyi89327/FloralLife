package com.yunmeng.florallife.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;
import com.yunmeng.florallife.R;

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
    TextView time;
    @Bind(R.id.detail_read_num)
    TextView readnum;
    @Bind(R.id.detail_like_num)
    TextView likenum;
    @Bind(R.id.detail_speak_num)
    TextView speaknum;
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
        Bundle bundle = getIntent().getBundleExtra("bundle");
        String vediourl = bundle.getString("vediourl");
        if (vediourl.isEmpty()) {
            Picasso.with(this).load(bundle.getString("img")).into(imageView);
        }else {
            video.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            media(vediourl);
        }
        webView.loadUrl(bundle.getString("weburl"));
        title.setText(bundle.getString("title"));
        category_neme.setText(bundle.getString("name"));
        time.setText(bundle.getString("time"));
        readnum.setText(bundle.getString("readnum"));
        likenum.setText(bundle.getString("likenum"));
        speaknum.setText(bundle.getString("commentnum"));

    }

    private void media(String vediourl) {
        MediaController controller = new MediaController(this);
        video.setMediaController(controller);
        video.setVideoPath(vediourl);
        video.start();
      //  video.requestFocus();
    }
}
