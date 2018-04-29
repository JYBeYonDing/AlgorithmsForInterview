package 牛客算法班.第四期.advanced_class_04;

import java.util.HashMap;

/**
 * (Least Frequently Used)
 * 上一题实现了LRU缓存算法， LFU也是一个著名的缓存算法
 自行了解之后实现LFU中的set 和 get
 要求： 两个方法的时间复杂度都为O(1)

 算法写完之后怎么测？
 在写程序的过程中把注意到的所有边界点记录下来。
 再使用对数器。（加分项）
 */
public class Code_03_LFU {

	/**
	 * 数据节点
	 */
	public static class Node {
		public Integer key;
		public Integer value;
		public Integer times;
		public Node up;
		public Node down;

		public Node(int key, int value, int times) {
			this.key = key;
			this.value = value;
			this.times = times;
		}
	}

	public static class LFUCache {

		/**
		 * 头链表节点
		 */
		public static class NodeList {
			public Node head;
			public Node tail;
			public NodeList last;
			public NodeList next;

			public NodeList(Node node) {
				head = node;
				tail = node;
			}

			/**
			 * 将新节点加到头部
			 * @param newHead
			 */
			public void addNodeFromHead(Node newHead) {
				newHead.down = head;
				head.up = newHead;
				head = newHead;
			}

			public boolean isEmpty() {
				return head == null;
			}

			/**
			 * 删除node节点
			 * @param node
			 */
			public void deleteNode(Node node) {
				if (head == tail) {
					head = null;
					tail = null;
				} else {
					if (node == head) {
						head = node.down;
						head.up = null;
					} else if (node == tail) {
						tail = node.up;
						tail.down = null;
					} else {
						node.up.down = node.down;
						node.down.up = node.up;
					}
				}
				node.up = null;
				node.down = null;
			}
		}

		private int capacity;// 缓存容量
		private int size;
		private HashMap<Integer, Node> records;// key（这里LFU的key是Integer类型）--->Node
		private HashMap<Node, NodeList> heads;// 通过node查看该node属于哪个NodeList
		private NodeList headList;// 头链表

		public LFUCache(int capacity) {
			this.capacity = capacity;
			this.size = 0;
			this.records = new HashMap<>();
			this.heads = new HashMap<>();
			headList = null;
		}

		public void set(int key, int value) {
			if (records.containsKey(key)) {// 如果缓存中有，records中一定有记录
				Node node = records.get(key);
				node.value = value;
				node.times++;
				NodeList curNodeList = heads.get(node);
				move(node, curNodeList);// 词频变化，所以要改变node所在的NodeList
			} else {
				if (size == capacity) {// 如果缓存已满，需要删除一个node
					Node node = headList.tail;
					headList.deleteNode(node);
					modifyHeadList(headList);
					records.remove(node.key);
					heads.remove(node);
					size--;
				}
				Node node = new Node(key, value, 1);
				if (headList == null) {
					headList = new NodeList(node);
				} else {
					if (headList.head.times.equals(node.times)) {// 是否还存在词频为1的链表
						headList.addNodeFromHead(node);
					} else {
						NodeList newList = new NodeList(node);
						newList.next = headList;
						headList.last = newList;
						headList = newList;
					}
				}
				records.put(key, node);
				heads.put(node, headList);
				size++;
			}
		}

		/**
		 * node从老的nodelist中移除，加到词频+1的链表中
		 * @param node
		 * @param oldNodeList
		 */
		private void move(Node node, NodeList oldNodeList) {
			oldNodeList.deleteNode(node);
			NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last
					: oldNodeList;
			NodeList nextList = oldNodeList.next;
			if (nextList == null) {
				NodeList newList = new NodeList(node);
				if (preList != null) {
					preList.next = newList;
				}
				newList.last = preList;
				if (headList == null) {
					headList = newList;
				}
				heads.put(node, newList);
			} else {
				if (nextList.head.times.equals(node.times)) {
					nextList.addNodeFromHead(node);
					heads.put(node, nextList);
				} else {
					NodeList newList = new NodeList(node);
					if (preList != null) {
						preList.next = newList;
					}
					newList.last = preList;
					newList.next = nextList;
					nextList.last = newList;
					if (headList == nextList) {
						headList = newList;
					}
					heads.put(node, newList);
				}
			}
		}

		// return whether delete this head
		/**
		 * 删除节点后判断NodeList是否需要删除
		 * @param nodeList
		 * @return
		 */
		private boolean modifyHeadList(NodeList nodeList) {
			if (nodeList.isEmpty()) {
				if (headList == nodeList) {
					headList = nodeList.next;
					if (headList != null) {
						headList.last = null;
					}
				} else {//大链表之间调整
					nodeList.last.next = nodeList.next;
					if (nodeList.next != null) {
						nodeList.next.last = nodeList.last;
					}
				}
				return true;
			}
			return false;
		}

		public int get(int key) {
			if (!records.containsKey(key)) {
				return -1;// 不存在
			}
			Node node = records.get(key);
			node.times++;
			NodeList curNodeList = heads.get(node);
			move(node, curNodeList);
			return node.value;
		}

	}
}