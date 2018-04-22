package 牛客算法班.第三期.advanced_class_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 给定两个单词beginWord和endWord， 还有一本词典是list类型。
 找到所有从beginWord变到endWord的最短转换路径， 变动的规则是：
 1， 一次只能变一个位置的字符
 2， 每一个转换后的word一定要在list中
 3， 初始时list中没有beginWord这个词
 比如
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 返回：
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 注意：
 1， 返回值的类型为List<List<String>>
 2， 如果不存在转化路径请返回空链表（不是null）
 3， 所有的词一定都是相同长度的
 4， 所有词都是小写的a~z
 5， 在list中没有重复的词
 6， beginWord和endWord都不是空字符串或者null
 */
public class Code_06_Word_Ladder {

	public static List<List<String>> findLadders(String beginWord,
			String endWord, List<String> wordList) {
		wordList.add(beginWord);
		HashMap<String, ArrayList<String>> nexts = getNexts(wordList);// 得到所有单词的邻居
		HashMap<String, Integer> distances = getDistances(beginWord, nexts);// 宽度优先遍历得到beginWorld到所有单词的距离
		LinkedList<String> pathList = new LinkedList<>();
		List<List<String>> res = new ArrayList<>();
		getShortestPaths(beginWord, endWord, nexts, distances, pathList, res);
		return res;
	}

	/**
	 * 制作字典中所有单词的邻居 哈希表
	 * @param words 字典
	 * @return 单词，邻居 哈希表
	 */
	public static HashMap<String, ArrayList<String>> getNexts(List<String> words) {
		Set<String> dict = new HashSet<>(words);// 每个单词都放入set中
		HashMap<String, ArrayList<String>> nexts = new HashMap<>();
		for (int i = 0; i < words.size(); i++) {
			nexts.put(words.get(i), new ArrayList<>());// 每一个单词建立一个记录
		}
		for (int i = 0; i < words.size(); i++) {
			nexts.put(words.get(i), getNext(words.get(i), dict));// 每一个单词得到邻居
		}
		return nexts;
	}

	/**
	 * word只变一个字符能够得到后序的哪些单词
	 * @param word 初始单词
	 * @param dict 字典
	 * @return word只变一个字符能到到的单词
	 */
	private static ArrayList<String> getNext(String word, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		char[] chs = word.toCharArray();
		for (char cur = 'a'; cur <= 'z'; cur++) {
			for (int i = 0; i < chs.length; i++) {
				if (chs[i] != cur) {
					char tmp = chs[i];
					chs[i] = cur;// 只变一个字符，判断变一个字符后单词是否在字典中
					if (dict.contains(String.valueOf(chs))) {
						res.add(String.valueOf(chs));
					}
					chs[i] = tmp;// 变回原单词
				}
			}
		}
		return res;
	}

	/**
	 * 计算每个单词距离begin的距离
	 * 使用了宽度优先遍历
	 * @param begin begin Word
	 * @param nexts 记录所有单词的邻居的hashMap
	 * @return
	 */
	public static HashMap<String, Integer> getDistances(String begin,
			HashMap<String, ArrayList<String>> nexts) {
		HashMap<String, Integer> distances = new HashMap<>();// 单词，单词距离begin的距离
		distances.put(begin, 0);
		Queue<String> queue = new LinkedList<String>();// 宽度优先遍历用队列
		queue.add(begin);
		HashSet<String> visited = new HashSet<String>();// 记录是否遍历过，防止重复遍历
		visited.add(begin);// 已经put(begin, 0)过了
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			for (String str : nexts.get(cur)) {// 遍历当前单词cur的邻居
				if (!visited.contains(str)) {// 没被遍历过的单词
					distances.put(str, distances.get(cur) + 1);// 距离+1
					queue.add(str);
					visited.add(str);// 注册
				}
			}
		}
		return distances;
	}

	/**
	 * 搜索最短路径
	 * 深度优先搜索
	 * @param cur 当前单词
	 * @param end 目标单词 不会改变
	 * @param nexts 邻居节点hashMap 不会改变
	 * @param distances 距离hashMap 不会改变
	 * @param solution 存放路径
	 * @param res 结果
	 */
	private static void getShortestPaths(String cur, String end,
			HashMap<String, ArrayList<String>> nexts,
			HashMap<String, Integer> distances, LinkedList<String> solution,
			List<List<String>> res) {
		solution.add(cur);// 收集cur，即走过的路径
		if (end.equals(cur)) {// 如果收到了end
			res.add(new LinkedList<String>(solution));// 将路径拷贝出来一份放到答案中
		} else {
			for (String next : nexts.get(cur)) {
				if (distances.get(next) == distances.get(cur) + 1) {// 只搜索比cur到头节点的距离多1的cur邻居
					getShortestPaths(next, end, nexts, distances, solution, res);
				}
			}
		}
		solution.pollLast();//cur以后的路径都已经搜索完，把cur移除
	}

}
