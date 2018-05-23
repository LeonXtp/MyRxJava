package com.leonxtp.rxjava.creation;

import com.leonxtp.rxjava.core.Observable;
import com.leonxtp.rxjava.core.Observer;

/**
 * Created by LeonXtp on 2018/5/23 9:40
 */
public class ObservableCreate<T> extends Observable<T> {

    private ObservableOnSubscribe<T> observableOnSubscribe;

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.observableOnSubscribe = observableOnSubscribe;
    }

    @Override
    public void subscribeActual(Observer<T> observer) {
        // Only create needs calling this onSubscribe() as it just need once calling
        // this calling will downstream to the actual subscriber
        observer.onSubscribe();
        this.observableOnSubscribe.subscribe(new ObserverCreate<T>(observer));
    }

    class ObserverCreate<T> implements Observer<T> {

        private Observer<T> observer;

        ObserverCreate(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onSubscribe() {
            observer.onSubscribe();
        }

        @Override
        public void onNext(T t) {
            observer.onNext(t);
        }

        @Override
        public void onComplete() {
            observer.onComplete();
        }

        @Override
        public void onError(Throwable throwable) {
            observer.onError(throwable);
        }
    }
}
