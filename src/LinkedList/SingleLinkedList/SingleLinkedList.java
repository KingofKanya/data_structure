package LinkedList.SingleLinkedList;

public class SingleLinkedList {
    //哨兵节点,存储-1,可以为任意初始值,并不会使用到
    private final Node sentinel = new Node(-1, null);
    //length of the LinkedList
    private int size = 0;

    /**
     * @return 返回尾节点
     */
    private Node findLast() {
        Node curr = sentinel;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }


    /**
     * @param index 查找的索引位置(from 0 to size)
     * @return 返回索引index上的节点
     */
    private Node find(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("index out of bounds");
        }
        Node curr = sentinel.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    /**
     * @param x 插入元素
     */
    public void addFirst(int x) {
        sentinel.next = new Node(x, sentinel.next);
        size++;
    }


    /**
     * @param x 插入的元素
     */
    public void addLast(int x) {
        findLast().next = new Node(x, null);
        size++;
    }

    /**
     * 尾部添加多个元素
     *
     * @param first 要添加到链表尾部的第一个整数
     * @param rest  要添加到链表尾部的其他整数（可选）
     */
    public void addLast(int first, int... rest) {
        Node sublist = new Node(first, null);
        size++;
        Node curr = sublist;
        for (int value : rest) {
            curr.next = new Node(value, null);
            curr = curr.next;
            size++;
        }

        Node last = findLast();
        last.next = sublist;
    }


    /**
     * @param index 插入的索引位置(from 0 to size + 1)
     * @param x     插入的数据
     */
    public void insert(int index, int x) {
        if (index < 0 || index > size + 1) {
            throw new RuntimeException("index out of bounds");
        }
        if (index == 0) {
            sentinel.next = new Node(x, sentinel.next);
            return;
        }
        Node prev = find(index - 1);
        prev.next = new Node(x, prev.next);
        size++;
    }

    /**
     * 删除元素
     *
     * @param index 删除的索引位置(from 0 to size - 1)
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            Node prev = find(index - 1);
            Node curr = prev.next;
            prev.next = curr.next;
            size--;
        }
    }

    /**
     * 删除头节点
     */
    public void removeFirst() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            sentinel.next = null;
        } else {
            sentinel.next = sentinel.next.next;
        }
        size--;
    }

    /**
     * 打印链表,没有元素则打印null
     */
    public void display() {
        Node curr = sentinel;
        StringBuilder sb = new StringBuilder();
        while (curr.next != null) {
            curr = curr.next;
            sb.append(curr.value).append("-->");
        }
        sb.append("null");
        System.out.println(sb);
    }
}
