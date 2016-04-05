package com.cui.hebut.jinghedemo.other;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;

import com.cui.hebut.jinghedemo.R;
import com.cui.hebut.jinghedemo.activity.BaseActivity;

import java.util.ArrayList;

public class Main2Activity extends BaseActivity {

    private ShopAdapter adapter;
    private ListView listView;
//    private List<Shop> shopList = null;

    private String currentDateTime;

    private boolean isExit = false; //判断是否断开线程

    private Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {

            if (msg.what == 1) {
                int shopEndCount = 0;
                ArrayList<Integer> checkedItems;
                checkedItems = (ArrayList<Integer>) msg.obj;
                for (int i = 0; i < checkedItems.size(); i++) {
                    String remainDateTime = DateTimeUtil.getRemainTime(
                            currentDateTime, shopList.get(checkedItems.get(i)).getEndTime());
                    if (remainDateTime.equals("0")) {
                        shopEndCount++; //累加结束的专场数
                        remainDateTime = "活动已结束";
                    }
                    shopList.get(checkedItems.get(i)).setServiceDate(currentDateTime);
                    shopList.get(checkedItems.get(i)).setRaminTime(remainDateTime);
                }
//                for (int i = 0; i < shopList.size(); i++) {
//
//                    String remainDateTime = DateTimeUtil.getRemainTime(
//                            currentDateTime, shopList.get(i).getEndTime());
//                    if (remainDateTime.equals("0")) {
//                        shopEndCount++; //累加结束的专场数
//                        remainDateTime = "活动已结束";
//                    }
//                    shopList.get(i).setRaminTime(remainDateTime);
//                }
                if (shopEndCount == shopList.size()) {
                    /*所有活动都结束，则终止线程*/
                    isExit = true;
                }
                currentDateTime = DateTimeUtil.getDateAddOneSecond(currentDateTime); // 累加服务时间
                adapter.notifyDataSetChanged();
            }

        }

        ;
    };

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initUtils() {

    }

    @Override
    protected void initView() {
        listView = (ListView) this.findViewById(R.id.listView);
//        initData();
        adapter = new ShopAdapter(this);
        adapter.setShopData(shopList);
        listView.setAdapter(adapter);
        currentDateTime = shopList.get(0).getServiceDate(); // 获取当前服务器时间
        isExit = false;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(3);
        arrayList.add(6);
        new ShopThread(arrayList).start();
    }

    @Override
    protected void initListener() {

    }

    public void refreshData(View source) {
//        initData();
    }

    private class ShopThread extends Thread {

        ArrayList<Integer> checkedItems;

        public ShopThread(ArrayList<Integer> checkedItems) {
            this.checkedItems = checkedItems;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (!isExit) {
                Message msg = Message.obtain();
                msg.what = 1;
                msg.obj = checkedItems;
                mHandler.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
//            System.out.println("结束");
        }
    }

    private void initData() {
        shopList.clear();
        Shop shop = new Shop();
        shop.setName("读论语");
        shop.setEndTime("2015-07-25 10:25:55");
        shop.setServiceDate("2015-07-25 10:25:50");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        currentDateTime = shop.getServiceDate();
        shopList.add(shop);

        shop = new Shop();
        shop.setName("读论语");
        shop.setEndTime("2015-08-15 16:25:39");
        shop.setServiceDate("2015-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("读论语");
        shop.setEndTime("2015-08-15 16:23:39");
        shop.setServiceDate("2015-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("健身");
        shop.setEndTime("2015-08-15 16:26:46");
        shop.setServiceDate("2015-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("健身");
        shop.setEndTime("2015-08-15 16:21:52");
        shop.setServiceDate("2015-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("健身");
        shop.setEndTime("2015-08-15 16:27:42");
        shop.setServiceDate("2015-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("健身");
        shop.setEndTime("2015-08-18 16:54:38");
        shop.setServiceDate("2015-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("背书");
        shop.setEndTime("2015-08-18 16:57:17");
        shop.setServiceDate("2015-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("背书");
        shop.setEndTime("2015-08-18 17:16:24");
        shop.setServiceDate("2015-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        shop = new Shop();
        shop.setName("背书");
        shop.setEndTime("2016-08-18 16:57:17");
        shop.setServiceDate("2015-07-25 10:25:48");
        // shop.setEndTime(DateUtil.formatDateType(shop.getEndTime()));
        shopList.add(shop);

        isExit = false;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(3);
        arrayList.add(6);
        new ShopThread(arrayList).start();
    }
}