package com.leonxtp.rxjava.core;

/**
 * Created by LeonXtp on 2018/5/23 9:30
 */
public interface Observer<T> {

    void onSubscribe();

    void onNext(T t);

    void onComplete();

    void onError(Throwable throwable);

}
