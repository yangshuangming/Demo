package com.example.demo_retrofitrxjava;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2017/10/26.
 */

public interface Iretrofit {
    @GET("路径尾端")
    Call<Objects> GET(@Query("索引key") String key, @Query("索引value") String value);
}
