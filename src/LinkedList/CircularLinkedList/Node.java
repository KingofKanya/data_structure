package LinkedList.CircularLinkedList;

public class Node {
    public Node prev;
    public Node next;
    public int value;

    public Node(Node prev, int value, Node next) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }
}
