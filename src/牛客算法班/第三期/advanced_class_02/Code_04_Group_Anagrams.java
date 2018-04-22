package 牛客算法班.第三期.advanced_class_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 如果str1和str2包含的字符种类一样， 并且每种字符的个数也
 一样， 那么str1和str2算作变形词。
 给定一个字符类型的数组， 请把变形词分组。 比如
 输入：
 ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出：
 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 注意： 所有的字符都是小写。
 */
public class Code_04_Group_Anagrams {

	/**
	 * 方法一需要排序 复杂度大
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams1(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] chs = str.toCharArray();
			Arrays.sort(chs);
			String key = String.valueOf(chs);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		List<List<String>> res = new ArrayList<List<String>>();
		for (List<String> list : map.values()) {
			res.add(list);
		}
		return res;
	}

	/**
	 * 方法2不用排序，复杂度低
	 * 因为注意到所有的字符都是小写。 可以使用字符穷举。根据数据状况的本身进行代码的优化。
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams2(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			int[] record = new int[26];
			for (char cha : str.toCharArray()) {
				record[cha - 'a']++;
			}
			StringBuilder builder = new StringBuilder();
			for (int value : record) {
				builder.append(String.valueOf(value)).append("_");
			}
			String key = builder.toString();
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		List<List<String>> res = new ArrayList<List<String>>();
		for (List<String> list : map.values()) {
			res.add(list);
		}
		return res;
	}

}
