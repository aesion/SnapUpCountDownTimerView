package com.nodeprogress.snapupview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aesion.snapupdowntimerview.SnapUpCountDownTimerView;
import com.nodeprogress.snapupview.SnapUp.recycleAdapter;
import com.nodeprogress.snapupview.View.HorizontalRecycleViewLoadMore;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalRecycleViewLoadMore recyclerView = (HorizontalRecycleViewLoadMore) findViewById(R.id.recycle);
        recyclerView.setAdapter(new recycleAdapter(MainActivity.this));

        SnapUpCountDownTimerView rushBuyCountDownTimerView = (SnapUpCountDownTimerView) findViewById(R.id.RushBuyCountDownTimerView);
        rushBuyCountDownTimerView.setTime(1,55,3);
        rushBuyCountDownTimerView.start();
    }
}
