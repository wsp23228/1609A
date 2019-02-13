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

public class FenAdapter extends RecyclerView.Adapter<FenAdapter.ViewHolder> {

    Context context;
    ShowBean showBean;

    public FenAdapter(Context context, ShowBean showBean) {
        this.context = context;
        this.showBean = showBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fenlei_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.fen_text_name.setText(showBean.getData().getFenlei().get(i).getName());
        Glide.with(context).load(showBean.getData().getFenlei().get(i).getIcon()).into(viewHolder.fen_imag_icon);
    }

    @Override
    public int getItemCount() {
        return showBean.getData().getFenlei().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView fen_imag_icon;
        private TextView fen_text_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fen_imag_icon = itemView.findViewById(R.id.fen_imag_icon);
            fen_text_name = itemView.findViewById(R.id.fen_text_name);
        }
    }
}
