package com.example.oschina.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oschina.R;

import java.util.ArrayList;

/**
 * Created by YC on 2017/5/9.
 */

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private Context context;
    private ArrayList<String> mList = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rlv_adapter, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String str = mList.get(position);
        holder.tv.setText(str);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.adapter_tv);
        }
    }
}
