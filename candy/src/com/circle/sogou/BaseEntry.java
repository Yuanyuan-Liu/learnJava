package com.circle.sogou;

public interface BaseEntry<K,V> {
    K getKey();//获取键
    V getValue();//获取值

    void setKey(K k);
    void setValue(V v);
}

