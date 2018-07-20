package 牛客算法班.第四期.advanced_class_04;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杨杰 on 2018/7/11 10:27.
 * Java里面实现LRU缓存通常有两种选择，一种是使用LinkedHashMap，一种是自己设计数据结构，使用链表+HashMap
 * 这里使用
 * 链表+HashMap
 * 实现LRU
 */
public class LRUCache_HashMap_List {
    class Node {
        Node pre;
        Node next;
        Integer key;
        Integer val;
        Node(Integer k, Integer v) {
            key = k;
            val = v;
        }
    }

    Map<Integer, Node> map = new HashMap<Integer, Node>();
    // The head (eldest) of the doubly linked list.
    Node head;
    // The tail (youngest) of the doubly linked list.后加入的放在链表尾部。本实现中head和tail一直都为null，方面中间增删节点
    Node tail;
    int cap;// 容量
    public LRUCache_HashMap_List(int capacity) {
        cap = capacity;
        head = new Node(null, null);//本实现中head和tail一直都为null，方面中间增删节点
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }
    public int get(int key) {
        Node n = map.get(key);
        if(n!=null) {
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return n.val;
        }
        return -1;
    }
    public void set(int key, int value) {
        Node n = map.get(key);
        // existed 如果存在则更新
        if(n!=null) {
            n.val = value;
            map.put(key, n);
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return;
        }
        // else {
        if(map.size() == cap) { //如果达到容量则需要删除最老的节点
            Node tmp = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            map.remove(tmp.key);
        }
        // 插入新的节点
        n = new Node(key, value);
        // youngest node append taill
        appendTail(n);
        map.put(key, n);
    }

    /**
     * 将n节点放到队尾
     * @param n
     */
    private void appendTail(Node n) {
        n.next = tail;
        n.pre = tail.pre;
        tail.pre.next = n;
        tail.pre = n;
    }
}