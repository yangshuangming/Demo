package com.example.demo_volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/10/26.
 */

public class Volley_utils {
    private static Volley_utils utils;
    private RequestQueue queue;

    private Volley_utils(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public static synchronized Volley_utils getInstance(Context context) {
        if (utils == null) {
            utils = new Volley_utils(context);
        }
        return utils;
    }

    public void sendGET(String url, Response.Listener listener, Response.ErrorListener errorListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, listener, errorListener);
        queue.add(stringRequest);
    }

    public void sendPOST(String url, final Map<String, String> maps, Response.Listener listener, Response.ErrorListener errorListener){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, listener, errorListener){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.putAll(maps);
                return map;
            }
        };
        queue.add(stringRequest);
    }
}
