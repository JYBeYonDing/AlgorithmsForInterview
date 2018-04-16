package 牛客算法班.第三期.basic_class_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * 认识哈希函数和哈希表
 * 哈希函数性质
 * 1. 哈希函数的输入域是无穷大的
 * 2. 输出域是有限的
 * 3. 输入确定，输出确定
 * 4. 输入不一样，也可能出现输出一样，即碰撞
 * 5. 输入值通过哈希函数后均匀分布在输出域中，输出和输入无关，可以打乱输入规律
 *
 * 哈希函数内部有每一个位置的数相对于其他位置的数都是相互独立的。可以任意组合。
 * 可以把一个16位的哈希函数分成高8位和低8位。
 * 高8位记为h1，低8位记为h2。
 * h3 = h1+ 1*h2;
 * h4 = h1+ 2*h2;
 * .............
 * 这些哈希函数之间也是相互独立的。
 *
 * 大数据的题目有很多可以使用哈希函数将数据进行划分，将大数据划分成小数据，每台机器处理小数据，或每个线程处理小数据。
 */
public class Code_05_HashMap {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("zuo", "31");

		System.out.println(map.containsKey("zuo"));
		System.out.println(map.containsKey("chengyun"));
		System.out.println("=========================");

		System.out.println(map.get("zuo"));
		System.out.println(map.get("chengyun"));
		System.out.println("=========================");

		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("=========================");

		System.out.println(map.remove("zuo"));
		System.out.println(map.containsKey("zuo"));
		System.out.println(map.get("zuo"));
		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("=========================");

		map.put("zuo", "31");
		System.out.println(map.get("zuo"));
		map.put("zuo", "32");
		System.out.println(map.get("zuo"));
		System.out.println("=========================");

		map.put("zuo", "31");
		map.put("cheng", "32");
		map.put("yun", "33");

		for (String key : map.keySet()) {
			System.out.println(key);
		}
		System.out.println("=========================");

		for (String values : map.values()) {
			System.out.println(values);
		}
		System.out.println("=========================");

		map.clear();
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");
		map.put("D", "1");
		map.put("E", "2");
		map.put("F", "3");
		map.put("G", "1");
		map.put("H", "2");
		map.put("I", "3");
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("=========================");

		// you can not remove item in map when you use the iterator of map
		// for(Entry<String,String> entry : map.entrySet()){
		// if(!entry.getValue().equals("1")){
		// map.remove(entry.getKey());
		// }
		// }

		// if you want to remove items, collect them first, then remove them by
		// this way.
		List<String> removeKeys = new ArrayList<String>();
		for (Entry<String, String> entry : map.entrySet()) {
			if (!entry.getValue().equals("1")) {
				removeKeys.add(entry.getKey());
			}
		}
		for (String removeKey : removeKeys) {
			map.remove(removeKey);
		}
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("=========================");

	}

}
