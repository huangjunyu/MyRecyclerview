package com.mytest.myrc;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class RcHorizAdapter extends BaseQuickAdapter<BottomBean,BaseViewHolder>{

    public RcHorizAdapter(@LayoutRes int layoutResId, @Nullable List<BottomBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BottomBean item) {
        helper.setImageResource(R.id.item_horizal_img,R.mipmap.ic_launcher);
    }
}
