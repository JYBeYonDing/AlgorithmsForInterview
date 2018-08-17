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
public class LRUCache_HashMap_List改进<K,V> {
    // HashMap
    Map<K, Node<K,V>> map = new HashMap<>();// 存放key，Node，相当于缓存存放位置，Node之间有链表连接

    // 链表
    // 本实现中head和tail一直都为null，方便中间增删节点
    // The head (eldest) of the doubly linked list.
    Node<K,V> head;
    // The tail (youngest) of the doubly linked list.后加入的放在链表尾部。
    Node<K,V> tail;

    int cap;// 容量
    public LRUCache_HashMap_List改进(int capacity) {
        cap = capacity;
        head = new Node(null, null);//本实现中head和tail一直都为null，方便中间增删节点
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 根据key得到value
     * @param key key
     * @return 有node.value； 无null
     */
    public V get(K key) {
        Node<K,V> n = map.get(key);
        if(n!=null) {
            n.pre.next = n.next;// 移除n节点
            n.next.pre = n.pre;
            appendTail(n);// 加入到链表尾部，map不用修改
            return n.val;
        }
        return null;
    }

    /**
     * 存放键值对，key，value
     * @param key key
     * @param value value
     */
    public void set(K key, V value) {
        Node<K,V> n = map.get(key);//判断缓存中是否存在
        // 如果存在则更新
        if(n!=null) {
            n.val = value;
            map.put(key, n);
            n.pre.next = n.next;//从链表中去除
            n.next.pre = n.pre;
            appendTail(n);//加入到链表的尾部
            return;
        }
        // 如果不存在则插入同时判断缓存是否满
        if(map.size() == cap) { //如果达到容量则需要删除最老的节点
            Node<K,V> tmp = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            map.remove(tmp.key);// 从map中去除
        }
        // 插入新的节点
        n = new Node<K,V>(key, value);
        // youngest node append taill
        appendTail(n);
        map.put(key, n);
    }

    /**
     * 将n节点放到队尾
     * @param n
     */
    private void appendTail(Node<K,V> n) {
        n.next = tail;
        n.pre = tail.pre;
        tail.pre.next = n;
        tail.pre = n;
    }



    /**
     * 节点内部类
     */
    class Node<K,V> {
        Node pre;
        Node next;
        K key;
        V val;
        Node(K k, V v) {
            key = k;
            val = v;
        }
    }

}