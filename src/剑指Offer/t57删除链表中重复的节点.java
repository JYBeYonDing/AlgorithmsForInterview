package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/2 20:11.
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class t57删除链表中重复的节点 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode temp = null;
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (temp==null || cur.val != temp.val) {
                if (cur.next != null && cur.next.val != cur.val) {
                    pre = cur;
                }
                temp = cur;
                cur = cur.next;
                continue;
            }else{// cur.val==temp.val
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return head.next;
    }
}
