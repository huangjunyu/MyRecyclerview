package com.mytest.myrc;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    RcCheckBoxAdapter rcCheckBoxAdapter;
    RcHorizAdapter rcHorizAdapter;
    List items = new ArrayList();
    List<BottomBean> bottoms ;
    RecyclerView rc;
    RecyclerView hrc;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            bottoms.clear();
            for (int i = 0;i < rcCheckBoxAdapter.getSelectedItem().size();i++){
            Log.e("rccheck",rcCheckBoxAdapter.getSelectedItem().get(i).toString() + ".");
               BottomBean bottomBean =  new BottomBean();
                bottomBean.setId("kdkkdk");
                bottoms.add(bottomBean);
            };
            rcHorizAdapter.notifyDataSetChanged();
            hrc.setAdapter(rcHorizAdapter);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Utils.setStatusTextColor(true, Main2Activity.this);
        rc = findView(R.id.select_contact_rc);
        hrc = findView(R.id.select_contact_header_rc);
        hrc.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rc.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        getItems();
        rcCheckBoxAdapter = new RcCheckBoxAdapter(items,handler,this);
        bottoms = new ArrayList();
        rcHorizAdapter = new RcHorizAdapter(R.layout.item_horizal,bottoms);
        hrc.setAdapter(rcHorizAdapter);
        rc.setAdapter(rcCheckBoxAdapter);
    }
    private void getItems(){
        for (int i = 0 ; i < 5 ; i++){
            items.add("多选");
        }
    }
    protected <T extends View> T findView(int resId) {
        return (T) (findViewById(resId));
    }
}
