package LinkedList.SingleLinkedList.test;

import LinkedList.SingleLinkedList.SingleLinkedList;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class SingleLinkedListTest {
    static SingleLinkedList<Integer> s = new SingleLinkedList<>();

    public static void main(String[] args) {
//        SingleLinkedList<Integer> s1 = new SingleLinkedList<>();
//        System.out.println("test display and addFirst");
//        s1.display();
//        s1.addFirst(1);
//        s1.display();
//        s1.addFirst(2);
//        s1.display();
//
//        System.out.println("\ntest remove");
//        s1.remove(1);
//        s1.display();
//        s1.remove(0);
//        s1.display();
//        s1.remove(1);
//        s1.remove(-1);
//        s1.display();
//
//        System.out.println("\ntest addLast removeFirst removeLast");
//        s1.remove(0);
//        s1.removeFirst();
//        s1.display();
//        s1.addLast(1);
//        s1.display();
//        s1.addLast(3, 4, 6);
//        s1.display();
//        s1.removeLast();
//        s1.display();
//
//        System.out.println("\ntest insert");
//        s1.insert(1, 2);
//        s1.display();
//        s1.insert(0, 0);
//        s1.display();
//        s1.insert(5, 5);
//        s1.display();
//        s1.insert(7, -1);
//        s1.display();
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
        s.addLast(1, 2, 3, 4, 5);
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
        s.addLast(1, 2, 3, 4, 5);
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
