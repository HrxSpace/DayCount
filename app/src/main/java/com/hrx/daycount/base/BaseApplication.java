package com.hrx.daycount.base;

import com.hrx.daycount.utils.CrashHandler;

/**
 * Created by KAKA on 2018/1/13.
 * Application的基础类
 */

public class BaseApplication extends DataApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(this);                                    /* 捕获强退log */
    }
}
