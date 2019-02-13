package com.example.jiaqi.model;

import android.util.Log;

import com.example.jiaqi.bean.LoginBean;
import com.example.jiaqi.newwork.Okhttp;

import java.util.Map;

public class LoginModel implements ILoginModel{
    @Override
    public void getLoginModelData(String url, Map map, final getLoginCallBack getLoginCallBack) {
        Okhttp.getInstance().okhttpPost(url, LoginBean.class, map, new Okhttp.getOkhttpCallBack() {
            @Override
            public void getOkhttpSuccess(Object ob) {
                Log.i("sss", "getOkhttpSuccess: "+ob);
                getLoginCallBack.getLoginSuccess(ob);
            }

            @Override
            public void getOkhttpFiled() {

            }
        });
    }
}
