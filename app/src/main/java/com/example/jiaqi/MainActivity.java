package com.example.jiaqi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiaqi.bean.LoginBean;
import com.example.jiaqi.presenter.LoginPresenter;
import com.example.jiaqi.view.ILoginView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.edit_zhang)
    EditText editZhang;
    @BindView(R.id.edit_ma)
    EditText editMa;
    @BindView(R.id.che_jizhu)
    CheckBox cheJizhu;
    @BindView(R.id.text_zhuce)
    TextView textZhuce;
    @BindView(R.id.but_login)
    Button butLogin;
    private LoginPresenter loginPresenter;
    private SharedPreferences wenjian;
    private String zhang;
    private String ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        wenjian = getSharedPreferences("wenjian", MODE_PRIVATE);
        boolean key = wenjian.getBoolean("key", false);
        cheJizhu.setChecked(key);
        if(key){
            String zhang = wenjian.getString("mobile", "");
            String ma = wenjian.getString("password", "");
            editMa.setText(ma);
            editZhang.setText(zhang);
        }
        loginPresenter = new LoginPresenter(this);
        butLogin.setOnClickListener(new View.OnClickListener() {
            private Map<String, String> map;

            @Override
            public void onClick(View view) {
                Log.i("dsa", "onClick: "+"点击了");
                zhang = editZhang.getText().toString();
                ma = editMa.getText().toString();
                map = new HashMap<>();
                map.put("mobile", zhang);
                map.put("password", ma);
                if(TextUtils.isEmpty(zhang)&&TextUtils.isEmpty(ma)){
                    Toast.makeText(MainActivity.this,"输入内容不能够为空",Toast.LENGTH_LONG).show();
                }else{
                    loginPresenter.getLoginPresenterData(map);
                }
            }
        });
        textZhuce.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,ZhuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getLoginViewData(Object obj) {
        if (obj instanceof LoginBean) {
            LoginBean loginBean = (LoginBean) obj;
            Log.i("qqq", "getOkhttpSuccess: "+loginBean.getMsg());
            if (loginBean.getMsg().equals("登录成功")) {
                SharedPreferences.Editor edit = wenjian.edit();
                if(cheJizhu.isChecked()){
                    edit.putString("mobile",zhang);
                    edit.putString("password",ma);
                    edit.putBoolean("key",true);
                }else {
                    edit.putBoolean("key",false);
                }
                edit.commit();
                Toast.makeText(MainActivity.this,loginBean.getMsg(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(MainActivity.this,loginBean.getMsg(),Toast.LENGTH_LONG).show();
            }
        }
    }
}
