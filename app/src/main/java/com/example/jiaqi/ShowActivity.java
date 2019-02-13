package com.example.jiaqi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jiaqi.Fragment.FenFragment;
import com.example.jiaqi.Fragment.JianFragment;
import com.example.jiaqi.Fragment.ShouFragment;
import com.example.jiaqi.Fragment.WoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {

    @BindView(R.id.bottom_bar)
    BottomTabBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        bottomBar.init(getSupportFragmentManager())
                .addTabItem("首页",R.mipmap.ic_launcher,ShouFragment.class)
                .addTabItem("分类",R.mipmap.ic_launcher,FenFragment.class)
                .addTabItem("检索",R.mipmap.ic_launcher,JianFragment.class)
                .addTabItem("我的",R.mipmap.ic_launcher,WoFragment.class)
                .isShowDivider(false);
    }
}
