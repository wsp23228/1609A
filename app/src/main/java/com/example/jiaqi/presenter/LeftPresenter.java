package com.example.jiaqi.presenter;

import android.util.Log;

import com.example.jiaqi.Fragment.FenFragment;
import com.example.jiaqi.MainActivity;
import com.example.jiaqi.model.ILEFTModel;
import com.example.jiaqi.model.ILoginModel;
import com.example.jiaqi.model.LeftModel;
import com.example.jiaqi.model.LoginModel;
import com.example.jiaqi.newwork.Api;

import java.util.Map;

public class LeftPresenter implements ILeftPresenter{


    FenFragment fenFragment;
    private final LeftModel leftModel;

    public LeftPresenter(FenFragment fenFragment) {
        leftModel = new LeftModel();
        this.fenFragment = fenFragment;
    }


    @Override
    public void getLeftPresenterData(String str) {
        leftModel.getLeftModelData(Api.LEFT + str + "", new ILEFTModel.getLeftCallBack() {
            @Override
            public void getLeftSuccess(Object ob) {
                fenFragment.getLeftViewData(ob);
            }

            @Override
            public void getLeftFiled() {

            }
        });
    }
}
