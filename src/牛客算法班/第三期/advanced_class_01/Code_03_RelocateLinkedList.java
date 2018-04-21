package 牛客算法班.第三期.advanced_class_01;

/**
 * 给定一个链表list，
 如果：
 list = 1 调整之后1。
 list = 1->2 调整之后1->2
 list = 1->2->3 调整之后1->2->3
 list = 1->2->3->4 调整之后1->3->2->4
 list = 1->2->3->4->5 调整之后1->3->2->4->5
 list = 1->2->3->4->5->6 调整之后1->4->2->5->3->6
 list = 1->2->3->4->5->6->7 调整之后1->4->2->5->3->6->7
 根据上面的规律， 调整一个任意长度的链表。
 */
public class Code_03_RelocateLinkedList {

	public static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void relocate(Node head) {
		if (head == null || head.next == null) {
			return;
		}
		Node mid = head;
		Node right = head.next;
		while (right.next != null && right.next.next != null) {
			mid = mid.next;
			right = right.next.next;
		}
		right = mid.next;
		mid.next = null;
		mergeLR(head, right);
	}

	public static void mergeLR(Node left, Node right) {
		Node next = null;
		while (left.next != null) {
			next = right.next;
			right.next = left.next;
			left.next = right;
			left = right.next;
			right = next;
		}
		left.next = right;
	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = null;
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		relocate(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		relocate(head);
		printLinkedList(head);

	}

}
