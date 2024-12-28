
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        head.val = 0;
        ListNode result = head;
        while ((l1!=null || l2!=null) && head!=null){
            int x = l1==null?0 : l1.val;
            int y = l2==null?0 : l2.val;
            int sum = x + y + head.val;
            if(sum>=10){
                head.val = sum%10;
                head.next = new ListNode(1);
                head = head.next;
                if(l1!=null) l1 = l1.next;
                if(l2!=null) l2 = l2.next;
            }else{
                head.val = sum;
                if(l1!=null) l1 = l1.next;
                if(l2!=null) l2 = l2.next;
                if(l1!=null || l2!=null) {
                    head.next = new ListNode(0);
                }
                head = head.next;
            }

        }
        return result;
    }
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
