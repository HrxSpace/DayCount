package com.hrx.daycount.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hrx on 2018/2/11.
 * 事件封装类
 */

public class EventBean implements Parcelable {

    private String eventName;                                       /* 事件标题 */
    private String detail;                                          /* 详细描述 */
    private String targetDateStr;                                   /* 目标日期_格式 */
    private long targetDateInt;                                     /* 目标日期_毫秒 */
    private TimeDiffBean dayDiff;                                    /* 时间差封装类 */

    public EventBean(String eventName, String detail, String targetDateStr, long targetDateInt, TimeDiffBean dayDiff) {
        this.eventName = eventName;
        this.detail = detail;
        this.targetDateStr = targetDateStr;
        this.targetDateInt = targetDateInt;
        this.dayDiff = dayDiff;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTargetDateStr() {
        return targetDateStr;
    }

    public void setTargetDateStr(String targetDateStr) {
        this.targetDateStr = targetDateStr;
    }

    public long getTargetDateInt() {
        return targetDateInt;
    }

    public void setTargetDateInt(long targetDateInt) {
        this.targetDateInt = targetDateInt;
    }

    public TimeDiffBean getDayDiff() {
        return dayDiff;
    }

    public void setDayDiff(TimeDiffBean dayDiff) {
        this.dayDiff = dayDiff;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.eventName);
        dest.writeString(this.detail);
        dest.writeString(this.targetDateStr);
        dest.writeLong(this.targetDateInt);
        dest.writeParcelable(this.dayDiff, flags);
    }

    protected EventBean(Parcel in) {
        this.eventName = in.readString();
        this.detail = in.readString();
        this.targetDateStr = in.readString();
        this.targetDateInt = in.readLong();
        this.dayDiff = in.readParcelable(TimeDiffBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<EventBean> CREATOR = new Parcelable.Creator<EventBean>() {
        @Override
        public EventBean createFromParcel(Parcel source) {
            return new EventBean(source);
        }

        @Override
        public EventBean[] newArray(int size) {
            return new EventBean[size];
        }
    };
}
