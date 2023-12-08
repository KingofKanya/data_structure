package LinkedList.DoubleLinkedList;

import LinkedList.LinkedList;

public class DoubleLinkedList<E> implements LinkedList<E> {
    private final Node head;
    private final Node tail;
    int size;

    public DoubleLinkedList() {
        this.head = new Node(null, -1, null);
        this.tail = new Node(null, -1, null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    /**
     * @param index 待查找节点索引
     * @return 返回指定索引节点, index=-1返回head, =size+1 返回null
     */
    private Node find(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) return p;
        }
        return null;
    }


    public void insert(int index, int value){
        Node prev = find(index - 1);
        if (prev == null);
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    @Override
    public void insert(int index, E element) {

    }

    /**
     * @param index
     */
    public E remove(int index) {
        Node removed = find(index);
        if (removed == null || removed == head) return null;
        removed.prev.next = removed.next;
        removed.next.prev = removed.prev;
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        sb.append("null<-->");
        while (curr.next != tail) {
            curr = curr.next;
            sb.append(curr.value).append("<-->");
        }
        sb.append("null");
        System.out.println(sb);
    }

    @Override
    public void clear() {

    }
}
