package LinkedList.DoubleLinkedList;

public class Node<E> {
    public Node<E> prev;
    public Node<E> next;
    public E value;

    public Node(Node<E> prev, E value, Node<E> next) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }
}
