package com.circle.sogou;

import java.sql.Time;

public class Entry<K,V> implements BaseEntry<K,V>{
    K k;
    V v;
    long time;

    Entry<K, V> next;

    public Entry(K k, V v, Entry<K, V> next) {
        this.k = k;
        this.v = v;
        this.time = System.currentTimeMillis();
        this.next = next;
    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }

    @Override
    public void setKey(K k) {
        this.k = k;
    }

    @Override
    public void setValue(V v) {
        this.v = v;
    }

    public long getTime(){
        return time;
    }
}