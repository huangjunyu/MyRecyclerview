package com.example.interfaceexample;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/2/23.
 */

public class LoginHelper {
    public static void login(Context context,LoginSussecce loginSussecce){
        if (loginSussecce != null){
            Toast.makeText(context,"调用接口方法，传入参数",Toast.LENGTH_SHORT).show();
            loginSussecce.onSuccess("http//hello");
        }
    }
}
