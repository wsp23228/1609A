package com.example.jiaqi.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jiaqi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WoFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.but_shang_tou)
    Button butShangTou;
    Unbinder unbinder;
    @BindView(R.id.imag_shang_icon)
    ImageView imagShangIcon;
    private AlertDialog.Builder builder;
    private Button but_paozhao;
    private Button but_xiangce;
    private Button but_quxiao;
    private AlertDialog alertDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wo_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        butShangTou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert();
            }
        });
        return view;
    }

    private void alert() {
        builder = new AlertDialog.Builder(getActivity());
        alertDialog = builder.create();
        View view = View.inflate(getActivity(), R.layout.shang_layout, null);
        alertDialog.setView(view);
        alertDialog.show();
        but_paozhao = view.findViewById(R.id.but_paozhao);
        but_xiangce = view.findViewById(R.id.but_xiangce);
        but_quxiao = view.findViewById(R.id.but_quxiao);
        but_paozhao.setOnClickListener(this);
        but_xiangce.setOnClickListener(this);
        but_quxiao.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but_paozhao:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,00);
                alertDialog.dismiss();
                break;
            case R.id.but_xiangce:
                Intent intent1 = new Intent(Intent.ACTION_PICK);
                intent1.setType("image/*");
                startActivityForResult(intent1,01);
                alertDialog.dismiss();
                break;
            case R.id.but_quxiao:
                alertDialog.dismiss();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 00 && resultCode == getActivity().RESULT_OK){
            Bitmap bitmap = data.getParcelableExtra("data");
            imagShangIcon.setImageBitmap(bitmap);
        }
        if(requestCode == 01 && resultCode == getActivity().RESULT_OK){
            Uri uri = data.getData();
            imagShangIcon.setImageURI(uri);
        }
    }
}
