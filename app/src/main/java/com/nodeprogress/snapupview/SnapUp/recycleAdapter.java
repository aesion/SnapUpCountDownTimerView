package com.nodeprogress.snapupview.SnapUp;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class recycleAdapter extends RecyclerView.Adapter {

    Context context;

    public recycleAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0){
            return new imageViewHolder(new ImageView(context));
        }else {
            return new MyViewHolder(new TextView(context));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            imageViewHolder viewHolder = (imageViewHolder) holder;
            viewHolder.imageView.setPadding(50,20,20,20);
            viewHolder.imageView.setBackgroundColor(Color.BLUE);
        } else {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.textView.setText(" 淘宝 " + position);
        }
    }

    @Override
    public int getItemCount() {
        return 21;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 20) ? 0 : 1;
    }

}