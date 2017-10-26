package com.example.demo_glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initdata();

    }

    private void initdata() {
        Glide.with(MainActivity.this).load(R.mipmap.ic_launcher).into(iv);

    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
    }
}
