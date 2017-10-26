package com.example.demo_okhttp3;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by lenovo on 2017/10/25.
 */

public class Okhttp_utils {
    private static Okhttp_utils utils;
    private OkHttpClient client;

    private Okhttp_utils() {
        client = new OkHttpClient.Builder().build();
    }

    public static synchronized Okhttp_utils getInstance() {
        if (utils == null) {
            utils = new Okhttp_utils();
        }
        return utils;
    }

    public void sendGET(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public void sendPOST(String url, RequestBody body,Callback callback){
        Request post = new Request.Builder().url(url).method("POST", body).build();
        Call call = client.newCall(post);
        call.enqueue(callback);

    }
}
