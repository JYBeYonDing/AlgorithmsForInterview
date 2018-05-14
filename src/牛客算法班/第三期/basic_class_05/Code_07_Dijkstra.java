package 牛客算法班.第三期.basic_class_05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 * 解决带权重的有向图上的单源最短路径问题
 * 要求所有边非负权重
 *
 * 维持的关键信息是一组节点集合，从源节点s到该集合中每个节点之间的最短路径都已经被找到。
  */
public class Code_07_Dijkstra {

	public static HashMap<Node, Integer> dijkstra1(Node head) {
		HashMap<Node, Integer> distanceMap = new HashMap<>();// 记录结果的hashMap
		distanceMap.put(head, 0);
		HashSet<Node> selectedNodes = new HashSet<>();// 包含在这个集合中的点说明从原点到该点的最短距离已经确定了

		Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);// 从distanceMap中但是没有松弛完毕的点中寻找距离原点最近的点
		while (minNode != null) {
			selectedNodes.add(minNode);// 进行登记，说明确定了从原点到该节点的最短距离
			int distance = distanceMap.get(minNode);//从原点到该点的距离
			for (Edge edge : minNode.edges) {// 遍历从该点出来的所有边，进行松弛操作
				Node toNode = edge.to;
				if (!distanceMap.containsKey(toNode)) {// 将没有访问过的点放入distanceMap中
					distanceMap.put(toNode, distance + edge.weight);
				}
				// 更新到个点的距离，distanceMap.get(toNode)：已知的原点到toNode的距离，distance + edge.weight：通过松弛点绕道到toNode的距离
				distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
			}
			minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		}
		return distanceMap;
	}

	/**
	 * 从distanceMap这些已经有了从原点到这些点的距离估计值但是还没有确定最短距离的点中寻找距离原点最近的点
	 * @param distanceMap 存放原点到这些点距离的键值对
	 * @param touchedNodes 松弛完毕的点，即也是已经确定了从原点到该点最短距离的点
	 * @return
	 */
	public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
		Node minNode = null;
		int minDistance = Integer.MAX_VALUE;
		// 遍历distanceMap中的每个点，从没有确定最短距离的点中选择距原点最近的点
		for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
			Node node = entry.getKey();
			int distance = entry.getValue();
			if (!touchedNodes.contains(node) && distance < minDistance) {
				minNode = node;
				minDistance = distance;
			}
		}
		return minNode;
	}

    /********************************************************************************************
     * 使用堆的方法比较复杂，但是时间复杂度低。
     * ******************************************************************************************
     */

	public static class NodeRecord {
		public Node node;
		public int distance;

		public NodeRecord(Node node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

	public static class NodeHeap {
		private Node[] nodes;// 一个堆，从index查node
		private HashMap<Node, Integer> heapIndexMap;// 记录节点在堆数组中的下标，从node查index，后面的节点是-1表示曾经进过堆，已处理过
		private HashMap<Node, Integer> distanceMap;// 记录node到源节点的距离
		private int heapSize;//堆的大小

		public NodeHeap(int size) {
			nodes = new Node[size];//开辟的堆的空间
			heapIndexMap = new HashMap<>();
			distanceMap = new HashMap<>();
			this.heapSize = 0;
		}

		public boolean isEmpty() {
			return heapSize == 0;
		}

        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        private boolean inHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;// 如果index的值不为-1，表示在数组中，如果==-1表示已处理
        }

        /**
         * 堆中调整时的交换位置
         * 数组nodes中和heapIndexMap中交换时同步更新
         * @param index1
         * @param index2
         */
        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }

		public void addOrUpdateOrIgnore(Node node, int distance) {
			if (inHeap(node)) {
				distanceMap.put(node, Math.min(distanceMap.get(node), distance));// 更新距离
				insertHeapify(node, heapIndexMap.get(node));// 距离变小可能对堆进行调整
			}
			if (!isEntered(node)) {// 如果没有进过堆，将节点加入
				nodes[heapSize] = node;
				heapIndexMap.put(node, heapSize);
				distanceMap.put(node, distance);
				insertHeapify(node, heapSize++);
			}
		}

		public NodeRecord popMinDistance() {
			NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
			swap(0, heapSize - 1);
			heapIndexMap.put(nodes[heapSize - 1], -1);
			distanceMap.remove(nodes[heapSize - 1]);
			nodes[heapSize - 1] = null;
			heapify(0, --heapSize);
			return nodeRecord;
		}

        /**
         * 插入节点 调整堆
         * @param node 节点
         * @param index 在堆数组中的索引
         */
		private void insertHeapify(Node node, int index) {
		    // 以节点到原节点的距离作为标准进行调整
			while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
				swap(index, (index - 1) / 2);
				index = (index - 1) / 2;
			}
		}

        /**
         * 取出节点后对堆进行调整
         * @param index
         * @param size
         */
		private void heapify(int index, int size) {
			int left = index * 2 + 1;
			while (left < size) {
				int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
						? left + 1 : left;
				smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
				if (smallest == index) {
					break;
				}
				swap(smallest, index);
				index = smallest;
				left = index * 2 + 1;
			}
		}

	}

	/**
	 * 用堆来进行选择节点的 dijkstra
	 */
	public static HashMap<Node, Integer> dijkstra2(Node head, int size) {
		NodeHeap nodeHeap = new NodeHeap(size);//节点小根堆
		nodeHeap.addOrUpdateOrIgnore(head, 0);// 在小根堆中首先加入原节点
		HashMap<Node, Integer> result = new HashMap<>();// 记录最短距离
		while (!nodeHeap.isEmpty()) {
			NodeRecord record = nodeHeap.popMinDistance();//取出距离原节点最近的点，此时这个距离估计值变成了确定值
			Node cur = record.node;
			int distance = record.distance;
			for (Edge edge : cur.edges) {// 对这个确定最短距离的点的出边进行松弛
				nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
			}
			result.put(cur, distance);
		}
		return result;
	}

}
