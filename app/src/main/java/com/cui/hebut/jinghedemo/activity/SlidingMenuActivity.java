package com.cui.hebut.jinghedemo.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.cui.hebut.jinghedemo.R;
import com.cui.hebut.jinghedemo.view.SlidingMenu;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SlidingMenuActivity extends BaseActivity {

    @Bind(R.id.one)
    ImageView one;
    @Bind(R.id.two)
    ImageView two;
    @Bind(R.id.three)
    ImageView three;
    @Bind(R.id.four)
    ImageView four;
    @Bind(R.id.five)
    ImageView five;
    @Bind(R.id.slid_menu)
    SlidingMenu slidMenu;

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_sliding_menu;
    }

    @Override
    protected void initUtils() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
