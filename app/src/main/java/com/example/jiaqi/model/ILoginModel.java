package com.example.jiaqi.model;

import java.util.Map;

public interface ILoginModel {
    public void getLoginModelData(String url, Map map,getLoginCallBack getLoginCallBack);
    interface getLoginCallBack{
        void getLoginSuccess(Object ob);
        void getLoginFiled();
    }
}
