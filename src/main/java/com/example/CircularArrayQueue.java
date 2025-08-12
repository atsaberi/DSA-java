package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;


/****
 *  Implementation of Queue using circular array
 *  to improve dequeue performance from O(n) to O(1)
 */
public class CircularArrayQueue {
    private static final Logger logger = Logger.getLogger(CircularArrayQueue.class.getName());

    private int[] cque;
    private int capacity;
    private int size;
    private int front;
    private int rear;

    public CircularArrayQueue(int capacity) {
        this.cque  = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.front = 0;
        this.rear = 0;

        logger.setLevel(Level.INFO);
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            logger.warning("Queue is empty");
            return;
        }
        logger.info("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(cque[(front + i) % capacity]+ " ");
        }
    }

    public int getSize(){
        logger.info("Queue size: " + size);
        return size;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int val) {

        if(isFull()) {
            logger.warning("Queue is full. Cannot enqueue " + val);
        }
        else {
            cque[rear] = val;
            rear = (rear + 1) % capacity;
            size++;

            logger.info("Enqueued: " + val);
        }
    }
    public int dequeue() {
        int removed;
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty. Nothing to dequeue");
        }
        else {
            removed = cque[front];
            cque[front] = 0;
            front = (front + 1) % capacity;
            size--;
        }
        logger.info("Dequeued: " + removed);
        return removed;
    }
}
