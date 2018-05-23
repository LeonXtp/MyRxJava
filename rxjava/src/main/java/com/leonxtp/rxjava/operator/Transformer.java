package com.leonxtp.rxjava.operator;

/**
 * Created by LeonXtp on 2018/5/23 11:04
 */
public interface Transformer<T, R> {

    R apply(T origin);

}
