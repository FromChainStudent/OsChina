package com.example.oschina.controller.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.oschina.R;
import com.example.oschina.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by YC on 2017/5/10.
 */

public class NewsFragment extends BaseFragment {
    @Bind(R.id.fragment_news_tab)
    TabLayout mTab;
    @Bind(R.id.fragment_news_tab_image)
    ImageButton iv;
    @Bind(R.id.fragment_news_vp)
    ViewPager mVp;
    private List<Fragment> mFraList = new ArrayList<>();
    private List<String> mStrList = new ArrayList<>();

    @Override
    protected int layoutID() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {
        mFraList.add(new MainFragment());
        mStrList.add("开源资讯");
        mTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        mVp.setAdapter(new MyAdapter(getActivity().getSupportFragmentManager(), mFraList, mStrList));
        mTab.setupWithViewPager(mVp);
    }

    @Override
    protected void initListener() {
        final RotateAnimation animation = new RotateAnimation(0f,270f,Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.setDuration(1000);
                iv.setAnimation(animation);
                animation.startNow();
                Toast.makeText(getContext(), "被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onShow() {
        loadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    class MyAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFraList;
        private List<String> mStrList;

        public MyAdapter(FragmentManager fm, List<Fragment> mFraList, List<String> mStrList) {
            super(fm);
            this.mFraList = mFraList;
            this.mStrList = mStrList;
        }

        @Override
        public Fragment getItem(int position) {
            return mFraList.get(position);
        }

        @Override
        public int getCount() {
            return mFraList.isEmpty() ? 0 : mFraList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mStrList.get(position);
        }
    }
}
