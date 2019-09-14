/*
package com.circle.sogou;

public class ReHashMap {
    private int defaultLength = 3;//默认长度
    private double useSize;//使用数组位置的数量
    private Entry<String, Integer>[] table;//数组

    public ReHashMap() {
        this(3);
    }

    public ReHashMap(int defaultLength) {
        if (defaultLength < 0) {
            throw new IllegalArgumentException("数组异常");
        }

        this.defaultLength = defaultLength;
        table = new Entry[defaultLength];
    }


    */
/**
     * 使用每个object的hashCode计算hashCode
     * @param hashCode
     * @return  hashCode
     *//*

    private int hash(int hashCode) {
        hashCode = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
        return hashCode ^ ((hashCode >>> 7) ^ hashCode >>> 4);
    }

    */
/**
     * 获取保存位置的数组下标
     *
     * @param k
     * @param length
     * @return
     *//*

    private int getIndex(String k, int length) {
        int m = length - 1;
        int index = hash(k.hashCode()) & m;//取模
        return index >= 0 ? index : -index;
    }

    */
/**
     * 存
     *
     * @param k
     * @param v
     * @return
     *//*

    @Override
    public String put(String k, Integer v) {

        if (useSize >= defaultLength) {
            Entry<String,Integer> entryRemove = removeOneEntry();//当长度达到了N的时候，淘汰更新时间最早的记录
            entryRemove.setKey(k);
            entryRemove.setValue(v);
        }
        //计算出下标
        int index = getIndex(k, table.length);
        Entry<K, V> entry = table[index];
        Entry<K, V> newEntry = new Entry<>(k, v, null);
        if (entry == null) {
            table[index] = newEntry;
            useSize++;//table中有位置被占
        } else {
            Entry<K, V> t = entry;
            //相同key 对应修改当前value
            if (t.getKey() == k || (t.getKey() != null && t.getKey().equals(k))) {
                if( t.v < v);
            } else {
                while (t.next != null) {
                    if (t.next.getKey() == k || (t.next.getKey() != null && t.next.getKey().equals(k))) {//相同key 对应修改当前value
                        t.next.v = v;
                        break;
                    } else {
                        t = t.next;
                    }
                }
                if (t.next == null) {
                    t.next = newEntry;
                }
            }
        }
        return newEntry.getValue();
    }

    public Entry<String,Integer> removeOneEntry() {
        long timeEarly = table[0].getTime();
        K key = table[0].getKey();
        for(Entry<String,Integer> entry:table){
            if (timeEarly < entry.getTime()){
                timeEarly = entry.getTime();
                key = entry.getKey();
            }
        }
        int index = getIndex(key,defaultLength);

        Entry<K,V> removeEntry = new Entry<>();
        table[index] = removeEntry;
        return removeEntry;
    }


    */
/**
     * 取值
     *
     * @param k
     * @return
     *//*

    @Override
    public V get(K k) {
        int index = getIndex(k, table.length);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            throw new NullPointerException();
        }
        while (entry != null) {
            if (k == entry.getKey() || k.equals(entry.getKey())) {
                return entry.v;
            } else {
                entry = entry.next;
            }
        }
        return null;
    }
}
*/
