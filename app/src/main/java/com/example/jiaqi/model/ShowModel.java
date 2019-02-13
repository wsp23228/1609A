package com.example.jiaqi.model;

import android.util.Log;

import com.example.jiaqi.bean.ShowBean;
import com.example.jiaqi.newwork.Okhttp;

import java.util.Map;

public class ShowModel implements IShowModel{
    @Override
    public void getShowModelData(String url, final getShowCallBack getShowCallBack) {
        Okhttp.getInstance().okhttpGet(url, ShowBean.class,new Okhttp.getOkhttpCallBack() {
            @Override
            public void getOkhttpSuccess(Object ob) {
                getShowCallBack.getShowSuccess(ob);
            }

            @Override
            public void getOkhttpFiled() {

            }
        });
    }
}
