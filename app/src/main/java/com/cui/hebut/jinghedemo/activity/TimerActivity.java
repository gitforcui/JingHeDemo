package com.cui.hebut.jinghedemo.activity;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cui.hebut.jinghedemo.R;

import butterknife.Bind;
import butterknife.OnClick;

public class TimerActivity extends BaseActivity {


    @Bind(R.id.btn_start)
    Button btnStart;
    @Bind(R.id.tv_time_show)
    TextView tvTimeShow;

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_timer;
    }

    @Override
    protected void initUtils() {

    }

    @Override
    protected void initView() {
        if (timeLeft != -1) {
            startTime = timeLeft;
            startTime();
        } else {
            startTime = 30 * 1000;
            timeLeft = startTime;
        }
    }

    @Override
    protected void initListener() {
        btnStart.setOnClickListener(this);

    }

    //时间计数器，最多只能到99小时，如需要更大小时数需要改改方法
    public String showTimeCount(long time) {
        if (time >= 360000000) {
            return "00:00:00";
        }
        String timeCount = "";
        long hourc = time / 3600000;
        String hour = "0" + hourc;
        hour = hour.substring(hour.length() - 2, hour.length());

        long minuec = (time - hourc * 3600000) / (60000);
        String minue = "0" + minuec;
        minue = minue.substring(minue.length() - 2, minue.length());

        long secc = (time - hourc * 3600000 - minuec * 60000) / 1000;
        String sec = "0" + secc;
        sec = sec.substring(sec.length() - 2, sec.length());
        timeCount = hour + ":" + minue + ":" + sec;
        return timeCount;
    }

    private Handler stepTimeHandler;
    private Runnable mTicker;
    long startTime = 0;

    @OnClick({R.id.btn_start, R.id.tv_time_show})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                Button b = (Button) view;
                String buttonText = b.getText().toString();
                if ("Start".equalsIgnoreCase(buttonText)) {
                    startTime();
                } else {
                    b.setText("Start");
                    //停止计时 Remove any pending posts of Runnable r that are in the message queue.
                    stepTimeHandler.removeCallbacks(mTicker);
                }
                break;
//            case R.id.tv_time_show:
//                break;
        }
    }

    private void startTime() {
        btnStart.setText("Stop");
        // 清零 开始计时
        tvTimeShow.setText("00:00:00");
        stepTimeHandler = new Handler();
//                    startTime = System.currentTimeMillis();
        mTicker = new Runnable() {
            public void run() {
//                            String content = showTimeCount(System.currentTimeMillis() - startTime);
                startTime -= 1000;
                timeLeft = startTime;
                String content = showTimeCount(startTime);
                tvTimeShow.setText(content);
                if (startTime < 0) {
                    Toast.makeText(TimerActivity.this, "finish", Toast.LENGTH_SHORT).show();
                    timeLeft = -1;
                } else {
                    long now = SystemClock.uptimeMillis();
                    long next = now + (1000 - now % 1000);
                    stepTimeHandler.postAtTime(mTicker, next);
                }
            }
        };
        //启动计时线程，定时更新
        mTicker.run();
    }
}
