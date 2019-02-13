package com.example.jiaqi.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jiaqi.R;
import com.zhy.view.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class JianFragment extends Fragment {
    @BindView(R.id.edit_shu)
    EditText editShu;
    @BindView(R.id.but_dian)
    Button butDian;
    @BindView(R.id.flow_layout)
    FlowLayout flowLayout;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jian_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        getdata();
        return view;
    }

    private void getdata() {
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,5,10,5);
        butDian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editShu.getText().toString();
                while (str.length()>0){
                        TextView textView = new TextView(getActivity());
                        textView.setPadding(28,10,28,10);
                        textView.setText(str);
                        textView.setMaxEms(10);
                        textView.setSingleLine();
                        textView.setLayoutParams(layoutParams);
                        flowLayout.addView(textView,layoutParams);
                    break;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
