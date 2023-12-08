package LinkedList.CircularLinkedList;

import LinkedList.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<E> implements LinkedList<E> {
    private final Node<E> sentinel = new Node<>(null, null, null);
    private int size;

    public CircularLinkedList() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        this.size = 0;
    }

    /**
     * @param index 待查找节点索引
     * @return 返回指定索引节点, 不存在则返回null
     */
    private Node<E> find(int index) {
        if (isEmpty()) return null;
        int i = 0;
        for (Node<E> p = sentinel.next; p != sentinel; p = p.next, i++) {
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
            sentinel.next = new Node<>(sentinel, element, sentinel.next);
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
            ret = sentinel.next.value;
            if (size == 1) {
                sentinel.next = sentinel;
                sentinel.prev = sentinel;
            } else {
                sentinel.next = sentinel.next.next;
                sentinel.next.next.prev = sentinel;
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
        Node<E> curr = sentinel;
        StringBuilder sb = new StringBuilder();
        sb.append("sentinel<-->");
        if(!isEmpty()){
            while (curr.next != sentinel) {
                curr = curr.next;
                sb.append(curr.value).append("<-->");
            }
        }
        sb.append("sentinel");
        System.out.println(sb);
    }

    @Override
    public void clear() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        this.size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> curr = sentinel;

            @Override
            public boolean hasNext() {
                return curr != sentinel;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }
}
