package com.example.demo_baser;



import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    float mcurrentPosition[] = new float[2];//X   Y  坐标
    private Button btu;
    private ImageView image;
    private TextView textView;
    private RelativeLayout fu;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btu = (Button) findViewById(R.id.btu);
        image = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.textView);
        fu = (RelativeLayout) findViewById(R.id.activity_main);

        btu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btu:
                final ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.mipmap.ic_launcher);
                // LayoutParams相当于一个Layout的信息包，它封装了Layout的位置、高、宽等信息
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(50, 50);
                //添加到layout中
                fu.addView(imageView, layoutParams);

                //获取父布局坐标
                int[] fuposition = new int[2];
                fu.getLocationInWindow(fuposition);
                //获取按钮的坐标
                int[] btupositon = new int[2];
                btu.getLocationInWindow(btupositon);
                //获取图片坐标
                int[] imgposition = new int[2];
                image.getLocationInWindow(imgposition);
                //获取开始的做标

                //点击按钮发送图片的坐标：按钮起点坐标-父布局起点坐标+按钮的一半
                int startX = btupositon[0] - fuposition[0] + btu.getWidth() / 2;
                int startY = btupositon[1] - fuposition[1] + btu.getWidth() / 2;
                //获取结束时的做标

                //计算动画结束时的坐标：购物车的起点-父布局起点+购物车的1/5
                int toX = imgposition[0] - fuposition[0] + image.getWidth() / 5;
                int toY = imgposition[1] - fuposition[1];


                //绘制贝塞尔曲线
                Path path = new Path();
                //开始
                path.moveTo(startX, startY);
                //结束
                path.quadTo((startX + toX) / 2, startY, toX, toY);
                //PathMeasure
                // 作用：测量并获取Path的信息，用于绘制Path路径实现动画效果
                final PathMeasure pathMeasure = new PathMeasure(path, false);
                //属性动画实现贝塞尔   pathMeasure.getLength() 获取路径总长度
                //ofInt和ofFloa都是一样的  只不过传递的参数类型不一样
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, pathMeasure.getLength());
                valueAnimator.setDuration(1000);
                //设置线性插入器
                valueAnimator.setInterpolator(new LinearInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //valueAnimator.getAnimatedValue()  获取动画当前的值
                        //getAnimatedValue()原本返回的是object类型 我们是初始化动画的时候是ofFloat 所以必须是float   int同理
                        float animatedValue = (float) valueAnimator.getAnimatedValue();

                        pathMeasure.getPosTan(animatedValue, mcurrentPosition, null);
                        //将动画图片放到贝塞尔曲线中
                        imageView.setTranslationX(mcurrentPosition[0]);
                        imageView.setTranslationY(mcurrentPosition[1]);
                    }
                });
                //开始执行动画
                valueAnimator.start();
                valueAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        fu.removeView(imageView);
                        i++;
                        textView.setText(i + "");
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                break;
        }
    }
}

