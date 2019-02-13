package com.example.jiaqi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiaqi.R;
import com.example.jiaqi.bean.RightBean;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
    Context context;
    RightBean rightBean;

    public RightAdapter(Context context, RightBean rightBean) {
        this.context = context;
        this.rightBean = rightBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.right_text_name.setText(rightBean.getData().get(i).getName());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        gridLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        viewHolder.right_right_rv.setLayoutManager(gridLayoutManager);
        RightLiAdapter rightLiAdapter = new RightLiAdapter(context,rightBean);
        viewHolder.right_right_rv.setAdapter(rightLiAdapter);
    }

    @Override
    public int getItemCount(){
        return rightBean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView right_right_rv;
        TextView right_text_name;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            right_right_rv = itemView.findViewById(R.id.right_right_rv);
            right_text_name = itemView.findViewById(R.id.right_text_name);
        }
    }
}
