package com.yunmeng.florallife.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import fm.jiecao.jcvideoplayer_lib.JCFullScreenActivity;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

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
    @Bind(R.id.video_detail)
    JCVideoPlayerStandard video;
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
        boolean hasVideo = bundle.getBoolean("video");

        if (hasVideo){
            imageView.setVisibility(View.GONE);
            video.setVisibility(View.VISIBLE);
            JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.video_detail);
            // 设置视频的地址和标题
            jcVideoPlayerStandard.setUp(vediourl, bundle.getString("title"));
            // 如果要进入就全屏播放视频，则使用下面这句话
//            JCFullScreenActivity.startActivity(this, vediourl, JCVideoPlayerStandard.class, bundle.getString("title"));
            // 设置缩略图
            Picasso.with(this).load(bundle.getString("img")).into(jcVideoPlayerStandard.thumbImageView);

        } else {
            imageView.setVisibility(View.VISIBLE);
            video.setVisibility(View.GONE);
        }

        webView.loadUrl(bundle.getString("weburl"));

        Picasso.with(this).load(bundle.getString("img")).into(imageView);

        title.setText(bundle.getString("title"));
        category_neme.setText(bundle.getString("name"));
        time.setText(bundle.getString("time"));
        readnum.setText(bundle.getString("readnum"));
        likenum.setText(bundle.getString("likenum"));
        speaknum.setText(bundle.getString("commentnum"));
    }


    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

}
