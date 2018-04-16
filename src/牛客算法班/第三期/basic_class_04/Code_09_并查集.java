package 牛客算法班.第三期.basic_class_04;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集解决的问题需要一次性获取所有样本，不能处理流这类的问题
 *
 * isSameSet(A,B)
 * union(A,B)
 * 实现上述功能也可以是其他结构，但是效率没有并查集高
 *
 * 当 查询次数+合并次数 达到N或以上时，单次的平均时间复杂度是O(1)
 * 证明：很复杂，不需要掌握，算法导论第21章
 */
public class Code_09_并查集 {

	public static class Node {
		// whatever you like
		// 任何结构都行
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap;// key的父节点是value
		public HashMap<Node, Integer> sizeMap; // 代表节点 的 所属集合的大小， 不是代表节点的值无意义

		public UnionFindSet() {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
		}

		/**
		 * 初始化 并查集
		 * 把所有节点传入，首先每个node需要各自成一个集合
		 * @param nodes 所有节点
		 */
		public void makeSets(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);// 父节点都是本身
				sizeMap.put(node, 1);// 每个集合大小为1
			}
		}

		/**
		 * 找到所在集合的代表，这个代表节点代表这个集合
		 * 在查找的过程中将沿途的查找路径的长链打平
		 * @param n 节点
		 * @return 集合的代表节点
		 */
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

		/**
		 * 合并集合
		 * 元素少的集合挂在元素多的集合底下
		 * @param a 节点
		 * @param b 节点
		 */
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);// a的代表节点
			Node bFather = findFather(b);// b的代表节点
			if (aFather != bFather) {
				int aSetSize = sizeMap.get(aFather);
				int bSetSize = sizeMap.get(bFather);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aFather, bFather);// a代表挂在b代表底下
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
