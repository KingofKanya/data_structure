package LinkedList.DoubleLinkedList.test;

import LinkedList.DoubleLinkedList.DoubleLinkedList;

public class DoubleLinkedListTest {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("test display and addFirst");
        DoubleLinkedList s1 = new DoubleLinkedList();
        s1.display();

        s1.addFirst(1);
        s1.display();
        s1.addFirst(2);
        s1.display();

        System.out.println("\ntest remove");
        s1.remove(1);
        s1.display();
        s1.remove(0);
        s1.display();
        s1.remove(1);
        s1.remove(-1);
        s1.display();

        System.out.println("\ntest addFirst addLast removeFirst removeLast");
        s1.addFirst(3);
        s1.addFirst(2);
        s1.addFirst(1);
        s1.display();
        s1.addLast(1);
        s1.display();
        s1.removeLast();
        s1.display();
        s1.removeFirst();
        s1.display();

        System.out.println("\ntest insert");
        s1.insert(1, 2);
        s1.display();
        s1.insert(0, 0);
        s1.display();
        s1.insert(3, -1);
        s1.display();
        s1.insert(5, 5);
        s1.display();
        s1.insert(100, 1);
    }
}
