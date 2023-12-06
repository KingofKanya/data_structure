package LinkedList.SingleLinkedList.test;

import LinkedList.SingleLinkedList.SingleLinkedList;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        System.out.println("test display and addFirst");
        SingleLinkedList s1 = new SingleLinkedList();
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

        System.out.println("\ntest addLast and removeFirst");
        s1.remove(0);
        s1.removeFirst();
        s1.display();
        s1.addLast(1);
        s1.display();
        s1.addLast(3, 4, 6);
        s1.display();

        System.out.println("\ntest insert");
        s1.insert(1, 2);
        s1.display();
        s1.insert(0, 0);
        s1.display();
        s1.insert(5, 5);
        s1.display();
        s1.insert(7, -1);
        s1.display();
    }
}
