package com.cui.hebut.jinghedemo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.cui.hebut.jinghedemo.R;
import com.cui.hebut.jinghedemo.other.Main2Activity;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Bind(R.id.btn_sliding_menu)
    Button btnSlidingMenu;
    @Bind(R.id.btn_timer)
    Button btnTimer;
    @Bind(R.id.btn_timers)
    Button btnTimers;
    @Bind(R.id.btn_timer_list)
    Button btnTimerList;

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initUtils() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        btnSlidingMenu.setOnClickListener(this);
        btnTimer.setOnClickListener(this);
        btnTimers.setOnClickListener(this);
        btnTimerList.setOnClickListener(this);
    }


    @OnClick({R.id.btn_sliding_menu, R.id.btn_timer, R.id.btn_timers, R.id.btn_timer_list})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_timer:
                startActivity(new Intent(this, TimerActivity.class));
                break;
            case R.id.btn_timers:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.btn_timer_list:
                startActivity(new Intent(this, TimerListActivity.class));
                break;
            case R.id.btn_sliding_menu:
                startActivity(new Intent(this, SlidingMenuActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
