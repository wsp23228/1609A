package com.example.jiaqi.presenter;

import android.util.Log;

import com.example.jiaqi.MainActivity;
import com.example.jiaqi.ZhuActivity;
import com.example.jiaqi.model.ILoginModel;
import com.example.jiaqi.model.IZhuModel;
import com.example.jiaqi.model.LoginModel;
import com.example.jiaqi.model.ZhuModel;
import com.example.jiaqi.newwork.Api;

import java.util.Map;

public class ZhuPresenter implements IZhuPresenter{


    ZhuActivity zhuActivity;
    private final ZhuModel zhuModel;

    public ZhuPresenter(ZhuActivity zhuActivity) {
        zhuModel = new ZhuModel();
        this.zhuActivity = zhuActivity;
    }

    @Override
    public void getZhuPresenterData(Map map) {
        zhuModel.getZhuModelData(Api.ZHUCE, map, new IZhuModel.getZhuCallBack() {
            @Override
            public void getZhuSuccess(Object ob) {
                zhuActivity.getZhuViewData(ob);
            }

            @Override
            public void getZhuFiled() {

            }
        });
    }
}
