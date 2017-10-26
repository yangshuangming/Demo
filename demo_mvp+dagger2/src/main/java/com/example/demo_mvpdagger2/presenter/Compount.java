package com.example.demo_mvpdagger2.presenter;

import com.example.demo_mvpdagger2.MainActivity;

import dagger.Component;

/**
 * Created by lenovo on 2017/10/25.
 */
@Component
public interface Compount {

    void inject(MainActivity mainActivity);
}
