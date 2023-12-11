package Queue.LinkedListQueue;

import Queue.LinkedListQueue.LinkedListQueue;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListQueueTest {
    public static void main(String[] args) {

    }

    @Test
    public void test(){
        LinkedListQueue<Integer> s1 = new LinkedListQueue<Integer>();
        s1.display();
        assertTrue(s1.isEmpty());
        assertFalse(s1.isFull());
        assertEquals(0, s1.size());

        s1.offer(1);
        s1.display();
        assertFalse(s1.isEmpty());
        assertEquals(1, s1.size());

        s1.offer(2);
        s1.display();
        assertFalse(s1.isEmpty());
        assertEquals(2, s1.size());

        assertEquals((Integer) 1, s1.peek());
        assertEquals((Integer) 1, s1.poll());
        s1.display();
        assertEquals(1, s1.size());
        assertEquals((Integer) 2, s1.peek());
        assertEquals((Integer) 2, s1.poll());
        s1.display();

        assertTrue(s1.isEmpty());
        assertNull(s1.peek());
        assertNull(s1.poll());
    }
}
