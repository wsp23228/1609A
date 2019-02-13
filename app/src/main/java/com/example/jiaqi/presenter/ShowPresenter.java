package com.example.jiaqi.presenter;

import android.util.Log;

import com.example.jiaqi.Fragment.ShouFragment;
import com.example.jiaqi.MainActivity;
import com.example.jiaqi.model.IShowModel;
import com.example.jiaqi.model.ShowModel;
import com.example.jiaqi.newwork.Api;

import java.util.Map;

public class ShowPresenter implements IShowPresenter{

    private final ShowModel ShowModel;
    ShouFragment shouFragment;

    public ShowPresenter(ShouFragment shouFragment) {
        ShowModel = new ShowModel();
        this.shouFragment = shouFragment;
    }

    @Override
    public void getShowPresenterData(String str) {
        ShowModel.getShowModelData(Api.SHOW + str + "", new IShowModel.getShowCallBack() {
            @Override
            public void getShowSuccess(Object ob) {
                shouFragment.getShowData(ob);
            }

            @Override
            public void getShowFiled() {

            }
        });
    }
}
