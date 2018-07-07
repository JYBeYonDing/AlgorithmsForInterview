package 刷题;

/**
 * Created by 杨杰 on 2018/7/7 21:12.
 */
public class 链表翻转 {
    public static void main(String[] args) {

    }
    /**
     * 问题描述：
     *  链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，若k=3，翻转后
     *  3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
     *
     * 思路：
     *  使用反转链表的思路，将链表的前部分反转，然后将链表的后部分反转，最后将前部分链表的尾节点指向后部分链表的头节点。
     *
     * @param head  链表的头节点
     * @param n     将前n个节点反转，剩下的节点反转
     * @return      翻转后链表的头节点
     */
    public static ListNode rotateLinkList(ListNode head, int n) {
        ListNode leftEnd = head;
        while (n-- > 0) {
            leftEnd = leftEnd.next;
        }
        ListNode head1 = reverse(head, leftEnd);
        ListNode head2 = reverse(leftEnd.next, null);
        if (head2 == null) {
            return head1;
        } else {
            head2.next = head1;
            return head2;
        }
    }

    /**
     * 将以head开头(包含)，end结尾(不包含)的链表反转
     * @return ListNode[0]新的头，ListNode[1]新的尾
     */
    private static ListNode reverse(ListNode head, ListNode end) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
class ListNode {
    int value;
    ListNode next;
}