package com.app.huangsuixin1506101066.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.huangsuixin1506101066.App;
import com.app.huangsuixin1506101066.R;
import com.app.huangsuixin1506101066.bean.NewsInfo;
import com.bumptech.glide.Glide;

public class NewsContentView extends AppCompatActivity {

    private ImageButton btnBack;

    private NewsInfo newsInfo;
    private Intent intent;
    private Bundle bundle;
    private TextView barTitle, title, content;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content_view);

        App myApp = (App) getApplication();
        newsInfo = myApp.getNewsInfo();

        initViews();
        initListeners();

        if (newsInfo != null){
            initValues();
        }

    }

    private void initValues() {
        barTitle.setText(newsInfo.getTitle());
        title.setText(newsInfo.getTitle());
        content.setText(newsInfo.getContent());
        if (newsInfo.isHavePic()) {
            Glide.with(getApplicationContext())
                    .load(newsInfo.getImageurls().get(0).getUrl())
                    .placeholder(R.mipmap.icon_load) //加载时的图片
                    .into(img);
        }
    }

    private void initListeners() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initViews() {
        btnBack = (ImageButton) findViewById(R.id.btn_back);
        barTitle = (TextView) findViewById(R.id.bar_title);
        title = (TextView) findViewById(R.id.news_title);
        img = (ImageView) findViewById(R.id.news_img);
        content = (TextView) findViewById(R.id.news_content);
    }
}
