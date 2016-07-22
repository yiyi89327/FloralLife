package com.yunmeng.florallife.activity;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.MotionEvent;
        import android.view.View;
        import android.webkit.WebSettings;
        import android.webkit.WebView;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;
        import com.yunmeng.florallife.R;

        import butterknife.Bind;
        import butterknife.ButterKnife;

public class ShopDetailActicity extends AppCompatActivity {

    @Bind(R.id.btn_shop_detail_back)
    ImageView back;
    @Bind(R.id.shopdetail_title)
    TextView titles;
    @Bind(R.id.shopdetail_add)
    Button add;
    @Bind(R.id.shopdetail_buy)
    Button buy;
    @Bind(R.id.shop_detail_price)
    TextView prices;
    @Bind(R.id.shopdetail_web1)
    WebView webView1;
    @Bind(R.id.shopdetail_web2)
    WebView webView2;
    @Bind(R.id.shopdetail_web3)
    WebView webView3;
    @Bind(R.id.shopdetail_web4)
    WebView webView4;
    @Bind(R.id.btn_shop_detail_share)
    ImageView share;
    @Bind(R.id.shopdetail_img)
    ImageView imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail_acticity);
        ButterKnife.bind(this);

        String img = getIntent().getStringExtra("img");
        String title = getIntent().getStringExtra("title");
        String first = getIntent().getStringExtra("first");
        String price = getIntent().getStringExtra("price");
        String second = getIntent().getStringExtra("second");
        String three = getIntent().getStringExtra("three");
        String four = getIntent().getStringExtra("four");
        String five = getIntent().getStringExtra("five");

        titles.setText(title);
        Picasso.with(this).load(img).into(imgs);

//        webView1.setUseWideViewPort(false);  //将图片调整到适合webview的大小
//        webView1.setSupportZoom(true);  //支持缩放
//        webView1.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView1.getSettings().setDefaultTextEncodingName("UTF -8");
        webView2.getSettings().setDefaultTextEncodingName("UTF -8");
        webView2.loadData(second, "text/html; charset=UTF-8", null);
        webView3.getSettings().setDefaultTextEncodingName("UTF -8");
        webView2.getSettings().getUseWideViewPort();
        webView2.getSettings().setSupportZoom(true);
        webView2.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView3.loadData(three, "text/html; charset=UTF-8", null);
        webView4.getSettings().setDefaultTextEncodingName("UTF -8");
        webView4.loadData(four, "text/html; charset=UTF-8", null);

        prices.setText(price);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
