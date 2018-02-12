package com.hrx.daycount.utils;

import android.util.Log;

/**
 * Created by hrx on 2017/11/10.
 * 日志控制工具
 */

public class LogcatUtil {

    /**
     * 模块打印开关
     */
    public static final boolean debug_misc = true;

    public static void d(boolean debug_module, String tag, String msg) {
        if (debug_module) {
            Log.d(tag, msg);
        }
    }

    public static void i(boolean debug_module, String tag, String msg) {
        if (debug_module) {
            Log.i(tag, msg);
        }
    }

    public static void v(boolean debug_module, String tag, String msg) {
        if (debug_module) {
            Log.v(tag, msg);
        }
    }

    public static void e(boolean debug_module, String tag, String msg, Throwable tr) {
        if (debug_module) {
            if (null != tr) {
                Log.e(tag, msg, tr);
            }else{
                Log.e(tag, msg);
            }
        }
    }

    public static void hex(boolean debug_module, String tag, byte[] msg) {
        if (debug_module) {
            StringBuilder sb = new StringBuilder();
            for (byte b : msg) {
                String hex = String.format("%02x ", b);
                sb.append(hex);
            }
            Log.d(tag, sb.toString());
        }
    }
}
