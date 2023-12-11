package LinkedList.LeetcodeExercise;

import LeetcodeClass.ListNode;

public class Solution {
    //206. 反转链表
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode reserved = reverseListRecursive(head.next);
        reserved.next = head;
        head.next = null;
        return reserved;
    }

    public ListNode reverseListIterable(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //203. 移除链表元素
    public ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            return removeElementsRecursive(head.next, val);
        } else {
            return new ListNode(val, removeElementsRecursive(head.next, val));
        }
    }

    public ListNode removeElementsIterable(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    //19. 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ret++;
            head = head.next;
        }
        return ret;
    }

    //83. 删除排序链表中的重复元素
    public ListNode deleteDuplicatesIterable(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        pre.next = null;
        return head;
    }

    /*
    head.next = deleteDuplicatesRecursive(head.next);
    return head;
    这两句写的妙,我自己原本的写法是创建个新的ListNode
     */
    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            return deleteDuplicatesRecursive(head.next.next);
        } else {
            head.next = deleteDuplicatesRecursive(head.next);
            return head;
        }
    }

    //82. 删除排序链表中的重复元素 II
    public ListNode deleteDuplicatesRecursive2(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val != head.next.val) {
            head.next = deleteDuplicatesRecursive2(head.next);
            return head;
        } else {
            ListNode cur = head;
            while (cur != null && cur.val == head.val) cur = cur.next;
            return deleteDuplicatesRecursive2(cur);
        }
    }

    public ListNode deleteDuplicatesIterative2(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && prev.next.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }


    //21. 合并两个有序链表
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val) {
            return new ListNode(list2.val, mergeTwoListsRecursive(list1, list2.next));
        }
        return new ListNode(list1.val, mergeTwoListsRecursive(list1.next, list2));
    }

    public ListNode mergeTwoListsIterable(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if(list1.val > list2.val){
                cur.next = list2;
                list2 = list2.next;
            }else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        cur.next = (list1 == null) ? list2 : list1;
        return dummy.next;
    }
}
