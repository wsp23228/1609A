package com.example.jiaqi.model;

import android.util.Log;

import com.example.jiaqi.bean.LoginBean;
import com.example.jiaqi.bean.RegBean;
import com.example.jiaqi.newwork.Okhttp;

import java.util.Map;

public class ZhuModel implements IZhuModel{

    @Override
    public void getZhuModelData(String url, Map map, final getZhuCallBack getZhuCallBack) {
        Okhttp.getInstance().okhttpPost(url, RegBean.class, map, new Okhttp.getOkhttpCallBack() {
            @Override
            public void getOkhttpSuccess(Object ob) {
                getZhuCallBack.getZhuSuccess(ob);
            }

            @Override
            public void getOkhttpFiled() {

            }
        });
    }
}
