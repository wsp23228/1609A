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

public class TuiAdapter extends RecyclerView.Adapter<TuiAdapter.ViewHolder> {
    Context context;
    ShowBean showBean;

    public TuiAdapter(Context context, ShowBean showBean) {
        this.context = context;
        this.showBean = showBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.tui_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tui_text_name.setText(showBean.getData().getTuijian().getList().get(i).getTitle());
        Glide.with(context).load(showBean.getData().getTuijian().getList().get(i).getImages().split("\\|")[0].replace("https","http")).into(viewHolder.tui_imag_icon);
    }

    @Override
    public int getItemCount() {
        return showBean.getData().getTuijian().getList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView tui_imag_icon;
        private TextView tui_text_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tui_imag_icon = itemView.findViewById(R.id.tui_imag_icon);
            tui_text_name = itemView.findViewById(R.id.tui_text_name);
        }
    }
}
