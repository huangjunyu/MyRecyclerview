package com.mytest.myrc;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.*;

public class RcCheckBoxAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Handler handler;
    Activity activity;

    private List<String> selectContactRowsBeanArrayList = new ArrayList<>();

    private SparseBooleanArray mSelectedPositions = new SparseBooleanArray();
    private boolean mIsSelectable = false;


    public RcCheckBoxAdapter(List<String> mSelectContactRowBeanList, Handler handler, Activity activity) {
        if (mSelectContactRowBeanList == null) {
            throw new IllegalArgumentException("model Data must not be null");
        }
        selectContactRowsBeanArrayList = mSelectContactRowBeanList;
        this.handler = handler;
        this.activity = activity;
    }

    //获得选中条目的结果
    public ArrayList<String> getSelectedItem() {
        ArrayList<String> selectList = new ArrayList<>();
        for (int i = 0; i < selectContactRowsBeanArrayList.size(); i++) {
            if (isItemChecked(i)) {
                selectList.add(selectContactRowsBeanArrayList.get(i));
            }
        }
        return selectList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_checkbox_item, viewGroup, false);
        return new ListItemViewHolder(itemView);
    }

    //设置给定位置条目的选择状态
    private void setItemChecked(int position, boolean isChecked) {
        mSelectedPositions.put(position, isChecked);
    }

    //根据位置判断条目是否选中
    private boolean isItemChecked(int position) {
        return mSelectedPositions.get(position);
    }

    //根据位置判断条目是否可选
    private boolean isSelectable() {
        return mIsSelectable;
    }
    //设置给定位置条目的可选与否的状态
    private void setSelectable(boolean selectable) {
        mIsSelectable = selectable;
    }

    //绑定界面，设置监听
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int i) {
        //设置条目状态
        ((ListItemViewHolder) holder).mainTitle.setText("box");
        ((ListItemViewHolder) holder).checkBox.setChecked(isItemChecked(i));
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH);
        Glide.with(activity).load(R.mipmap.ic_launcher).apply(options).into(((ListItemViewHolder) holder).headImageView);
        //checkBox的监听
        ((ListItemViewHolder) holder).checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isItemChecked(i)) {
                    setItemChecked(i, false);
                } else {
                    setItemChecked(i, true);
                }
                Message message = handler.obtainMessage();
                message.what = 0;
                message.sendToTarget();
            }
        });

        //条目view的监听
        ((ListItemViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isItemChecked(i)) {
                    setItemChecked(i, false);
                } else {
                    setItemChecked(i, true);
                }
                notifyItemChanged(i);
                Message message = handler.obtainMessage();
                message.what = 0;
                message.sendToTarget();
            }
        });


    }

    @Override
    public int getItemCount() {
        return selectContactRowsBeanArrayList == null ? 0 : selectContactRowsBeanArrayList.size();
    }

    public class ListItemViewHolder extends RecyclerView.ViewHolder{
        private SparseArray<View> mViews;
        private View mContextView;
        //ViewHolder
        CheckBox checkBox;
        TextView mainTitle;
        TextView onlineTv;
        de.hdodenhof.circleimageview.CircleImageView headImageView;
        ListItemViewHolder(View view) {
            super(view);
            mContextView = view;
            this.mainTitle = (TextView) view.findViewById(R.id.contact_checkbox_item_name);
            this.checkBox = (CheckBox) view.findViewById(R.id.contact_checkbox_item_cb);
            this.onlineTv = (TextView) view.findViewById(R.id.contact_checkbox_item_online);
            this.headImageView = (de.hdodenhof.circleimageview.CircleImageView) view.findViewById(R.id.contact_checkbox_item_hv);
        }
        public <T extends View> T getView(int viewId){
            View view = mViews.get(viewId);
            if (view == null){
                view = mContextView.findViewById(viewId);
                mViews.put(viewId,view);
            }
            return (T)view;
        }
    }
}

