package LinkedList;

public interface LinkedList<E> extends Iterable<E>{
    default void addLast(E element) {
        insert(size(), element);
    }

    default void addFirst(E element) {
        insert(0, element);
    }

    default E removeFirst() {
        return isEmpty() ? null : remove(0);
    }

    default E removeLast() {
        return isEmpty() ? null : remove(size() - 1);
    }

    default E getFirst() {
        return isEmpty() ? null : get(0);
    }

    default E getLast() {
        return isEmpty() ? null : get(size() - 1);
    }

    // 检查链表是否为空
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 向尾部添加多个元素
     * @param elements 要添加的元素
     */
    default void add(E... elements){
        for (E element : elements) {
            addLast(element);
        }
    }

    /**
     * 若index out of bounds,则不做任何处理,直接返回
     *
     * @param index   插入的索引位置(from 0 to size())
     * @param element 插入的数据
     */
    void insert(int index, E element);

    /**
     * 删除元素
     *
     * @param index 删除的索引位置(from 0 to size - 1)
     * @return 返回被删除节点存储的数据
     */
    E remove(int index);

    /**
     *
     * @param index 索引
     * @return 指定索引节点上的数据,没有则返回null
     */
    E get(int index);

    // 获取链表的大小
    int size();

    /**
     * 打印链表
     */
    void display();

    /**
     * 清空链表
     */
    void clear();
}
