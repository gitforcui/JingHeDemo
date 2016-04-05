package com.cui.hebut.jinghedemo.activity;

import android.widget.ListView;

import com.cui.hebut.jinghedemo.R;
import com.cui.hebut.jinghedemo.adapter.TimerListAdapter;

import butterknife.Bind;

public class TimerListActivity extends BaseActivity {

    @Bind(R.id.lv_timers)
    ListView lvTimers;
    private TimerListAdapter timerListAdapter;

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_timer_list;
    }

    @Override
    protected void initUtils() {

    }

    @Override
    protected void initView() {
        timerListAdapter = new TimerListAdapter(this);
        lvTimers.setAdapter(timerListAdapter);

    }

    @Override
    protected void initListener() {

    }

}
