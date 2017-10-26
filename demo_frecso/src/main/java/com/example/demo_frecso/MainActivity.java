package com.example.demo_frecso;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView my_image_view0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化Fresco
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initView();
        initdata();
        initCache();
    }

    //定义清除缓存
    private void initCache() {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        if (imagePipeline!=null){
            imagePipeline.clearMemoryCaches();
            imagePipeline.clearDiskCaches();
            imagePipeline.clearCaches();
        }
    }

    private void initdata() {
        //配置样式
        RoundingParams roundingParams = new RoundingParams();
        //设置圆形
        roundingParams.setRoundAsCircle(true);
        DraweeController controller = Fresco.newDraweeControllerBuilder().setUri(Uri.parse("https://image.yunifang.com/yunifang/images/121/goods_img/17062610568378169043195978.jpg")).setTapToRetryEnabled(true).setOldController(my_image_view0.getController()).build();
        //设置控制器
        my_image_view0.setController(controller);
        //设置样式
        my_image_view0.getHierarchy().setRoundingParams(roundingParams);
    }

    private void initView() {
        my_image_view0 = (SimpleDraweeView) findViewById(R.id.simple);
    }
}
