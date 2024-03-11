
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode tempLast = null;
    public ListNode reverseN(ListNode head, int right){
        if (right == 1) {
            tempLast = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, right - 1);

        head.next.next = head;
        head.next = tempLast;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
