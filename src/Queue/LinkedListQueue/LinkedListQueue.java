package Queue.LinkedListQueue;

import Queue.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 单向环形带sentinel链表方式来实现queue
 *
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {
    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = new Node<E>(null, null);
    private Node<E> tail = head;
    private int size = 0;
    private int capacity = Integer.MAX_VALUE;
    //实例初始化块（Instance Initialization Block）
    {
        tail.next = head;
    }

    public LinkedListQueue() {
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean offer(E value) {
        if(isFull()) return false;
        Node<E> added = new Node<>(value, head);
        size++;
        tail.next = added;
        tail = added;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        size--;
        head = head.next;
        tail.next = head;
        return head.value;
    }

    @Override
    public E peek() {
        if(isEmpty()) return null;
        return head.next.value;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder();
        if(!isEmpty()) {
            for (E e : this) {
                sb.append(e).append("-->");
            }
        }
        sb.append("null");
        System.out.println(sb);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = head.next;
            @Override
            public boolean hasNext() {
                return current != head;
            }

            @Override
            public E next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                E ret = current.value;
                current = current.next;
                return ret;
            }
        };
    }
}
