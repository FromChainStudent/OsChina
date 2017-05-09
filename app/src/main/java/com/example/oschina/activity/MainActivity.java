package com.example.oschina.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.oschina.R;
import com.example.oschina.base.BaseActivity;
import com.example.oschina.fragment.MainFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.main_tv_title)
    TextView mainTvTitle;
    @Bind(R.id.main_layout_title)
    RelativeLayout mainLayoutTitle;
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
        transaction.add(R.id.main_layout_frame, new MainFragment());
        transaction.commit();
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.main_btn_news, R.id.main_btn_tweet, R.id.main_btn_add, R.id.main_btn_discover, R.id.main_btn_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
                break;
        }
    }
}
