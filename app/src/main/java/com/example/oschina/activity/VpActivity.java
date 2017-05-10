//package com.example.oschina.activity;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import com.example.oschina.R;
//import com.example.oschina.base.BaseActivity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
//import in.srain.cube.views.ptr.PtrFrameLayout;
//
///**
// * Created by YC on 2017/5/9.
// */
//
//public class VpActivity extends BaseActivity {
//    @Bind(R.id.vp)
//    ViewPager vp;
//    @Bind(R.id.rlv)
//    RecyclerView rlv;
//    private List<ImageView> viewList = new ArrayList<>();
//
//    private ArrayList<String> mList = new ArrayList<>();
//
//    private ImageView iv;
//
//    private int COUNT = 1000000;
//
//    private PtrFrameLayout ptrFrameLayout;
//
//    private Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){
//                case 1:
//                    vp.setCurrentItem(COUNT++);
//                    handler.sendEmptyMessageDelayed(1, 2000);
//                    break;
//            }
//        }
//    };
//
//    @Override
//    protected int layoutID() {
//        return R.layout.news_vp;
//    }
//
//    private void add(){
//        for (int i = 1; i < 110; i++){
//            mList.add("第" + i + "个");
//        }
//    }
//
//    @Override
//    protected void initView() {
//
//        add();
//
//        iv = new ImageView(this);
//        iv.setImageResource(R.drawable.ic_nav_add_actived);
//        viewList.add(iv);
//
//        iv = new ImageView(this);
//        iv.setImageResource(R.drawable.ic_nav_my_normal);
//
//        viewList.add(iv);
//
//        vp.addView(new View(this));
//        rlv.setLayoutManager(new LinearLayoutManager(this));
//        rlv.setAdapter(new MyAdapter(this, mList));
//
//        PagerAdapter pagerAdapter = new PagerAdapter() {
//
//            @Override
//            public boolean isViewFromObject(View arg0, Object arg1) {
//                // TODO Auto-generated method stub
//                return arg0 == arg1;
//            }
//
//            @Override
//            public int getCount() {
//                // TODO Auto-generated method stub
//                return Integer.MAX_VALUE;
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position,
//                                    Object object) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//                // TODO Auto-generated method stub
//                if (container !=null){
//                    container.removeView(viewList.get(position%viewList.size()));
//                }
//                container.addView(viewList.get(position%viewList.size()));
//
//
//                return viewList.get(position%viewList.size());
//            }
//        };
//
//        vp.setAdapter(pagerAdapter);
//        vp.setCurrentItem(Integer.MAX_VALUE/2);
//        vp.setCurrentItem(COUNT++);
//
//        handler.sendEmptyMessageAtTime(1, 3000);
//    }
//
//    @Override
//    protected void loadData() {
//
//    }
//
//    @Override
//    protected void initListener() {
//
//    }
//}
