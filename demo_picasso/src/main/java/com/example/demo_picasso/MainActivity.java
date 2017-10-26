package com.example.demo_picasso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import it.sephiroth.android.library.picasso.MemoryPolicy;
import it.sephiroth.android.library.picasso.Picasso;

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
        //Picasso没有DiskCache，但自带清理缓存方法
        Picasso.with(this).load(R.mipmap.ic_launcher).memoryPolicy(MemoryPolicy.NO_CACHE).into(iv);

    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
    }
}
