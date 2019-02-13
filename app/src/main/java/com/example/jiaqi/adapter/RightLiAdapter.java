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
import com.example.jiaqi.bean.RightBean;

import java.util.List;

public class RightLiAdapter extends RecyclerView.Adapter<RightLiAdapter.ViewHolder> {

    Context context;
    RightBean rightBean;
    private List<RightBean.DataBean.ListBean> list;


    public RightLiAdapter(Context context, RightBean rightBean) {
        this.context = context;
        this.rightBean = rightBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rightli_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        list = rightBean.getData().get(i).getList();
        viewHolder.rightli_text_name.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getIcon()).into(viewHolder.rightli_imag_icon);
    }

    @Override
    public int getItemCount(){
        return rightBean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView rightli_imag_icon;
        TextView rightli_text_name;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            rightli_imag_icon = itemView.findViewById(R.id.rightli_imag_icon);
            rightli_text_name = itemView.findViewById(R.id.rightli_text_name);
        }
    }
}
