
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) {
 * this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a = head;
        ListNode b = head;

        int l = k;
        while (l > 0 && b != null) {
            b = b.next;
            l--;
        }
        if (b == null && l > 0) {
            return a;
        }

//        for (int i = 0; i < k; i++) {
//            // 不足 k 个，不需要反转，base case
//            if (b == null) return head;
//            b = b.next;
//        }

        // 反转前k个
        ListNode newHead = reverse(a, b);

        a.next = reverseKGroup(b, k);

        return newHead;

    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode now = a;
        ListNode next = a;
        while (now != b) {
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;

        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
