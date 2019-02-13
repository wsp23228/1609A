package com.example.jiaqi.model;

import com.example.jiaqi.bean.RightBean;
import com.example.jiaqi.newwork.Okhttp;

public class RightModel implements IRightModel{

    @Override
    public void getRightModelData(String url, final getRightCallBack getRightCallBack) {
        Okhttp.getInstance().okhttpGet(url, RightBean.class, new Okhttp.getOkhttpCallBack() {
            @Override
            public void getOkhttpSuccess(Object ob) {
                getRightCallBack.getRightSuccess(ob);
            }

            @Override
            public void getOkhttpFiled() {

            }
        });
    }
}
