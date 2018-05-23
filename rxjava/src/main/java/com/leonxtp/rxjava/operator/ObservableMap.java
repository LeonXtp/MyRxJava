package com.leonxtp.rxjava.operator;

import com.leonxtp.rxjava.core.ObservableSource;
import com.leonxtp.rxjava.core.Observer;
import com.leonxtp.rxjava.core.TransformableObserver;
import com.leonxtp.rxjava.core.TransformableObservable;

/**
 * Created by LeonXtp on 2018/5/23 11:10
 */
public class ObservableMap<T, R> extends TransformableObservable<T, R> {

    private Transformer<T, R> func;

    public ObservableMap(ObservableSource<T> source, Transformer<T, R> func) {
        super(source);
        this.func = func;
    }

    @Override
    public void subscribeActual(Observer<R> observer) {
        source.subscribe(new MapObserver<T, R>(observer, func));
    }

    class MapObserver<T, R> extends TransformableObserver<T, R> {

        // This is essential for Transformer generic types mapping
        private Transformer<T, R> func;

        public MapObserver(Observer<R> actual, Transformer<T, R> func) {
            super(actual);
            this.func = func;
        }

        @Override
        public void onNext(T t) {
            actual.onNext(func.apply(t));
        }

    }

}
