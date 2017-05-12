package com.example.oschina.controller.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oschina.R;
import com.example.oschina.base.BaseActivity;
import com.example.oschina.module.bean.Lv_Content;
import com.example.oschina.module.db.OrmHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindActivity extends BaseActivity implements View.OnClickListener {

    private EditText et;
    private ImageView iv;
    private TextView tv;
    private FrameLayout frameLayout;
    private OrmHelper helper;

    @Override
    protected int layoutID() {
        return R.layout.activity_find;
    }

    @Override
    protected void initView() {
        helper = new OrmHelper(this, "name.db", 1);
        helper.getInstance(this);

        et = (EditText) findViewById(R.id.find_et);
        iv = (ImageView) findViewById(R.id.find_iv_clear);
        tv = (TextView) findViewById(R.id.find_tv);
        frameLayout = (FrameLayout) findViewById(R.id.find_layout_frame);

    }

    @Override
    protected void loadData() {
        String find = et.getText().toString().trim();
        if (find != null) {
            iv.setVisibility(View.VISIBLE);
            Lv_Content content = new Lv_Content();
            content.setContent(find);

        } else {
            iv.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initListener() {
        iv.setOnClickListener(this);
        tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_iv_clear:
                et.setText(null);
                break;
            case R.id.find_tv:
                finish();
                break;
        }
    }


}
