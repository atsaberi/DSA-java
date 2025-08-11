package com.example;

/****
 * A basic implementation of Queue using Array and position to the last element index
 *  Attributes:
 *  - Array of integers as a queue
 *  - capacity
 *  - position
 *
 * Functions:
 *  - isFull
 *  - isEmpty
 *  - enqueue
 *  - dequeue
 */

class ArrayQueue {
    private int[] queueData;
    private int capacity;
    private int size;
    private int pos;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queueData = new int[capacity];
        this.pos = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }


    public int getSize() {
        ///if(pos == -1) return 0;
        return size;
    }

    public void enqueue(int data) {
        if (isFull()) throw new IllegalStateException("Queue is full");

        else {
            pos++;
            queueData[pos] = data;
            size++;
        }
    }

    public void dequeue() {
         if (isEmpty())  throw new IllegalStateException("Queue is empty");

         else {
             for(int i = 0; i < pos ; i++) {
                 queueData[i] = queueData[i+1];
             }
             pos--;
             size--;
         }
    }
}