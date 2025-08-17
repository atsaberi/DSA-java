package com.example;

import java.util.HashMap;

public class SimpleHashMapImp {

    private Entry[] entries;
    private final int capacity = 2;

    public SimpleHashMapImp() {
        this.entries = new Entry[capacity];
    }

    private static class Entry {
        int key;
        String value;
        Entry next;

        public Entry(int key, String value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int getKeyIndex(int key) {
        int keyHashCode = (Integer.hashCode(key)) & 0x7fffffff;
        return keyHashCode % entries.length;
    }

    public void put(int key, String value) {
        int keyIndex = getKeyIndex(key);
        Entry head = entries[keyIndex];

        if(head == null) {
            entries[keyIndex] = new Entry(key, value, null);
            return;
        }

        Entry current = head;
        Entry prev = null;
        while(current!= null) {
            if(current.key == key) {
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }

        prev.next = new Entry(key, value, null);

    }

    public String get(Integer key) {
        int index = getKeyIndex(key);

        Entry cur = entries[index];
        if(cur == null) {
            System.out.println("Map is empty");
            return null;
        }

        while(cur!=null) {
            if(cur.key == key)
                return cur.value;
            cur = cur.next;
        }
        return "not found";
    }

    public static void main(String[] args) {
        SimpleHashMapImp myMap = new SimpleHashMapImp();
        myMap.put(1, "one");
        myMap.put(2, "TWO");
        myMap.put(3, "three");
        myMap.put(2, "five");
        myMap.put(4, "for");

        System.out.println(myMap.get(1));
        System.out.println(myMap.get(2));
        System.out.println(myMap.get(3));
        System.out.println(myMap.get(8));

    }

 }
