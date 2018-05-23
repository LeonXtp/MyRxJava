package com.leonxtp.rxjava.core;

import com.leonxtp.rxjava.operator.Transformer;
import com.leonxtp.rxjava.creation.ObservableCreate;
import com.leonxtp.rxjava.creation.ObservableOnSubscribe;
import com.leonxtp.rxjava.operator.ObservableMap;

/**
 * Created by LeonXtp on 2018/5/23 9:30
 */
public abstract class Observable<T> implements ObservableSource<T> {

    @Override
    public void subscribe(Observer<T> observer) {
        subscribeActual(observer);
    }

    public abstract void subscribeActual(Observer<T> observer);

    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        return new ObservableCreate<>(observableOnSubscribe);
    }

    public <R> Observable<R> map(Transformer<T, R> func) {
        return new ObservableMap<>(this, func);
    }

}
