package com.example.jiaqi.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jiaqi.R;
import com.example.jiaqi.adapter.LeftAdapter;
import com.example.jiaqi.adapter.RightAdapter;
import com.example.jiaqi.bean.RightBean;
import com.example.jiaqi.bean.LeftBean;
import com.example.jiaqi.presenter.LeftPresenter;
import com.example.jiaqi.presenter.RightPresenter;
import com.example.jiaqi.view.ILeftView;
import com.example.jiaqi.view.IRightView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FenFragment extends Fragment implements ILeftView, IRightView {
    @BindView(R.id.fenlei_rv)
    RecyclerView fenleiRv;
    Unbinder unbinder;
    @BindView(R.id.fenlei_right_rv)
    RecyclerView fenleiRightRv;
    private LeftPresenter leftPresenter;
    private RightPresenter rightPresenter;
    private RightAdapter rightAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fen_layout, container, false);
        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        fenleiRv.setLayoutManager(linearLayoutManager);
 
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(OrientationHelper.VERTICAL);
        fenleiRightRv.setLayoutManager(linearLayoutManager1);

        leftPresenter = new LeftPresenter(FenFragment.this);
        leftPresenter.getLeftPresenterData("1");
        rightPresenter = new RightPresenter(FenFragment.this);
        rightPresenter.getRightPresenterData("1");
        return view;
    }

    @Override
    public void getLeftViewData(Object obj) {
        if (obj instanceof LeftBean) {
            LeftBean leftBean = (LeftBean) obj;
            LeftAdapter leftAdapter = new LeftAdapter(getActivity(), leftBean);
            leftAdapter.setItemCilckLisenter(new LeftAdapter.setItemCilckLisenter(){
                @Override
                public void setRightCallBack(int i, List<LeftBean.DataBean> dataBeanList){
                    rightPresenter.getRightPresenterData(dataBeanList.get(i).getCid()+"");
                    rightAdapter.notifyDataSetChanged();
                }
            });
            fenleiRv.setAdapter(leftAdapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getRigthViewData(Object obj) {
        if (obj instanceof RightBean) {
            RightBean rightBean = (RightBean) obj;
            rightAdapter = new RightAdapter(getActivity(),rightBean);
            fenleiRightRv.setAdapter(rightAdapter);
        }
    }
}
