package com.example.jiaqi.model;

import java.util.Map;

public interface IZhuModel {
    public void getZhuModelData(String url, Map map, getZhuCallBack getZhuCallBack);
    interface getZhuCallBack{
        void getZhuSuccess(Object ob);
        void getZhuFiled();
    }
}
