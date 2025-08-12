package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestArrayQueue {

    @Test
    void testEnqueue() {
        ArrayQueue q = new ArrayQueue(3);
        assertFalse(q.isFull());
        q.enqueue(10);
        assertFalse(q.isFull());
        q.enqueue(20);
        assertFalse(q.isEmpty());
        q.enqueue(30);
        assertTrue(q.isFull());
        assertEquals(3, q.getSize());
    }

    @Test
    void testDequeue() {
        ArrayQueue q = new ArrayQueue(3);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        assertFalse(q.isEmpty());
        q.dequeue();
        assertEquals(2, q.getSize());
        assertFalse(q.isEmpty());
        q.dequeue();
        assertEquals(1, q.getSize());
        assertFalse(q.isEmpty());
        q.dequeue();
        assertEquals(0, q.getSize());
        assertTrue(q.isEmpty());
    }

    @Test
    void testIsFull() {
        ArrayQueue q = new ArrayQueue(2);
        q.enqueue(1);
        q.enqueue(2);
        assertTrue(q.isFull());
    }

    @Test
    void testQueueFullThrows() {
        ArrayQueue qt = new ArrayQueue(1);
        qt.enqueue(5);
        assertThrows(IllegalStateException.class, () -> qt.enqueue(6));
    }

    @Test
    void testQueueEmptyThrows() {
        ArrayQueue qd = new ArrayQueue(1);
        assertThrows(IllegalStateException.class, qd::dequeue);
    }
}
