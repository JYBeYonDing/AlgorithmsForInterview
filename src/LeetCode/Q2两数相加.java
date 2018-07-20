package LeetCode;

/**
 * Created by 杨杰 on 2018/7/13 22:29.
 */
public class Q2两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int num = l1.val + l2.val;
        int bit = num % 10;
        int carry = num / 10;
        ListNode head = new ListNode(bit);
        ListNode cur = head;
        l1 = l1.next;
        l2 = l2.next;
        while ((l1 != null) && (l2 != null)) {
            num = l1.val + l2.val + carry;
            bit = num % 10;
            carry = num / 10;
            cur.next = new ListNode(bit);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            l2 = l1;
        }
        while (l2 != null) {
            num = l2.val + carry;
            bit = num % 10;
            carry = num / 10;
            cur.next = new ListNode(bit);
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}