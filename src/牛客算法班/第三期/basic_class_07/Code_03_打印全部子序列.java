package 牛客算法班.第三期.basic_class_07;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全部子序列， 包括空字符串
 * 子序列 不是子串
 */
public class Code_03_打印全部子序列 {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);
		char tmp = chs[i];
		chs[i] = 0;
		process(chs, i + 1);
		chs[i] = tmp;
	}

	/**
	 * 传入的res是字符串，因为字符串是final类型的，所以字符串每次改变都会自己新开辟一个空间，不用手动复制
	 * @param str
	 * @param i
	 * @param res
	 */
	public static void printAllSub(char[] str, int i, String res) {
		if (i == str.length) {
			System.out.println(res);
			return;
		}
		printAllSub(str, i + 1, res);
		printAllSub(str, i + 1, res + String.valueOf(str[i]));
	}


	/**
	 * 如果传入res的是可变的引用变量，需要手动拷贝变量
	 * @param chs
	 * @param i
	 * @param res
	 */
	public static void process(char[] chs, int i, List<Character> res) {
		if(i == chs.length) {
			printList(res);
			return;
		}
		List<Character> resKeep = copyList(res);
		resKeep.add(chs[i]);
		process(chs, i+1, resKeep);
		List<Character> resNoInclude = copyList(res);
		process(chs, i+1, resNoInclude);
	}

	public static void printList(List<Character> res) {
		for (Character c : res) {
			System.out.print(c);
		}
		System.out.println();
	}

	public static List<Character> copyList(List<Character> list){
		List<Character> copyList = new ArrayList<>();
		for (Character c : list) {
			copyList.add(c);
		}
		return copyList;
	}


	public static void main(String[] args) {
		String test = "abc";
//		printAllSubsquence(test);
		// 传入的res不能是引用，因为引用的话只是传入地址，指的都是同一个对象
		printAllSub(test.toCharArray(), 0, "");
	}

}
