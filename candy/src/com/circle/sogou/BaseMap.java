package com.circle.sogou;

public interface BaseMap<K,V> {
    //存
    V put(K k, V v);
    //取
    V get(K k);
}