package com.example.jiaqi.model;

import java.util.Map;

public interface ILEFTModel {
    public void getLeftModelData(String url, getLeftCallBack getLeftCallBack);
    interface getLeftCallBack{
        void getLeftSuccess(Object ob);
        void getLeftFiled();
    }
}
