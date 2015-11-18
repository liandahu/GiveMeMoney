/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jd.jaffee.gmm.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jaffee
 */
public class DateUtil {

    public static String getCurrentShortDateString() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(new Date());
    }

    public static String getCurrentLongDateString() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:MM:ss");
        return df.format(new Date());
    }

    public static String getDayOfWeek() {
        final String dayNames[] = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0 || dayOfWeek > 6) {
            dayOfWeek = 0;
        }
        return dayNames[dayOfWeek];
    }

}
