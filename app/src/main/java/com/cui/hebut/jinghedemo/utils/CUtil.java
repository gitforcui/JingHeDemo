package com.cui.hebut.jinghedemo.utils;/**
 * Created by JH_Android on 2016/3/28.
 */

/**
 * 项目名称：JingHeDemo
 * 类描述：
 * 创建人：JH_Android
 * 创建时间：2016/3/28 15:50
 * 修改人：JH_Android
 * 修改时间：2016/3/28 15:50
 * 修改备注：
 */
public class CUtil {
    public static String showTimeCount(long time) {
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
}
