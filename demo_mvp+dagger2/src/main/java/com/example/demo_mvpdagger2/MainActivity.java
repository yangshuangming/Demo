package com.example.demo_mvpdagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.demo_mvpdagger2.presenter.DaggerCompount;
import com.example.demo_mvpdagger2.presenter.Mpresenter;
import com.example.demo_mvpdagger2.view.Iview;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements Iview{

    //注入presenter层
    @Inject
    Mpresenter mpresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //利用注入器进行注入
        DaggerCompount.builder().build().inject(this);
        //调用presenter的方法
        mpresenter.getData();
    }

    @Override
    public void getpresenterdata(final String result) {


    }
}
