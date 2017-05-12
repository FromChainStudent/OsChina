package com.example.oschina.controller.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oschina.R;
import com.example.oschina.base.BaseFragment;
import com.example.oschina.controller.activity.FindActivity;
import com.example.oschina.module.bean.Lv_Content;
import com.example.oschina.module.db.OrmHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by YC on 2017/5/11.
 */

public class FindLvFragment extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.find_lv)
    ListView lv;

    @Bind(R.id.find_tv_clear)
    TextView tv;

    private OrmHelper helper;
    private List<Lv_Content> mList = new ArrayList<>();
    private LvAdapter adapter;
    private Dao<Lv_Content, Integer> contents;

    @Override
    protected int layoutID() {
        return R.layout.find_lv;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {
        helper = new OrmHelper(getContext(), "name.db", 1);
        helper.getInstance(getContext());
        try {
            contents = helper.getNewsDao();
            mList = contents.queryForAll();
            if (mList.isEmpty()){
                Toast.makeText(getContext(), "还没有搜索过哦", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        adapter = new LvAdapter();
        lv.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    class LvAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.isEmpty() ? 0 : mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyHolder holder;
            if (convertView == null) {
                holder = new MyHolder();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.find_lv_adapter, null);
                holder.tv = (TextView) convertView.findViewById(R.id.find_adapter_tv);
                convertView.setTag(holder);
            } else {
                holder = (MyHolder) convertView.getTag();
            }
            Lv_Content content = mList.get(position);
            holder.tv.setText(content.getContent());
            return convertView;
        }

        class MyHolder {
            TextView tv;
        }
    }
}
