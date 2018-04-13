package 牛客算法基础班.basic_class_04;

import java.util.HashMap;
import java.util.List;

public class Code_09_并查集 {

	public static class Node {
		// whatever you like
		// 任何结构都行
	}

	public static class DisjointSets {
		public HashMap<Node, Node> fatherMap;// key的父节点是value
		public HashMap<Node, Integer> sizeMap; // 代表节点 的 所属集合的大小， 不是代表节点的值无意义

		public DisjointSets() {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
		}

		/**
		 * 初始化 并查集
		 * 把所有节点传入，每个node各自成一个集合
		 * @param nodes
		 */
		public void makeSets(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		public Node findFather(Node n) {
			Node father = fatherMap.get(n);
			// 递归行为用于将查找过程中的节点直接指向 代表节点
			if (father != n) {
				father = findFather(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) {
				int aSetSize = sizeMap.get(aFather);
				int bSetSize = sizeMap.get(bFather);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aFather, bFather);
					sizeMap.put(bFather, aSetSize + bSetSize);
				} else {
					fatherMap.put(bFather, aFather);
					sizeMap.put(aFather, aSetSize + bSetSize);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
