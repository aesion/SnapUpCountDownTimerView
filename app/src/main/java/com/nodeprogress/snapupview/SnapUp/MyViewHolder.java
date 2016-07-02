package com.nodeprogress.snapupview.SnapUp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * User: Daidingkang(ddk19941017@Gmail.com)
 * Date: 2016-07-01
 * Time: 15:51
 * FIXME
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView;
    }
}
