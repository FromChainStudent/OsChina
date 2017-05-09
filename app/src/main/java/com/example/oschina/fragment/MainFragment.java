package com.example.oschina.fragment;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.androidkun.PullToRefreshRecyclerView;
import com.example.oschina.R;
import com.example.oschina.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YC on 2017/5/9.
 */

public class MainFragment extends BaseFragment {
    private ViewPager vp;
    private PullToRefreshRecyclerView ptr;
    private ArrayList<ImageView> ivList;

    @Override
    protected int layoutID() {
        return R.layout.tb_fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {

    }
}
