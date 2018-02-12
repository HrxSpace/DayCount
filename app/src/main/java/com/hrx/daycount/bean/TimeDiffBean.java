package com.hrx.daycount.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hrx on 2018/2/11.
 * 时间差的封装类
 */

public class TimeDiffBean implements Parcelable {

    public final static int SHOW_DATE = 10001;                      /* 显示日期时间差 */
    public final static int SHOW_DAYS = 10002;                      /* 显示天数时间差 */

    private int direction;                                          /* 方向,1--正数，-1--倒数 */
    private int mode;                                               /* 方向,1--正数，-1--倒数 */
    private int standardDays;                                       /* 标准天数 */
    private int year;                                               /* 年 */
    private int month;                                              /* 月 */
    private int day;                                                /* 日 */
    private int hour;                                               /* 时 */
    private int min;                                                /* 分 */
    private int sec;                                                /* 秒 */

    public TimeDiffBean(int direction, int mode, int standardDays, int year, int month, int day, int hour, int min, int sec) {
        this.direction = direction;
        this.mode = mode;
        this.standardDays = standardDays;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getStandardDays() {
        return standardDays;
    }

    public void setStandardDays(int standardDays) {
        this.standardDays = standardDays;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        if (direction == 1) {
            sb.append("过去了");
        } else {
            sb.append("还剩下");
        }
        if (mode == SHOW_DATE) {
            sb.append(year).append("年").append(month).append("月").append(day).append("日");
        } else if (mode == SHOW_DAYS) {
            sb.append(standardDays).append("天");
        }
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.direction);
        dest.writeInt(this.mode);
        dest.writeInt(this.standardDays);
        dest.writeInt(this.year);
        dest.writeInt(this.month);
        dest.writeInt(this.day);
        dest.writeInt(this.hour);
        dest.writeInt(this.min);
        dest.writeInt(this.sec);
    }

    protected TimeDiffBean(Parcel in) {
        this.direction = in.readInt();
        this.mode = in.readInt();
        this.standardDays = in.readInt();
        this.year = in.readInt();
        this.month = in.readInt();
        this.day = in.readInt();
        this.hour = in.readInt();
        this.min = in.readInt();
        this.sec = in.readInt();
    }

    public static final Parcelable.Creator<TimeDiffBean> CREATOR = new Parcelable.Creator<TimeDiffBean>() {
        @Override
        public TimeDiffBean createFromParcel(Parcel source) {
            return new TimeDiffBean(source);
        }

        @Override
        public TimeDiffBean[] newArray(int size) {
            return new TimeDiffBean[size];
        }
    };
}
