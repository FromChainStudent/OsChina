package com.example.oschina.controller.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.oschina.R;
import com.example.oschina.base.BaseActivity;
import com.example.oschina.controller.fragment.NewsFragment;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.main_tv_title)
    TextView mainTvTitle;
    @Bind(R.id.main_layout_title)
    RelativeLayout mainLayoutTitle;
    @Bind(R.id.main_iv_btn)
    ImageButton main_iv_btn;
    @Bind(R.id.main_layout_frame)
    FrameLayout mainLayoutFrame;
    @Bind(R.id.main_btn_news)
    RadioButton mainBtnNews;
    @Bind(R.id.main_btn_tweet)
    RadioButton mainBtnTweet;
    @Bind(R.id.main_btn_add)
    RadioButton mainBtnAdd;
    @Bind(R.id.main_btn_discover)
    RadioButton mainBtnDiscover;
    @Bind(R.id.main_btn_my)
    RadioButton mainBtnMy;

    @Override
    protected int layoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_layout_frame, new NewsFragment());
        transaction.commit();
    }

    @Override
    protected void loadData() {
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.main_btn_news, R.id.main_btn_tweet, R.id.main_btn_add, R.id.main_btn_discover, R.id.main_btn_my, R.id.main_iv_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_iv_btn:
                Intent intent = new Intent(MainActivity.this, FindActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_news:
                mainTvTitle.setText("综合");
                break;
            case R.id.main_btn_tweet:
                mainTvTitle.setText("动弹");
                break;
            case R.id.main_btn_add:
                break;
            case R.id.main_btn_discover:
                mainTvTitle.setText("发现");
                break;
            case R.id.main_btn_my:
                Intent my = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(my);
                break;
        }
    }
}
