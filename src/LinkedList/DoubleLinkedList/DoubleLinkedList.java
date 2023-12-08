package LinkedList.DoubleLinkedList;

import LinkedList.LinkedList;

import java.util.Iterator;

public class DoubleLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    int size;

    public DoubleLinkedList() {
        this.head = new Node<>(null, null, null);
        this.tail = new Node<>(null, null, null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    /**
     * @param index 待查找节点索引
     * @return 返回指定索引节点, 不存在则返回null
     */
    private Node<E> find(int index) {
        int i = -1;
        for (Node<E> p = head; p != tail; p = p.next, i++) {
            if (i == index) return p;
        }
        return null;
    }


    @Override
    public void insert(int index, E element) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            head.next = new Node<>(head, element, head.next);
            size++;
            return;
        }
        Node<E> prev = find(index - 1);
        prev.next = new Node<>(prev, element, prev.next);
        size++;
    }


    @Override
    public E remove(int index) {
        E ret = null;
        if (index == 0) {
            if (size == 0) {
                return null;
            }
            ret = head.next.value;
            if (size == 1) {
                head.next = null;
                tail.prev = null;
            } else {
                head.next = head.next.next;
                head.next.next.prev = head;
            }
            size--;
        } else if (index < size && index > 0) {
            Node<E> prev = find(index - 1);
            Node<E> curr = prev.next;
            prev.next = curr.next;
            curr.next.prev = prev;
            size--;
            return curr.value;
        }
        return ret;
    }

    @Override
    public E get(int index) {
        Node<E> found = find(index);
        return found == null ? null : found.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Node<E> curr = head;
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
        this.head = new Node<E>(null, null, null);
        this.tail = new Node<E>(null, null, null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = head.next;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
