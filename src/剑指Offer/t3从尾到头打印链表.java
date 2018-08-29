package 剑指Offer;

import java.util.ArrayList;

/**
 * Created by 杨杰 on 2018/6/1 10:54.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class t3从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        ListNode pre = null;
        ListNode cur = listNode;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while (pre != null) {
            result.add(pre.val);
            pre = pre.next;
        }
        return result;
    }


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
