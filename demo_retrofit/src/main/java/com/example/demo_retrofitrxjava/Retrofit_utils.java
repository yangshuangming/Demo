package com.example.demo_retrofitrxjava;

import com.google.gson.Gson;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/10/26.
 */

public class Retrofit_utils {
    private static Retrofit_utils utils;
    private final Retrofit retrofit;

    private Retrofit_utils(){
        //http://v.juhe.cn/toutiao/index?key=097060266650f67b2cebd2a06aded587&type=yule
        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(new Gson())).baseUrl("http://v.juhe.cn/").build();

    }
    public static synchronized Retrofit_utils getInstance(){
        if (utils==null){
            utils=new Retrofit_utils();
        }
        return utils;
    }

    public void sendGET(){
        Iretrofit iretrofit = retrofit.create("Retrofit接口");
        Call<实体类> yule = iretrofit.GET("参数A", "参数B");
        yule.enqueue(new Callback<实体类>() {
            @Override
            public void onResponse(Call<实体类> call, Response<实体类> response) {

            }

            @Override
            public void onFailure(Call<实体类> call, Throwable t) {

            }
        });

    }
}
