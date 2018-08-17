package 牛客算法班.第四期.advanced_class_04;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 杨杰 on 2018/7/11 10:18.
 * Java里面实现LRU缓存通常有两种选择，一种是使用LinkedHashMap，一种是自己设计数据结构，使用链表+HashMap
 * 这里用LinkedHashMap实现！！！
 */
public class LRUCache10行<K, V> extends LinkedHashMap<K, V>{
    private int cacheSize;

    public LRUCache10行(int cacheSize) {
        //当参数accessOrder为true时，即会按照访问顺序排序，最近访问的放在最前，最早访问的放在后面
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}