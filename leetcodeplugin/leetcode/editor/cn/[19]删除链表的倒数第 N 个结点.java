
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode p2 = dummy;

        while (n >= 0) {
            p = p.next;
            n--;
        }
        while (p != null) {
            p2 = p2.next;
            p = p.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
