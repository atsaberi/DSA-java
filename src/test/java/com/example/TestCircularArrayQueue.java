package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestCircularArrayQueue {
    @Test
    void testEnqueue() {
        CircularArrayQueue caq = new CircularArrayQueue(4);
        assertEquals(0 , caq.getSize());
        assertTrue(caq.isEmpty());
        caq.enqueue(3);
        assertEquals(1 , caq.getSize());
        assertFalse(caq.isEmpty());
        caq.enqueue(4);
        assertEquals(2 , caq.getSize());
        caq.enqueue(5);
        assertEquals(3 , caq.getSize());
        caq.enqueue(6);
        assertTrue(caq.isFull());
    }

   @Test
    void testDequeue() {
        CircularArrayQueue cq = new CircularArrayQueue(2);
        assertEquals(0 , cq.getSize());
        assertTrue(cq.isEmpty());
        cq.enqueue(3);
        assertEquals(1 , cq.getSize());
        assertFalse(cq.isEmpty());
        cq.enqueue(4);
        assertTrue(cq.isFull());
        cq.dequeue();
        assertFalse(cq.isFull());
        assertEquals(1, cq.getSize());
        cq.dequeue();
        assertTrue(cq.isEmpty());
        cq.display();
    }

   @Test
    void testEnqueueDequeue() {
        CircularArrayQueue cq = new CircularArrayQueue(2);
        assertEquals(0 , cq.getSize());
        assertTrue(cq.isEmpty());
        cq.enqueue(3);
        assertEquals(1 , cq.getSize());
        assertFalse(cq.isEmpty());
        cq.dequeue();
        cq.enqueue(4);
        cq.enqueue(5);
        cq.dequeue();
        cq.enqueue(6);
        assertEquals(2 , cq.getSize());
        assertTrue(cq.isFull());
        cq.display();
    }

    @Test
    void testFullThrows() {
        CircularArrayQueue cq = new CircularArrayQueue(2);
        assertEquals(0 , cq.getSize());
        cq.enqueue(3);
        cq.enqueue(5);
        assertThrows(IllegalStateException.class, () -> cq.enqueue(6));
    }

    void testEmptyThrows() {
        CircularArrayQueue cq = new CircularArrayQueue(1);
        assertEquals(0 , cq.getSize());
        cq.enqueue(3);
        cq.enqueue(4);
        assertThrows(IllegalStateException.class, () -> cq.enqueue(6));
    }
}

