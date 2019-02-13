package com.example.jiaqi.model;

import com.example.jiaqi.bean.LeftBean;
import com.example.jiaqi.newwork.Okhttp;

import java.util.Map;

public class LeftModel implements ILEFTModel{

    @Override
    public void getLeftModelData(String url, final getLeftCallBack getLeftCallBack) {
        Okhttp.getInstance().okhttpGet(url,LeftBean.class, new Okhttp.getOkhttpCallBack() {
            @Override
            public void getOkhttpSuccess(Object ob) {
                getLeftCallBack.getLeftSuccess(ob);
            }

            @Override
            public void getOkhttpFiled() {

            }
        });
    }
}
