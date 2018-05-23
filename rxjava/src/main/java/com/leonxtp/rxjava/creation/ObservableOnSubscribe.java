package com.leonxtp.rxjava.creation;

import com.leonxtp.rxjava.core.Observer;

/**
 * Created by LeonXtp on 2018/5/23 9:49
 */
public abstract class ObservableOnSubscribe<T> {

    public abstract void subscribe(Observer<T> observer);

}
