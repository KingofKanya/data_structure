package LinkedList.SingleLinkedList;

import LinkedList.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements LinkedList<E> {
    //哨兵节点
    private Node<E> sentinel;
    //length of the LinkedList
    private int size;

    public SingleLinkedList() {
        this.sentinel = new Node<>(null, null);
        this.size = 0;
    }


    @Override
    public void insert(int index, E x) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            sentinel.next = new Node<>(x, sentinel.next);
            size++;
            return;
        }
        Node<E> prev = find(index - 1);
        prev.next = new Node<>(x, prev.next);
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
                sentinel.next = null;
            } else {
                sentinel.next = sentinel.next.next;
            }
            size--;
        } else if (index < size && index > 0) {
            Node<E> prev = find(index - 1);
            Node<E> curr = prev.next;
            prev.next = curr.next;
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
        while (curr.next != null) {
            curr = curr.next;
            sb.append(curr.value).append("-->");
        }
        sb.append("null");
        System.out.println(sb);
    }

    @Override
    public void clear() {
        this.sentinel = new Node<>(null, null);
        this.size = 0;
    }

    /**
     * @param index 查找的索引位置(from 0 to size - 1)
     * @return 返回索引index上的节点,不存在返回null
     */
    private Node<E> find(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> curr = sentinel.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = sentinel.next;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
