package com.hrx.daycount.base;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hrx.daycount.R;

import java.util.ArrayList;
import java.util.List;

import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;
import me.weyye.hipermission.PermissionItem;

/**
 * Created by KAKA on 2018/1/13.
 * AppCompatActivity基础类
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * 申请权限
     *
     * @param context  上下文
     * @param callback 申请结果回调
     */
    protected void applyPermission(Context context, PermissionCallback callback) {
        List<PermissionItem> items = new ArrayList<>();
        items.add(new PermissionItem(Manifest.permission.ACCESS_FINE_LOCATION, "Location", R.drawable.permission_ic_location));
        items.add(new PermissionItem(Manifest.permission.READ_PHONE_STATE, "Phone", R.drawable.permission_ic_location));
        items.add(new PermissionItem(Manifest.permission.WRITE_EXTERNAL_STORAGE, "Storage", R.drawable.permission_ic_storage));
        HiPermission.create(context).permissions(items).checkMutiPermission(callback);
    }

    /**
     * 初始化Toolbar
     *
     * @param act     使用的Activity
     * @param titleId 标题名称，-1 为无标题
     * @param homeId  home键图标，-1 为无图标
     */
    protected void initToolbar(Activity act, int titleId, int homeId) {
        Toolbar mToolBar = (Toolbar) act.findViewById(R.id.toolbar);
        mToolBar.setTitle(titleId);
        if (-1 != homeId) {
            mToolBar.setNavigationIcon(homeId);
        }
        setSupportActionBar(mToolBar);
    }

    /**
     * 初始化Toolbar
     *
     * @param act     使用的Activity
     * @param title 标题名称
     * @param homeId  home键图标，-1 为无图标
     */
    protected void initToolbar(Activity act, String title, int homeId) {
        Toolbar mToolBar = (Toolbar) act.findViewById(R.id.toolbar);
        mToolBar.setTitle(title);
        if (-1 != homeId) {
            mToolBar.setNavigationIcon(homeId);
        }
        setSupportActionBar(mToolBar);
    }

    /**
     * 监听返回键
     *
     * @param item 菜单
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                homeClick();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Home键时间反馈
     */
    protected void homeClick() {

    }
}
