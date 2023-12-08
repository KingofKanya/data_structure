package LinkedList.CircularLinkedList;

public class CircularLinkedList {
    private final Node sentinel = new Node(null, -1, null);

    public CircularLinkedList() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }


}
