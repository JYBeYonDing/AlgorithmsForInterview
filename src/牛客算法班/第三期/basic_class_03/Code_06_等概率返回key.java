package 牛客算法班.第三期.basic_class_03;

import java.util.HashMap;

/**
 * 设计RandomPool结构
 【题目】 设计一种结构， 在该结构中有如下三个功能：
 insert(key)： 将某个key加入到该结构， 做到不重复加入。
 delete(key)： 将原本在结构中的某个key移除。
 getRandom()： 等概率随机返回结构中的任何一个key。
 【要求】 Insert、delete和getRandom方法的时间复杂度都是O(1)

 需要两个哈希表

 */
public class Code_06_等概率返回key {

	public static class Pool<K> {
		private HashMap<K, Integer> keyIndexMap;
		private HashMap<Integer, K> indexKeyMap;
		private int size;

		public Pool() {
			this.keyIndexMap = new HashMap<K, Integer>();
			this.indexKeyMap = new HashMap<Integer, K>();
			this.size = 0;
		}

		public void insert(K key) {
			if (!this.keyIndexMap.containsKey(key)) {
				this.keyIndexMap.put(key, this.size);
				this.indexKeyMap.put(this.size++, key);
			}
		}

		public void delete(K key) {
			if (this.keyIndexMap.containsKey(key)) {
				int deleteIndex = this.keyIndexMap.get(key);
				int lastIndex = --this.size;
				K lastKey = this.indexKeyMap.get(lastIndex);
				this.keyIndexMap.put(lastKey, deleteIndex);// 在keyIndex中将原本index最后一个的key的index更新
				this.indexKeyMap.put(deleteIndex, lastKey);// 在indexKey中将最后一个index移动到删除的deleteIndex位置处
				this.keyIndexMap.remove(key);// 删除
				this.indexKeyMap.remove(lastIndex);// 删除indexKey中最后一个index对
			}
		}

		public K getRandom() {
			if (this.size == 0) {
				return null;
			}
			int randomIndex = (int) (Math.random() * this.size);// 选择随机的index
			return this.indexKeyMap.get(randomIndex);
		}

	}

	public static void main(String[] args) {
		Pool<String> pool = new Pool<String>();
		pool.insert("zuo");
		pool.insert("cheng");
		pool.insert("yun");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());

	}

}
