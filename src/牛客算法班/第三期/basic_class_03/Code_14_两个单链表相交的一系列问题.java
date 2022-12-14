package 牛客算法班.第三期.basic_class_03;

/**
 * 两个单链表相交的一系列问题
 【题目】 在本题中， 单链表可能有环， 也可能无环。 给定两个
 单链表的头节点 head1和head2， 这两个链表可能相交， 也可能
 不相交。 请实现一个函数， 如果两个链表相交， 请返回相交的
 第一个节点； 如果不相交， 返回null 即可。 要求： 如果链表1
 的长度为N， 链表2的长度为M， 时间复杂度请达到 O(N+M)， 额外
 空间复杂度请达到O(1)。

 问题1：怎么判断单链表有环还是无环（返回第一个入环的节点）
 问题2：无环单链表第一个相交的节点
 问题3：有环单链表第一个相交的节点
 */
public class Code_14_两个单链表相交的一系列问题 {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 返回链表相交的节点
	 */
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {// 两个都无环
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {// 两个都有环
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}

	/**
	 * 判断有环无环，有环返回第一个入环的节点，无环返回null
	 * 可以用hashSet做
	 * 这里不用hashSet
	 * 准备一个快指针（一次走两步）和一个慢指针（一次走一步）
	 * 快指针追上慢指针后，快指针到头节点，变成一次走一步，再和慢指针相遇的点就是第一个入环的节点
	 * @param head
	 * @return
	 */
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next; // n1 -> slow
		Node n2 = head.next.next; // n2 -> fast
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head; // n2 -> walk again from head
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}

	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {// 如果两个尾节点不同，说明不相交
			return null;
		}

		// 如果尾节点相等，说明相交
		cur1 = n > 0 ? head1 : head2;// cur1选择为长链
		cur2 = cur1 == head1 ? head2 : head1;// cur2为另一条链
		n = Math.abs(n);
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {// 不相等则继续向下，直到找到第一个相等的点
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	/**
	 *
	 * @param head1
	 * @param loop1 第一个链表的入环点
	 * @param head2
	 * @param loop2 第二个链表的入环点
	 * @return 返回相交的第一个点 或者 null
	 */
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) {
			// 如果第一个入环点相同，则可能在这个点之前就相交了，则以这个入环点为链表的结尾找第一个相交的点
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {// 如果第一个入环点不同
			cur1 = loop1.next;
			while (cur1 != loop1) {// cur1转一圈看看是不是会和loop2重合，如果不重合，说明两个不相交
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}

}
