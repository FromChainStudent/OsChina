package com.example.oschina.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.androidkun.callback.PullToRefreshListener;
import com.example.oschina.R;
import com.example.oschina.base.BaseFragment;
import com.example.oschina.module.bean.News;
import com.example.oschina.module.net.MyCallBack;
import com.example.oschina.module.net.RetrofitImple;
import com.example.oschina.utils.Dates;
import com.example.oschina.utils.LogUtils;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by YC on 2017/5/9.
 */

public class MainFragment extends BaseFragment {
    private int COUNT = 100000;
    @Bind(R.id.ptr_fragment)
    PullToRefreshRecyclerView ptr_fragment;
    private MyAdapter adapter;
    private List<News.NewsBean> newList = new ArrayList<>();
    private ViewPager vp;
    private List<ImageView> ivList = new ArrayList<>();
    private ImageView iv;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    vp.setCurrentItem(COUNT++);
                    handler.sendEmptyMessageDelayed(1, 2000);
                    break;
            }
        }
    };
    private int pageIndex = 1;

    @Override
    protected int layoutID() {
        return R.layout.tb_fragment;
    }

    @Override
    protected void initView() {
        LogUtils.i("初始化组件", "开始");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        initNet();
        ptr_fragment.setLayoutManager(linearLayoutManager);
        //下拉刷新
        ptr_fragment.setPullRefreshEnabled(true);
        //上拉加载
        ptr_fragment.setLoadingMoreEnabled(true);
        //设置刷新回调
        ptr_fragment.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                ptr_fragment.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pageIndex = 0;
                        newList.clear();
                        initNet();
                        ptr_fragment.setRefreshComplete();

                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                ptr_fragment.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pageIndex++;
                        initNet();
                        ptr_fragment.setLoadMoreComplete();
//                        mEditor.putInt("Index", pageIndex);
//                        Log.i("加载", pageIndex + "");
//                        mEditor.commit();
                    }
                }, 2000);
            }
        });
        LogUtils.i("初始化组件", "完成");
        adapter = new MyAdapter(getContext(), newList);
        ptr_fragment.setAdapter(adapter);
        LogUtils.i("mainadapter", adapter + "");

        View view = LayoutInflater.from(getContext()).inflate(R.layout.news_vp, null);
        vp = (ViewPager) view.findViewById(R.id.vp_fragment);
        ptr_fragment.addHeaderView(view);

        initVp();
    }

    private void initVp() {

        iv = new ImageView(getContext());
        iv.setBackgroundResource(R.drawable.x);
        ivList.add(iv);

        iv = new ImageView(getContext());
        iv.setBackgroundResource(R.drawable.y);
        ivList.add(iv);

        iv = new ImageView(getContext());
        iv.setBackgroundResource(R.drawable.z);
        ivList.add(iv);

        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return Integer.MAX_VALUE;
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                if (container != null) {
                    container.removeView(ivList.get(position % ivList.size()));
                }
                container.addView(ivList.get(position % ivList.size()));


                return ivList.get(position % ivList.size());
            }
        };

        vp.setAdapter(pagerAdapter);
        vp.setCurrentItem(Integer.MAX_VALUE / 2);
        vp.setCurrentItem(COUNT++);

        handler.sendEmptyMessageAtTime(1, 3000);

    }

    /**
     * 网络请求
     */
    private void initNet() {
        String url = "http://www.oschina.net/action/api/news_list";
        Map<String, String> map = new HashMap<>();
        map.put("catalog", String.valueOf(1));
        map.put("pageIndex", String.valueOf(2));
        map.put("pageSize", String.valueOf(50));
        RetrofitImple.getInstance().GETS(url, map, new MyCallBack() {
            @Override
            public void onSuccess(String strSuccess) {
                LogUtils.i("请求成功", strSuccess);
                XStream stream = new XStream();
                stream.alias("oschina", News.class);
                stream.alias("news", News.NewsBean.class);
                News news = (News) stream.fromXML(strSuccess);
                newList.addAll(news.getNewslist());
            }

            @Override
            public void onError(String strError) {
                LogUtils.i("请求失败", strError);
            }
        });
    }

    class MyAdapter extends BaseAdapter<News.NewsBean> {
        public MyAdapter(Context context, List<News.NewsBean> datas) {
            super(context, R.layout.news_adapter, datas);
        }

        @Override
        public void convert(ViewHolder holder, News.NewsBean news) {
            holder.setText(R.id.adapter_tv_title, news.getTitle());
            holder.setText(R.id.adapter_tv_content, news.getBody());
            holder.setText(R.id.adapter_tv_name, news.getAuthor());
            String date = news.getPubDate();
            String date1 = Dates.getDate(date);
            holder.setText(R.id.adapter_tv_data, date1);
            holder.setText(R.id.adapter_tv_count, news.getCommentCount());
        }
    }

    @Override
    protected void loadData() {
        initNet();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
