package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/2 18:47.
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class t56链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        // 1.一个快指针，一个慢指针，快指针一次走两个，慢指针一次走一个，找到快指针绕一圈追上慢指针的节点
        // 2.将快指针放到头结点，改为一次走一个，两个指针再次相遇的位置就是入环节点。
        // 如果不是环，及出现null，则返回null
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        } else {
            fast = pHead;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}