package com.example.oschina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;

/**
 * Created by YC on 2017/5/9.
 */

public abstract class BaseFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutID(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initView();
        loadData();
        initListener();
    }

    protected abstract int layoutID();
    protected  abstract void initView();
    protected abstract void loadData();
    protected abstract void initListener();

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
            onHidden();
        }else{
            setTitleBar();
            onShow();
        }

    }
    public void onShow(){loadData();}
    public void onHidden(){}
    public void setTitleBar(){
    }

}
