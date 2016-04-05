package com.cui.hebut.jinghedemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cui.hebut.jinghedemo.other.Shop;

import java.util.ArrayList;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {


    public static long timeLeft = -1;

    public static ArrayList<Shop> shopList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResourceId());
        ButterKnife.bind(this);
        initShop();
        initUtils();
        initView();
        initListener();
    }

    public void initShop() {
        shopList = new ArrayList<>();
        Shop shop = new Shop();
        shop.setName("读论语");
        shop.setEndTime("2016-07-25 10:35:55");
        shop.setServiceDate("2016-07-25 10:25:50");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
//        currentDateTime = shop.getServiceDate();
        shopList.add(shop);

        shop = new Shop();
        shop.setName("读论语");
        shop.setEndTime("2016-7-25 16:25:39");
        shop.setServiceDate("2016-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("读论语");
        shop.setEndTime("2016-7-25 16:23:39");
        shop.setServiceDate("2016-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("健身");
        shop.setEndTime("2016-7-25 16:26:46");
        shop.setServiceDate("2016-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("健身");
        shop.setEndTime("2016-7-25 16:21:52");
        shop.setServiceDate("2016-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("健身");
        shop.setEndTime("2016-7-25 16:27:42");
        shop.setServiceDate("2016-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("健身");
        shop.setEndTime("2016-7-25 16:54:38");
        shop.setServiceDate("2016-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("背书");
        shop.setEndTime("2016-7-25 16:57:17");
        shop.setServiceDate("2016-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("背书");
        shop.setEndTime("2016-7-25 17:16:24");
        shop.setServiceDate("2016-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("背书");
        shop.setEndTime("2016-7-25 16:57:17");
        shop.setServiceDate("2016-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);
    }

    /**
     * 设置布局文件ID
     *
     * @return
     */
    protected abstract int getContentViewResourceId();

    /**
     * 初始化工具
     */
    protected abstract void initUtils();

    /**
     * 初始化视图
     *
     * @param
     */
    protected abstract void initView();

    /**
     * 初始化监听
     */
    protected abstract void initListener();


    @Override
    public void onClick(View v) {

    }
}
