package com.hrx.daycount.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hrx.daycount.R;
import com.hrx.daycount.base.BaseActivity;
import com.hrx.daycount.bean.TimeDiffBean;
import com.hrx.daycount.utils.TimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventListActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applyPermission(this, null);
        thisInit();
    }

    private void thisInit() {
        dataInit();
        viewInit();
    }

    private void viewInit() {
        initToolbar(this, R.string.app_name, R.mipmap.icon_menu);
        findViewById(R.id.btn).setOnClickListener(this);
    }

    private void dataInit() {

    }

    @Override
    public void onClick(View view) {
        String dateStart = "2011-08-13 16:29:58";
        String dateStop = "2013-08-14 16:31:48";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            d2 = format.parse(dateStop);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TimeDiffBean dayDiff = TimeUtil.getTimeDiff(TimeDiffBean.SHOW_DAYS, d1.getTime(), d2.getTime());
        Log.d("TimeDiffBean", "getYear: "+dayDiff.getYear());
        Log.d("TimeDiffBean", "getMonth: "+dayDiff.getMonth());
        Log.d("TimeDiffBean", "getDay: "+dayDiff.getDay());
        Log.d("TimeDiffBean", "getHour: "+dayDiff.getHour());
        Log.d("TimeDiffBean", "getMin: "+dayDiff.getMin());
        Log.d("TimeDiffBean", "getSec: "+dayDiff.getSec());
    }
}
