package com.nodeprogress.snapupview.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * User: Daidingkang(ddk19941017@Gmail.com)
 * Date: 2016-07-02
 * Time: 10:42
 * FIXME
 * 横向滑动加载更多的RecycleView
 */
public class HorizontalRecycleViewLoadMore extends RecyclerView {
    GridLayoutManager manager;
    boolean lastPosition;
    Context context;

    public HorizontalRecycleViewLoadMore(Context context) {
        super(context);
        init(context);
    }


    public HorizontalRecycleViewLoadMore(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    float xMove = 0;
    float x = 0;

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (lastPosition) {
                    x = e.getX();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                xMove = e.getX();
                break;
            case MotionEvent.ACTION_UP:
                if (lastPosition) {
                    float xDistance = x - xMove;
                    if ((xDistance) > 200) {//可以判断滑动距离，而且通过正负判断为左滑还是右滑
                        Toast.makeText(context, "触发横向加载更多", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }

        return super.onTouchEvent(e);
    }

    private void init(final Context context) {
        this.context = context;
        manager = new GridLayoutManager(context, 1, LinearLayoutManager.HORIZONTAL, false);
        setLayoutManager(manager);

        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {//当前的recycleView不滑动(滑动已经停止时)
                    int lastVisiblePosition = manager.findLastVisibleItemPosition();//最后一个可见的位置
                    if (lastVisiblePosition >= manager.getItemCount() - 1) {//如果是最后一个位置就是滑到底部了
                        lastPosition = true;
                    } else {
                        if (lastPosition) {
                            lastPosition = false;
                        }
                    }
                }
            }
        });
    }
}
