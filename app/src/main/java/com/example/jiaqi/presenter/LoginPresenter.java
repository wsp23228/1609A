package com.example.jiaqi.presenter;

import android.util.Log;

import com.example.jiaqi.MainActivity;
import com.example.jiaqi.model.ILoginModel;
import com.example.jiaqi.model.LoginModel;
import com.example.jiaqi.newwork.Api;

import java.util.Map;

public class LoginPresenter implements ILoginPresenter{

    private final LoginModel loginModel;
    MainActivity mainActivity;

    public LoginPresenter(MainActivity mainActivity) {
        loginModel = new LoginModel();
        this.mainActivity = mainActivity;
    }

    @Override
    public void getLoginPresenterData( final Map map) {
        loginModel.getLoginModelData(Api.LOGIN, map, new ILoginModel.getLoginCallBack() {
            @Override
            public void getLoginSuccess(Object ob) {
                Log.i("ddd", "getOkhttpSuccess: "+ob);
                mainActivity.getLoginViewData(ob);
            }

            @Override
            public void getLoginFiled() {

            }
        });
    }
}
