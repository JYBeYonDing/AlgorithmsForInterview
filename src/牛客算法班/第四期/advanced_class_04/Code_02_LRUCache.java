package 牛客算法班.第四期.advanced_class_04;

import java.util.HashMap;

/**
 * 设计可以变更的缓存结构（LRU）Least Recently Used的缩写，即最近最少使用
 【题目】
 设计一种缓存结构， 该结构在构造时确定大小， 假设大小为K， 并有两个功能：
 set(key,value)： 将记录(key,value)插入该结构。
 get(key)： 返回key对应的value值。
 【要求】
 1． set和get方法的时间复杂度为O(1)。
 2． 某个key的set或get操作一旦发生， 认为这个key的记录成了最经常使用的。
 3． 当缓存的大小超过K时， 移除最不经常使用的记录， 即set或get最久远的。
 【举例】
 假设缓存结构的实例是cache， 大小为3， 并依次发生如下行为：
 1． cache.set("A",1)。 最经常使用的记录为("A",1)。
 2． cache.set("B",2)。 最经常使用的记录为("B",2)， ("A",1)变为最不经常的。
 3． cache.set("C",3)。 最经常使用的记录为("C",2)， ("A",1)还是最不经常的。
 4． cache.get("A")。 最经常使用的记录为("A",1)， ("B",2)变为最不经常的。
 5． cache.set("D",4)。 大小超过了3， 所以移除此时最不经常使用的记录("B",2)，
 加入记录 ("D",4)， 并且为最经常使用的记录， 然后("C",2)变为最不经常使用的记录


 数据结构的设计题，基础结构都是比较简单的，但是怎么配合使用是考查的重点。
 思路：哈希表+双向链表
 难点：coding处理边界

 ！！！Java里面实现LRU缓存通常有两种选择，一种是使用LinkedHashMap，一种是自己设计数据结构，使用链表+HashMap

 面试套路：
 面试过程中一道题的时间一般不会超过30分钟。
 面试中碰到见过的题一定也要演的没做过，和面试官积极讨论。憋了半天找到了思路。但是一定要演的像！！！

 */
public class Code_02_LRUCache {

	/**
	 * 节点，用于双向链表
	 * @param <V>
	 */
	public static class Node<V> {
		public V value;
		public Node<V> last;
		public Node<V> next;

		public Node(V value) {
			this.value = value;
		}
	}

	/**
	 * 自己定制的双端链表
	 * @param <V>
	 */
	public static class NodeDoubleLinkedList<V> {
		private Node<V> head;
		private Node<V> tail;

		public NodeDoubleLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void addNode(Node<V> newNode) {
			if (newNode == null) {
				return;
			}
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
			} else {
				this.tail.next = newNode;
				newNode.last = this.tail;
				this.tail = newNode;
			}
		}

		/**
		 * node 一定在双向链表中，使用了这个节点，将该节点移动到尾部
		 * 考查思维严谨性，熟练度
		 * @param node
		 */
		public void moveNodeToTail(Node<V> node) {
			if (this.tail == node) {
				return;
			}
			if (this.head == node) {
				this.head = node.next;
				this.head.last = null;
			} else {
				node.last.next = node.next;
				node.next.last = node.last;
			}
			node.last = this.tail;
			node.next = null;
			this.tail.next = node;
			this.tail = node;
		}

		/**
		 * 移除头部并返回
		 * @return 移除的头部
		 */
		public Node<V> removeHead() {
			if (this.head == null) {
				return null;
			}
			Node<V> res = this.head;
			if (this.head == this.tail) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = res.next;
				res.next = null;
				this.head.last = null;
			}
			return res;
		}

	}

	public static class MyCache<K, V> {
		private HashMap<K, Node<V>> keyNodeMap;// 这里使用了两张map表，也可以在node中封装key和value，这样只需要一张表，一张表的效率要高一点
		private HashMap<Node<V>, K> nodeKeyMap;
		private NodeDoubleLinkedList<V> nodeList;
		private int capacity;

		public MyCache(int capacity) {
			if (capacity < 1) {
				throw new RuntimeException("should be more than 0.");
			}
			this.keyNodeMap = new HashMap<K, Node<V>>();
			this.nodeKeyMap = new HashMap<Node<V>, K>();
			this.nodeList = new NodeDoubleLinkedList<V>();
			this.capacity = capacity;
		}

		public V get(K key) {
			if (this.keyNodeMap.containsKey(key)) {
				Node<V> res = this.keyNodeMap.get(key);
				this.nodeList.moveNodeToTail(res);
				return res.value;
			}
			return null;
		}

		public void set(K key, V value) {
			if (this.keyNodeMap.containsKey(key)) {
				Node<V> node = this.keyNodeMap.get(key);
				node.value = value;
				this.nodeList.moveNodeToTail(node);
			} else {
				Node<V> newNode = new Node<V>(value);
				this.keyNodeMap.put(key, newNode);
				this.nodeKeyMap.put(newNode, key);
				this.nodeList.addNode(newNode);
				if (this.keyNodeMap.size() == this.capacity + 1) {
					this.removeMostUnusedCache();
				}
			}
		}

		private void removeMostUnusedCache() {
			Node<V> removeNode = this.nodeList.removeHead();
			K removeKey = this.nodeKeyMap.get(removeNode);
			this.nodeKeyMap.remove(removeNode);
			this.keyNodeMap.remove(removeKey);
		}

	}

	public static void main(String[] args) {
		MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
		testCache.set("A", 1);
		testCache.set("B", 2);
		testCache.set("C", 3);
		System.out.println(testCache.get("B"));
		System.out.println(testCache.get("A"));
		testCache.set("D", 4);
		System.out.println(testCache.get("D"));
		System.out.println(testCache.get("C"));

	}

}
