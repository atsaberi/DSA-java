package com.example;

import java.util.Objects;

public class GenericHashMap<K,V> {
    static class Entry<K,V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K,V> next)  {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Entry<K,V>[] buckets;
    private final int CAPACITY;


    public GenericHashMap(int capacity) {
        this.CAPACITY = capacity;
        this.buckets = new Entry[capacity];
    }
    /***
     * int positiveHash = hash & 0x7fffffff;
     * why not Math.abs()? missed edge case = Math.abs(Integer.MIN_VALUE) = -2147483648
     * @param key
     * @return
     */
    private int getKeyIndex(K key) {
        return key == null ? 0 :(key.hashCode() & 0x7fffffff) % CAPACITY;
    }

    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        Entry head = buckets[keyIndex];

        if(buckets[keyIndex] == null) {
            buckets[keyIndex] = new Entry<>(key,value, null);
            return;
        }

        Entry current = head;
        Entry prev = null;
        while(current!= null) {
            if(Objects.equals(current.key, key)) {
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }

        prev.next = new Entry(key, value, null);
    }

    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        Entry<K,V> current = buckets[keyIndex];

        while(current != null) {
            if(Objects.equals(current.key, key)) return current.value;
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        GenericHashMap<Integer, String> myMap = new GenericHashMap<Integer,String>(2);
        myMap.put(1, "one");
        myMap.put(2, "TWO");
        myMap.put(3, "three");
        myMap.put(2, "five");
        myMap.put(4, "for");

        System.out.println(myMap.get(1));
        System.out.println(myMap.get(2));
        System.out.println(myMap.get(3));

    }
}



