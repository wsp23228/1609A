package com.example.jiaqi.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.jiaqi.R;
import com.example.jiaqi.adapter.ShowAdapter;
import com.example.jiaqi.bean.ShowBean;
import com.example.jiaqi.presenter.ShowPresenter;
import com.example.jiaqi.view.IShowView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShouFragment extends Fragment implements IShowView {
    @BindView(R.id.x_Banner)
    XBanner xBanner;
    @BindView(R.id.recyc_lerView)
    RecyclerView recycLerView;
    Unbinder unbinder;
    private List<String> list;
    private ShowPresenter showPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shou_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recycLerView.setLayoutManager(linearLayoutManager);
        showPresenter = new ShowPresenter(ShouFragment.this);
        showPresenter.getShowPresenterData("1");
        return view;
    }

    @Override
    public void getShowData(Object object) {
        if (object instanceof ShowBean) {
            ShowBean showBean = (ShowBean) object;
            ShowAdapter showAdapter = new ShowAdapter(getActivity(),showBean);
            Log.i("sss", "getShowData: "+showBean.getData().getFenlei().get(0).getName());
            recycLerView.setAdapter(showAdapter);
            List<ShowBean.DataBean.BannerBean> banner = showBean.getData().getBanner();
            list = new ArrayList<String>();
            for(int i =0 ;i<banner.size();i++){
                list.add(banner.get(i).getIcon());
            }
            xBanner.setData(list,null);
            xBanner.setmAdapter(new XBanner.XBannerAdapter(){
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(getActivity()).load(list.get(position)).into((ImageView) view);
                }
            });
            // 设置XBanner的页面切换特效
            xBanner.setPageTransformer(Transformer.Default);
            // 设置XBanner页面切换的时间，即动画时长
            xBanner.setPageChangeDuration(1000);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
