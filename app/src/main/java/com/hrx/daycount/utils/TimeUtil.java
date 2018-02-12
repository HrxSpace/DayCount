package com.hrx.daycount.utils;

import com.hrx.daycount.bean.TimeDiffBean;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;

/**
 * Created by hrx on 2018/2/11.
 * 时间计算类
 */

public class TimeUtil {

    /**
     * 获得两个时间之前的时间差
     * @param showMode 显示模式
     * @param time1 时间点1
     * @param time2 时间点2
     * @return 时间差封装类
     */
    public static TimeDiffBean getTimeDiff(int showMode, long time1, long time2) {
        if (time1 == 0 || time2 == 0) {
            return null;
        }
        int dir = time1 < time2 ? 1 : -1;
        DateTime dt1 = new DateTime(time1);
        DateTime dt2 = new DateTime(time2);
        Period p = new Period(dt1, dt2);
        Days days = Days.daysBetween(dt1, dt2);
        return new TimeDiffBean(dir, showMode, days.getDays(), p.getYears(), p.getMonths(), p.getDays(), p.getHours(), p.getMinutes(), p.getSeconds());
    }

}
