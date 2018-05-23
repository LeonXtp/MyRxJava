package com.leonxtp.myrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.leonxtp.rxjava.core.Observable;
import com.leonxtp.rxjava.creation.ObservableOnSubscribe;
import com.leonxtp.rxjava.core.Observer;
import com.leonxtp.rxjava.operator.Transformer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyRxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRxJava();
    }

    private void myRxJava() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(Observer<Integer> observer) {
                Log.v(TAG, "subscribe()");
                observer.onNext(1);
                observer.onNext(2);
                observer.onComplete();
            }
        }).map(new Transformer<Integer, String>() {
            @Override
            public String apply(Integer origin) {
                Log.v(TAG, "apply()");
                return String.valueOf(origin);
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe() {
                Log.v(TAG, "onSubscribe()");
            }

            @Override
            public void onNext(String s) {
                Log.v(TAG, "onNext():" + s);
            }

            @Override
            public void onComplete() {
                Log.v(TAG, "onComplete()");
            }

            @Override
            public void onError(Throwable throwable) {
                Log.v(TAG, "onError()");
            }
        });
    }
}
