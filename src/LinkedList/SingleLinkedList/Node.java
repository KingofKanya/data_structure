package LinkedList.SingleLinkedList;

//节点类
public class Node {
    //此节点存放的数据
    public int value;
    //此节点的下一个节点,若无则为null
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
