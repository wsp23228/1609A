package com.example.jiaqi.model;

public interface IRightModel {
    public void getRightModelData(String url, getRightCallBack getRightCallBack);
    interface getRightCallBack{
        void getRightSuccess(Object ob);
        void getRightFiled();
    }
}
