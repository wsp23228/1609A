package com.example.jiaqi.newwork;

import android.os.Environment;
import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogRecord;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Okhttp {

    private static OkHttpClient okHttpClient;
    private static Handler handler = new Handler();
    private static volatile Okhttp instance;

    private Interceptor getAppInterpolator(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.e("+++", "拦截前");
                Response proceed = chain.proceed(request);
                Log.e("---", "拦截后");
                return proceed;
            }
        };
        return interceptor;
    }

    private Okhttp(){
        File file = new File(Environment.getExternalStorageDirectory(), "cache11");
        new OkHttpClient().newBuilder()
                .readTimeout(3000,TimeUnit.SECONDS)
                .connectTimeout(3000,TimeUnit.SECONDS)
                .addInterceptor(getAppInterpolator())
                .cache(new Cache(file,10*1024))
                .build();
    }

    //创建单例
    public static Okhttp getInstance(){
        if(instance == null){
            synchronized (Okhttp.class){
                if(null == instance){
                   instance = new Okhttp();
                }
            }
        }
        return instance;
    }

    public void okhttpGet(String url, final Class calz, final getOkhttpCallBack getOkhttpCallBack){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).method("GET", null).build();
        okHttpClient.newCall(request).enqueue(new Callback(){
            @Override
            public void onFailure(Call call, IOException e){

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(s, calz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getOkhttpCallBack.getOkhttpSuccess(o);
                    }
                });
            }
        });
    }
    public void okhttpPost(String url, final Class calz, Map<String, String> map, final getOkhttpCallBack getOkhttpCallBack){
        okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        for(Map.Entry<String,String> str:map.entrySet()){
            builder.add(str.getKey(),str.getValue());
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Log.i("aaa", "getOkhttpSuccess: "+s);
                Gson gson = new Gson();
                final Object o = gson.fromJson(s, calz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getOkhttpCallBack.getOkhttpSuccess(o);
                    }
                });
            }
        });
    }
    public interface getOkhttpCallBack{
        void getOkhttpSuccess(Object ob);
        void getOkhttpFiled();
    }
}