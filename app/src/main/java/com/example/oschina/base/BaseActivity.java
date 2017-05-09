package com.example.oschina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.oschina.App;

import butterknife.ButterKnife;

/**
 * Created by YC on 2017/5/9.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutID());
        ButterKnife.bind(this);
        App.baseActivity = this;
        initView();
        loadData();
        initListener();
    }
    protected abstract int layoutID();
    protected  abstract void initView();
    protected abstract void loadData();
    protected abstract void initListener();

    @Override
    protected void onResume() {
        super.onResume();
        App.baseActivity = this;
    }
}
