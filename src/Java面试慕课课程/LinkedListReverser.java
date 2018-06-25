package Java面试慕课课程;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 杨杰 on 2018/6/22 15:25.
 */
public class LinkedListReverser {
    /**
     * Reverse a linked list.
     * @param head the linked list to reverse.
     * @return head of the reverse linked list.
     */
    Node reverseLinkedList(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    Node reverseLinkedListLoop(Node head) {
        Node newHead = null;
        Node curHead = head;
        // Loop invariant 循环不变式
        // newHead points to the linked list already reversed.
        // curHead points to the linked list not yet reversed.
        while (curHead!=null) {
            // Loop invariant holds.
            Node next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
            // Loop invariant holds.
        }
        return newHead;
    }

    /**
     * 删除节点值为n的节点(自己写的)
     * @param head
     * @param n
     * @return
     */
    Node deleteIf(Node head,int n) {
        Node newHead = null;
        Node newEnd = null;
        Node curNode = head;
        // 循环不变式：从头结点到newEnd的节点已经处理过了，即已经删掉了值为n的几点。
        while (curNode!=null) {
            if (curNode.getValue() != n) {
                if (newHead == null) {
                    newHead = curNode;
                    newEnd = curNode;
                } else {
                    newEnd.setNext(curNode);
                    newEnd = curNode;
                }
            }
            Node temp = curNode.getNext();
            curNode.setNext(null);
            curNode = temp;
        }
        return newHead;
    }

    /**
     * 视频中老师讲的
     * @param head
     * @param value
     * @return
     */
    Node deleteIfEquals(Node head,int value) {
        while (head!=null && head.getValue() == value) {
            head = head.getNext();
        }
        if (head == null) {
            return null;
        }
        Node prev = head;
        // 循环不变式：从头结点到newEnd的节点已经处理过了，即已经删掉了值为n的节点。
        while (prev.getNext()!=null) {
            if (prev.getNext().getValue() == value) {
                // delete it
                prev.setNext(prev.getNext().getNext());
            } else {
                prev = prev.getNext();
            }
        }
        return head;
    }
    public static void main(String[] args) {
        CreateLinkedList c = new CreateLinkedList();
        LinkedListReverser reverser = new LinkedListReverser();
        Node.printLinkedList(reverser.reverseLinkedList(c.createLinkedList(new ArrayList<>())));
        Node.printLinkedList(reverser.reverseLinkedList(c.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList(reverser.reverseLinkedListLoop(c.createLinkedList(Arrays.asList(1, 2, 3, 4, 5))));
        Node.printLinkedList(reverser.deleteIfEquals(c.createLinkedList(Arrays.asList(2,2,2,1,2,3,2,4,2,2,2)),2));
    }
}
