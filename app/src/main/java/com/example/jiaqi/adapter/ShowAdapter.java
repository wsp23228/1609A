package com.example.jiaqi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.jiaqi.R;
import com.example.jiaqi.bean.ShowBean;

public class ShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ShowBean showBean;
    final int TYPE1 = 0;
    final int TYPE2 = 1;
    final int TYPE3 = 2;

    public ShowAdapter(Context context, ShowBean showBean) {
        this.context = context;
        this.showBean = showBean;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE1;
        }else if(position == 1){
            return TYPE2;
        }else{
            return TYPE3;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        int type = getItemViewType(i);
        if(type == TYPE1){
            view = LayoutInflater.from(context).inflate(R.layout.show01_layout, viewGroup, false);
            return new ViewHolderRE01(view);
        }else if(type == TYPE2){
            view = LayoutInflater.from(context).inflate(R.layout.show02_layout,viewGroup,false);
            return new ViewHolderRE02(view);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.show03_layout,viewGroup,false);
            return new ViewHolderRE03(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);
        if(type == TYPE1){
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            gridLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
            ((ViewHolderRE01) viewHolder).show01_RecyclerView.setLayoutManager(gridLayoutManager);
            FenAdapter fenAdapter = new FenAdapter(context,showBean);
            ((ViewHolderRE01) viewHolder).show01_RecyclerView.setAdapter(fenAdapter);
        }else if(type == TYPE2){
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);
            gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            ((ViewHolderRE02) viewHolder).show02_RecyclerView.setLayoutManager(gridLayoutManager);
            MiaoAdapter miaoAdapter = new MiaoAdapter(context,showBean);
            ((ViewHolderRE02) viewHolder).show02_RecyclerView.setAdapter(miaoAdapter);
        }else{
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            ((ViewHolderRE03) viewHolder).show03_RecyclerView.setLayoutManager(linearLayoutManager);
            TuiAdapter tuiAdapter = new TuiAdapter(context,showBean);
            ((ViewHolderRE03) viewHolder).show03_RecyclerView.setAdapter(tuiAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    class ViewHolderRE01 extends RecyclerView.ViewHolder{
        RecyclerView show01_RecyclerView;
        public ViewHolderRE01(@NonNull View itemView) {
            super(itemView);
            show01_RecyclerView = itemView.findViewById(R.id.show01_RecyclerView);
        }
    }


    class ViewHolderRE02 extends RecyclerView.ViewHolder{
        RecyclerView show02_RecyclerView;

        public ViewHolderRE02(@NonNull View itemView) {
            super(itemView);
            show02_RecyclerView = itemView.findViewById(R.id.show02_RecyclerView);
        }
    }


    class ViewHolderRE03 extends RecyclerView.ViewHolder{
        RecyclerView show03_RecyclerView;

        public ViewHolderRE03(@NonNull View itemView) {
            super(itemView);
            show03_RecyclerView = itemView.findViewById(R.id.show03_RecyclerView);
        }
    }
}
