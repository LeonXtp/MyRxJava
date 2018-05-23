package com.leonxtp.rxjava.core;

/**
 * Created by LeonXtp on 2018/5/23 11:34
 */
public abstract class TransformableObserver<T, R> implements Observer<T> {

    private boolean isDone;

    protected Observer<R> actual;

    public TransformableObserver(Observer<R> actual) {
        this.actual = actual;
    }

    @Override
    public void onSubscribe() {
        actual.onSubscribe();
    }

    @Override
    public void onComplete() {
        if (isDone) {
            return;
        }
        isDone = true;
        actual.onComplete();
    }

    @Override
    public void onError(Throwable throwable) {
        if (isDone) {
            return;
        }
        isDone = true;
        actual.onError(throwable);
    }
}
