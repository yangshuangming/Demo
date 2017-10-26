package com.example.demo_mvpdagger2.presenter;

import android.os.Handler;
import android.util.Log;

import com.example.demo_mvpdagger2.view.Iview;

import javax.inject.Inject;

/**
 * Created by lenovo on 2017/10/25.
 */

public class Mpresenter implements Ipresenter {
    Handler handler = new Handler();
    Iview iview;

    @Inject
    public Mpresenter() {
        super();
    }

    public Mpresenter(Iview iview) {
        this.iview = iview;
    }



    @Override
    public void getData() {
        Log.e("tag", "成功");
    }
}
