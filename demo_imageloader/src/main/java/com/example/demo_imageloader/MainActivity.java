package com.example.demo_imageloader;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private ImageLoadingListener imageLoadingListener = new ImageLoadingListener() {

        @Override
        public void onLoadingStarted(String imageUri, View view) {

        }

        @Override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

        }

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

        }

        @Override
        public void onLoadingCancelled(String imageUri, View view) {

        }
    };
    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initdata();
        initCache();

    }

    //清除缓存
    private void initCache() {
        /*DiskCacheUtils.removeFromCache("图片路径", imageLoader.getDiskCache());
        MemoryCacheUtils.removeFromCache("图片路径", imageLoader.getMemoryCache());*/
    }

    private void initdata() {
        //设置Imageloader的加载图片配置
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(MainActivity.this).build();
        //初始化ImageLoader
        ImageLoader.getInstance().init(build);
        ImageLoader.getInstance().displayImage("https://image.yunifang.com/yunifang/images/goods/121/goods_img/17062610568378169043195978.jpg", iv, options);
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
    }
}
