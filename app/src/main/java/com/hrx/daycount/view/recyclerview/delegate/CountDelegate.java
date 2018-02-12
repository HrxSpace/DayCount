package com.hrx.daycount.view.recyclerview.delegate;

import android.view.ViewGroup;

import com.hrx.daycount.R;
import com.hrx.daycount.view.recyclerview.holder.EventHolder;
import com.kaka.recyclerviewlib.base.BaseDelegate;
import com.kaka.recyclerviewlib.base.BaseViewHolder;
import com.kaka.recyclerviewlib.mode.ItemData;

/**
 * Created by hrx on 2018/1/29.
 * wifi列表的Holder分发器
 */

public class CountDelegate extends BaseDelegate<ItemData> {

    public static final int EVENT_TYPE = 0;//事件

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case EVENT_TYPE:
                return new EventHolder(parent, getItemView(parent, viewType));
        }
        return null;
    }

    /**
     * 获取类型
     * @param itemData 该Item的数据
     * @return 该Item的类型
     */
    @Override
    public int getItemViewType(ItemData itemData) {
        return itemData.holderType;
    }

    /**
     * 获取相应类型的布局
     * @param viewType ViewHolder的类型
     * @return 该Item的布局
     */
    @Override
    public int getLayoutId(int viewType) {
        switch (viewType) {
            case EVENT_TYPE:
                return R.layout.item_event;
        }
        return 0;
    }
}
