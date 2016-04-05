package com.cui.hebut.jinghedemo.adapter;/**
 * Created by JH_Android on 2016/3/28.
 */

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cui.hebut.jinghedemo.R;
import com.cui.hebut.jinghedemo.utils.CUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 项目名称：JingHeDemo
 * 类描述：
 * 创建人：JH_Android
 * 创建时间：2016/3/28 15:22
 * 修改人：JH_Android
 * 修改时间：2016/3/28 15:22
 * 修改备注：
 */
public class TimerListAdapter extends BaseAdapter {

    int[] time = new int[]{10 * 1000, 30 * 1000, 15 * 1000, 26 * 1000, 18 * 1000};
    int[] timeStep = new int[]{1 * 1000, 1 * 1000, 1 * 1000, 1 * 1000, 1 * 1000};

    public Context context;

    public TimerListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return time.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    Handler stepTimeHandler;
    Runnable mTicker;
    long startTime = 0;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_time_list_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvTimeShow.setText(CUtil.showTimeCount(time[position]));
        viewHolder.tvTimeStemp.setText(CUtil.showTimeCount(timeStep[position]));
        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String buttonText = b.getText().toString();
                if ("Start".equalsIgnoreCase(buttonText)) {
                    b.setText("Stop");
                    // 清零 开始计时
                    finalViewHolder.tvTimeShow.setText("00:00:00");
                    stepTimeHandler = new Handler();
//                    startTime = System.currentTimeMillis();
                    startTime = time[position];

                    mTicker = new Runnable() {
                        public void run() {
//                            String content = showTimeCount(System.currentTimeMillis() - startTime);
                            startTime -= timeStep[position];
                            String content = CUtil.showTimeCount(startTime);
                            finalViewHolder.tvTimeShow.setText(content);
                            if (startTime < 0) {
                                Toast.makeText(context, "finish", Toast.LENGTH_SHORT).show();
                            } else {
                                long now = SystemClock.uptimeMillis();
                                long next = now + (timeStep[position] - now % 1000);
                                stepTimeHandler.postAtTime(mTicker, next);
                            }
                        }
                    };
                    //启动计时线程，定时更新
                    mTicker.run();
                } else {
                    b.setText("Start");
                    //停止计时 Remove any pending posts of Runnable r that are in the message queue.
                    stepTimeHandler.removeCallbacks(mTicker);
                }
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_time_show)
        TextView tvTimeShow;
        @Bind(R.id.tv_time_stemp)
        TextView tvTimeStemp;
        @Bind(R.id.btn_start)
        Button btnStart;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
