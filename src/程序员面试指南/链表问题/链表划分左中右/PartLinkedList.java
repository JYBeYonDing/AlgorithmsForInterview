package 程序员面试指南.链表问题.链表划分左中右;

public class PartLinkedList {
    private static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition2(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        Node leftHead = null;
        Node midHead = null;
        Node rightHead = null;

        Node left=null;
        Node mid=null;
        Node right=null;
        while (head != null) {
            if (head.value < pivot) {
                if (left == null) {
                    left = head;
                    leftHead = head;
                } else {
                    left.next = head;
                    left = left.next;
                }
            }else if (head.value == pivot) {
                if (mid == null) {
                    mid = head;
                    midHead = mid;
                } else {
                    mid.next = head;
                    mid = mid.next;
                }
            }else {
                if (right == null) {
                    right = head;
                    rightHead = right;
                } else {
                    right.next = head;
                    right = right.next;
                }
            }

            head = head.next;
        }


        //将每一段的最后一个节点的next属性值设为null
        if (left != null) {
            left.next = null;
        }
        if (mid != null) {
            mid.next = null;
        }
        if (right != null) {
            right.next = null;
        }

        // 将各段进行连接
        if (left != null) {
            left.next = midHead;
            mid = (mid!=null)? mid:left;
        }
        if (mid != null) {
            mid.next = rightHead;
        }

        return (leftHead != null) ? leftHead : (midHead != null) ? midHead : rightHead;

    }


    public static Node listPartition1(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }

        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for(;i!=nodeArr.length;i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }

        arrPartiion(nodeArr, pivot);
        for(i=1;i!=nodeArr.length;i++) {
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    private static void arrPartiion(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    private static void swap(Node[] nodeArr, int i, int index) {
        Node tmp = nodeArr[i];
        nodeArr[i] = nodeArr[index];
        nodeArr[index] = tmp;
    }

    /**
     *
     */

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
         head1 = listPartition1(head1, 4);
//        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }


    public static Node listPartition22(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node bH = null; // big head
        Node bT = null; // big tail
        Node next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // small and equal reconnect
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // all reconnect
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

}
