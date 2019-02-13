package com.example.jiaqi.model;

import java.util.Map;

public interface IShowModel {
    public void getShowModelData(String url, getShowCallBack getShowCallBack);
    interface getShowCallBack{
        void getShowSuccess(Object ob);
        void getShowFiled();
    }
}
