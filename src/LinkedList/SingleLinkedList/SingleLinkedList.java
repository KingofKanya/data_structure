package LinkedList.SingleLinkedList;

import LinkedList.LinkedList;

public class SingleLinkedList<E> implements LinkedList<E> {
    //哨兵节点
    private Node<E> sentinel;
    //length of the LinkedList
    private int size;

    public SingleLinkedList() {
        this.sentinel = new Node<>(null, null);
        this.size = 0;
    }

    /**
     * 尾部添加多个元素
     *
     * @param first 要添加到链表尾部的第一个整数
     * @param rest  要添加到链表尾部的其他整数（可选）
     */
    @SafeVarargs
    public final void addLast(E first, E... rest) {
        Node<E> sublist = new Node<>(first, null);
        size++;
        Node<E> curr = sublist;
        for (E value : rest) {
            curr.next = new Node<>(value, null);
            curr = curr.next;
            size++;
        }

        Node<E> last = findLast();
        last.next = sublist;
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

    /**
     * 删除元素
     *
     * @param index 删除的索引位置(from 0 to size - 1)
     * @return 返回被删除节点存储的数据
     */
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


    /**
     * 打印链表,没有元素则打印null
     */
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


    /**
     * @return 返回尾节点
     */
    private Node<E> findLast() {
        Node<E> curr = sentinel;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }
}
