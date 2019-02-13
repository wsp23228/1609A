package com.example.jiaqi.presenter;

import com.example.jiaqi.Fragment.FenFragment;
import com.example.jiaqi.model.ILEFTModel;
import com.example.jiaqi.model.IRightModel;
import com.example.jiaqi.model.LeftModel;
import com.example.jiaqi.model.RightModel;
import com.example.jiaqi.newwork.Api;

public class RightPresenter implements IRightPresenter{


    FenFragment fenFragment;
    private final RightModel rightModel;

    public RightPresenter(FenFragment fenFragment) {
        rightModel = new RightModel();
        this.fenFragment = fenFragment;
    }

    @Override
    public void getRightPresenterData(String str1) {
        rightModel.getRightModelData(Api.RIGHT + str1 + "", new IRightModel.getRightCallBack() {
            @Override
            public void getRightSuccess(Object ob) {
                fenFragment.getRigthViewData(ob);
            }

            @Override
            public void getRightFiled() {

            }
        });
    }
}
