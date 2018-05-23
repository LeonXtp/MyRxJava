package com.leonxtp.rxjava.core;

/**
 * Created by LeonXtp on 2018/5/23 14:45
 */
public abstract class TransformableObservable<T, R> extends Observable<R> {

    protected ObservableSource<T> source;

    public TransformableObservable(ObservableSource<T> source) {
        this.source = source;
    }

}
