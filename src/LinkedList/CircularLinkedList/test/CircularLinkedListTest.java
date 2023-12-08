package LinkedList.CircularLinkedList.test;

import LinkedList.CircularLinkedList.CircularLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircularLinkedListTest {
    static CircularLinkedList<Integer> s = new CircularLinkedList<>();

    public static void main(String[] args) {
        s.clear();
        s.display();
        s.add(1, 2, 3, 4, 5, 6, 7);
        s.display();
    }

    @Test
    public void testAdd() {
        s.clear();
        assertTrue(s.isEmpty());
        assertEquals(0, s.size());
        s.addFirst(1);
        assertFalse(s.isEmpty());
        assertEquals(1, s.size());
        assertEquals((Integer) 1, s.get(0));
        assertNull(s.get(1));
        s.addLast(2);
        assertEquals((Integer) 2, s.get(1));
        assertNull(s.get(-1));
    }

    @Test
    public void testRemove() {
        s.clear();
        s.removeFirst();
        s.removeLast();
        s.add(1, 2, 3, 4, 5);
        assertEquals(5, s.size());
        assertEquals((Integer) 1, s.removeFirst());
        assertEquals((Integer) 2, s.getFirst());
        assertEquals((Integer) 5, s.getLast());
        assertEquals((Integer) 5, s.removeLast());
        assertEquals((Integer) 2, s.getFirst());
        assertEquals((Integer) 4, s.getLast());
        assertEquals(3, s.size());
    }

    @Test
    public void testGet() {
        s.clear();
        assertNull(s.get(-1));
        assertNull(s.get(0));
        assertNull(s.get(1));
        s.add(1, 2, 3, 4, 5);
        assertEquals((Integer) 1, s.get(0));
        assertEquals((Integer) 2, s.get(1));
        assertEquals((Integer) 3, s.get(2));
        assertEquals((Integer) 4, s.get(3));
        assertEquals((Integer) 5, s.get(4));
    }

    @Test
    public void testInsertAndRemove() {
        s.clear();
        s.insert(100, 1);

        assertTrue(s.isEmpty());
        s.insert(0, 1);
        s.insert(1, 2);
        s.insert(2, 3);
        assertEquals((Integer) 1, s.get(0));
        assertEquals((Integer) 2, s.get(1));
        assertEquals((Integer) 3, s.get(2));

        assertEquals((Integer) 1, s.remove(0));
        assertEquals((Integer) 3, s.remove(1));
        assertEquals((Integer) 2, s.remove(0));
        assertTrue(s.isEmpty());
    }
}
