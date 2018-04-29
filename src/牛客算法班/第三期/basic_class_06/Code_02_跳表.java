package 牛客算法班.第三期.basic_class_06;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 跳表好实现
 * 和红黑树功能差不过
 * rides中用到的也是跳表结构
 * 跳表最左边可以看成是系统最小，系统最小的层数是所有层数中的最大值。
 *
 * 从最高层开始，如果下一个值大，从当前点往下走，但是如果到达随机产生的层数，建完该层的点之后才往下走。
 *
 * 点的数量从下层往上层依次减少。
 *
 *
 */
public class Code_02_跳表 {

	/**
	 * 跳表节点
	 */
	public static class SkipListNode {
		public Integer value;
		public ArrayList<SkipListNode> nextNodes;// 长度代表层数

		public SkipListNode(Integer value) {
			this.value = value;
			nextNodes = new ArrayList<SkipListNode>();
		}
	}

	public static class SkipListIterator implements Iterator<Integer> {
		SkipList list;
		SkipListNode current;

		public SkipListIterator(SkipList list) {
			this.list = list;
			this.current = list.getHead();
		}

		public boolean hasNext() {
			return current.nextNodes.get(0) != null;
		}

		public Integer next() {
			current = current.nextNodes.get(0);
			return current.value;
		}
	}

	public static class SkipList {
		private SkipListNode head;//头结点是个无效的node
		private int maxLevel;//所有数据的最大层
		private int size;// 有多少key
		private static final double PROBABILITY = 0.5;//产生1的概率

		public SkipList() {
			size = 0;
			maxLevel = 0;
			head = new SkipListNode(null);
			head.nextNodes.add(null);
		}

		public SkipListNode getHead() {
			return head;
		}

		public void add(Integer newValue) {
			if (!contains(newValue)) {
				size++;
				int level = 0;
				while (Math.random() < PROBABILITY) {
					level++;
				}
				while (level > maxLevel) {// 如果这个level大于了之前的最大level，head扩充层数
					head.nextNodes.add(null);
					maxLevel++;
				}
				SkipListNode newNode = new SkipListNode(newValue);
				SkipListNode current = head;// 从头开始找
				int levelAll = maxLevel;
				do {// 原来这里代码有问题，不能从第level开始找，应该从最高层开始找，现在改了不知道对不对
					current = findNext(newValue, current, levelAll);// 找到level层上小于newValue的最大的节点
					if (level >= levelAll) {
						// 在current和current的next中间插入newNode
						newNode.nextNodes.add(0, current.nextNodes.get(level));//始终加在0位置上，原有的数会往后移
						current.nextNodes.set(level, newNode);
						level--;
					}
				} while (levelAll-- > 0);
			}
		}

		public void delete(Integer deleteValue) {
			if (contains(deleteValue)) {
				SkipListNode deleteNode = find(deleteValue);
				size--;
				int level = maxLevel;
				SkipListNode current = head;
				do {
					current = findNext(deleteNode.value, current, level);
					if (deleteNode.nextNodes.size() > level) {
						current.nextNodes.set(level, deleteNode.nextNodes.get(level));
					}
				} while (level-- > 0);
			}
		}

		// Returns the skiplist node with greatest value <= e
		private SkipListNode find(Integer e) {
			return find(e, head, maxLevel);
		}

		// Returns the skiplist node with greatest value <= e
		// Starts at node start and level
		private SkipListNode find(Integer e, SkipListNode current, int level) {
			do {
				current = findNext(e, current, level);
			} while (level-- > 0);
			return current;
		}

		// Returns the node at a given level with highest value less than e
		/**
		 * 从current节点开始，找到level层上小于e的最大节点
		 */
		private SkipListNode findNext(Integer e, SkipListNode current, int level) {
			SkipListNode next = current.nextNodes.get(level);// 当前节点level层的next
			while (next != null) {
				Integer value = next.value;
				if (lessThan(e, value)) { // e < value next大于要找的节点，找到了
					break;
				}
				current = next;
				next = current.nextNodes.get(level);
			}
			return current;
		}

		public int size() {
			return size;
		}

		public boolean contains(Integer value) {
			SkipListNode node = find(value);
			return node != null && node.value != null && equalTo(node.value, value);
		}

		public Iterator<Integer> iterator() {
			return new SkipListIterator(this);
		}

		/******************************************************************************
		 * Utility Functions *
		 ******************************************************************************/

		private boolean lessThan(Integer a, Integer b) {
			return a.compareTo(b) < 0;
		}

		private boolean equalTo(Integer a, Integer b) {
			return a.compareTo(b) == 0;
		}

	}

	public static void main(String[] args) {

	}

}
