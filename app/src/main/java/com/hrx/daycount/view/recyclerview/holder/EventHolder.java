package com.hrx.daycount.view.recyclerview.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hrx.daycount.R;
import com.hrx.daycount.bean.TimeDiffBean;
import com.hrx.daycount.bean.EventBean;
import com.kaka.recyclerviewlib.base.BaseViewHolder;
import com.kaka.recyclerviewlib.mode.ItemData;

/**
 * Created by hrx on 2017/4/22.
 * 事件的ViewHolder
 */

public class EventHolder extends BaseViewHolder<ItemData> {

    private TextView mName;
    private TextView mDetail;
    private TextView mCount;

    public EventHolder(ViewGroup parent, View itemView) {
        super(parent, itemView);
    }

    @Override
    public void findViews() {
        mName = (TextView) itemView.findViewById(R.id.tv_name);
        mDetail = (TextView) itemView.findViewById(R.id.tv_detail);
        mCount = (TextView) itemView.findViewById(R.id.tv_count);
    }

    @Override
    public void onBindViewHolder(ItemData data) {
        if (data.data instanceof EventBean) {
            EventBean eb = (EventBean) data.data;
            String name = eb.getEventName();
            String detail = eb.getDetail();
            TimeDiffBean dayDiff = eb.getDayDiff();

            this.mName.setText(name);
            this.mDetail.setText(detail);
            this.mCount.setText(dayDiff.getDetail());
        }
    }

    @Override
    public boolean clickAble() {
        return true;
    }
}
