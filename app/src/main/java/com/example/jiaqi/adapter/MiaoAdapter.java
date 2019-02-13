package com.example.jiaqi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jiaqi.R;
import com.example.jiaqi.bean.ShowBean;

public class MiaoAdapter extends RecyclerView.Adapter<MiaoAdapter.ViewHolder> {
    Context context;
    ShowBean showBean;

    public MiaoAdapter(Context context, ShowBean showBean) {
        this.context = context;
        this.showBean = showBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.miao_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.miao_text_name.setText(showBean.getData().getMiaosha().getList().get(i).getTitle());
        Glide.with(context).load(showBean.getData().getMiaosha().getList().get(i).getImages().split("\\|")[0].replace("https","http")).into(viewHolder.miao_imag_icon);
    }

    @Override
    public int getItemCount() {
        return showBean.getData().getMiaosha().getList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView miao_imag_icon;
        private TextView miao_text_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            miao_imag_icon = itemView.findViewById(R.id.miao_imag_icon);
            miao_text_name = itemView.findViewById(R.id.miao_text_name);
        }
    }
}
