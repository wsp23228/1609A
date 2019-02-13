package com.example.jiaqi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jiaqi.bean.RegBean;
import com.example.jiaqi.presenter.ZhuPresenter;
import com.example.jiaqi.view.IZhuView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhuActivity extends AppCompatActivity implements IZhuView {

    @BindView(R.id.zhu_edit_zhang)
    EditText zhuEditZhang;
    @BindView(R.id.zhu_edit_ma)
    EditText zhuEditMa;
    @BindView(R.id.but_zhuce)
    Button butZhuce;
    private ZhuPresenter zhuPresenter;
    private String ma;
    private String zhang;
    private Map<String, String> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        ButterKnife.bind(this);
        zhuPresenter = new ZhuPresenter(this);
        butZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ma = zhuEditMa.getText().toString();
                zhang = zhuEditZhang.getText().toString();
                map = new HashMap<>();
                map.put("mobile", zhang);
                map.put("password", ma);
                if(TextUtils.isEmpty(zhang)&&TextUtils.isEmpty(ma)){
                    Toast.makeText(ZhuActivity.this,"输入的内容不能为空",Toast.LENGTH_LONG).show();
                }else{
                    zhuPresenter.getZhuPresenterData(map);
                }
            }
        });
    }

    @Override
    public void getZhuViewData(Object obj) {
        if(obj instanceof RegBean){
            RegBean regBean = (RegBean) obj;
            if(regBean.getMsg().equals("注册成功")){
                Toast.makeText(ZhuActivity.this,regBean.getMsg(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ZhuActivity.this,MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(ZhuActivity.this,regBean.getMsg(),Toast.LENGTH_LONG).show();
            }
        }
    }
}
