package com.example.jiaqi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiaqi.R;
import com.example.jiaqi.bean.LeftBean;

import org.w3c.dom.Text;

import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {
    Context context;
    LeftBean leftBean;

    public LeftAdapter(Context context, LeftBean leftBean) {
        this.context = context;
        this.leftBean = leftBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.left_text_name.setText(leftBean.getData().get(i).getName());
        viewHolder.left_text_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lisenter.setRightCallBack(leftBean.getData().get(i).getCid(),leftBean.getData());
            }
        });
    }

    @Override
    public int getItemCount() {
        return leftBean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView left_text_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            left_text_name = itemView.findViewById(R.id.left_text_name);
        }
    }

    setItemCilckLisenter lisenter;
    public interface setItemCilckLisenter{
        void setRightCallBack(int i, List<LeftBean.DataBean> dataBeanList);
    }
    public void setItemCilckLisenter(setItemCilckLisenter lisenter){
        this.lisenter = lisenter;
    }
}
