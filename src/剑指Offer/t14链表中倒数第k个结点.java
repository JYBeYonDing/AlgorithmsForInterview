package 剑指Offer;

/**
 * Created by James on 2018/8/27 22:51.
 *
 * 注意代码的鲁棒性！！！
 */
public class t14链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k<=0) {
            return null;
        }
        ListNode n2 = head;
        for (int i = 1; i < k; i++) {
            n2 = n2.next;
            if (n2 == null) {
                return null;//k>链表长度，返回null
            }
        }
        while (n2.next != null) {
            head = head.next;
            n2 = n2.next;
        }
        return head;
    }



    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
