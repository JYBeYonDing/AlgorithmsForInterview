package 牛客算法班.第三期.advanced_class_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 用到平衡搜索二叉树
 * // http://lintcode.com/zh-cn/problem/building-outline/
 *给定一个N*3的矩阵， 每一行表示有一座大楼， 一共有N座大楼。
 所有大楼的底部都坐落在x轴上， 每一行的三个值(a,b,c)表示每座大楼
 从(a,0)点开始， 到(b,0)结束， 高度为c.
 输入数据可以保证a<b， 且a,b,c均为正数， 大楼之间可以有重合。
 请输出整体的轮廓线。
 例如
 1,3,3
 2,4,4
 5,6,1
 输出
 1,2,3
 2,4,4
 5,6,1
 */
public class Code_04_建筑轮廓 {

	public static class Node {
		public boolean isUp;// 上or下
		public int posi;// 位置
		public int h;// 高度

		public Node(boolean bORe, int position, int height) {
			isUp = bORe;
			posi = position;
			h = height;
		}
	}

	/**
	 * 比较器
	 */
	public static class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			if (o1.posi != o2.posi) {				
				return o1.posi - o2.posi;
			}
			if (o1.isUp != o2.isUp) {// 相同位置，上的在前，不影响
				return o1.isUp ? -1 : 1;
			}
			return 0;
		}
	}

	public static List<List<Integer>> buildingOutline(int[][] buildings) {
		Node[] nodes = new Node[buildings.length * 2];// 信息数组，一个大楼两信息
		for (int i = 0; i < buildings.length; i++) {
			nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
			nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
		}
		Arrays.sort(nodes, new NodeComparator());// 严格按照位置排序
		TreeMap<Integer, Integer> htMap = new TreeMap<>();// 高度红黑树
		TreeMap<Integer, Integer> pmMap = new TreeMap<>();// 收集出现位置的最大高度<位置，高度>，用于最后生成轮廓
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].isUp) {// 上
				if (!htMap.containsKey(nodes[i].h)) {// 该高度是第一次出现
					htMap.put(nodes[i].h, 1);
				} else {// 该高度不是第一次出现
					htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
				}
			} else {// 下
				if (htMap.containsKey(nodes[i].h)) {
					if (htMap.get(nodes[i].h) == 1) {
						htMap.remove(nodes[i].h);
					} else {
						htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
					}
				}
			}
			if (htMap.isEmpty()) {
				pmMap.put(nodes[i].posi, 0);
			} else {
				pmMap.put(nodes[i].posi, htMap.lastKey());
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		int start = 0;
		int height = 0;
		for (Entry<Integer, Integer> entry : pmMap.entrySet()) {// 遍历每条记录是依次升序取出的
			int curPosition = entry.getKey();
			int curMaxHeight = entry.getValue();
			if (height != curMaxHeight) {// 如果之前的高度不等于当前的高度，要产生轮廓线
				if (height != 0) {
					List<Integer> newRecord = new ArrayList<Integer>();
					newRecord.add(start);
					newRecord.add(curPosition);
					newRecord.add(height);
					res.add(newRecord);
				}
				start = curPosition;
				height = curMaxHeight;
			}
		}
		return res;
	}

}
