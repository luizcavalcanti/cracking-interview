package cracking.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHeapTest {

    @Test
    public void test_emptyHeap() {
        Heap heap = new MaxHeap();
        assertEquals(0,heap.size());
        heap = new MinHeap();
        assertEquals(0,heap.size());
    }

    @Test
    public void test_maxHeap_peek() {
        Heap heap = new MaxHeap();

        heap.insert(1);
        assertEquals(1,heap.size());
        assertEquals(1,heap.peek());

        heap.insert(10);
        assertEquals(2,heap.size());
        assertEquals(10,heap.peek());

        heap.insert(5);
        assertEquals(3,heap.size());
        assertEquals(10,heap.peek());
    }

    @Test
    public void test_maxHeap_poll() {
        Heap heap = new MaxHeap();

        heap.insert(1);
        heap.insert(10);
        heap.insert(5);
        heap.insert(2);

        assertEquals(10, heap.poll());
        assertEquals(5, heap.poll());
        assertEquals(2, heap.poll());
        assertEquals(1, heap.poll());
    }

    @Test
    public void test_minHeap_peek() {
        Heap heap = new MinHeap();


        heap.insert(10);
        assertEquals(1,heap.size());
        assertEquals(10,heap.peek());

        heap.insert(1);
        assertEquals(2,heap.size());
        assertEquals(1,heap.peek());


        heap.insert(5);
        assertEquals(3,heap.size());
        assertEquals(1,heap.peek());
    }

    @Test
    public void test_minHeap_poll() {
        Heap heap = new MinHeap();

        heap.insert(1);
        heap.insert(10);
        heap.insert(5);
        heap.insert(2);

        assertEquals(1, heap.poll());
        assertEquals(2, heap.poll());
        assertEquals(5, heap.poll());
        assertEquals(10, heap.poll());
    }
}