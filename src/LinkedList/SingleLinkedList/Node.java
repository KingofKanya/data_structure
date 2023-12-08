package LinkedList.SingleLinkedList;

//节点类
public class Node <E>{
    //此节点存放的数据
    E value;
    //此节点的下一个节点,若无则为null
    Node<E> next;

    public Node(E value, Node next) {
        this.value = value;
        this.next = next;
    }
}
