package com.leonxtp.rxjava.core;

/**
 * Created by LeonXtp on 2018/5/23 9:31
 */
public interface ObservableSource<T> {

    void subscribe(Observer<T> observer);
}
