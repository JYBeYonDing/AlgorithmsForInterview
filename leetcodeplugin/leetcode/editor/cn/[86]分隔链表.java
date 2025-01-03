
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p;
            }else {
                p2.next = p;
                p2 = p;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        if (p1 != null) {
            p1.next = dummy2.next;
        }
        return dummy1.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
