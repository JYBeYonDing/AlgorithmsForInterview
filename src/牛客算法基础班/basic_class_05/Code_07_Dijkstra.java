package 牛客算法基础班.basic_class_05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

// no negative weight 非负权重
public class Code_07_Dijkstra {

	public static HashMap<Node, Integer> dijkstra1(Node head) {
		HashMap<Node, Integer> distanceMap = new HashMap<>();
		distanceMap.put(head, 0);
		HashSet<Node> selectedNodes = new HashSet<>();

		Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		while (minNode != null) {
			int distance = distanceMap.get(minNode);
			for (Edge edge : minNode.edges) {
				Node toNode = edge.to;
				if (!distanceMap.containsKey(toNode)) {
					distanceMap.put(toNode, distance + edge.weight);
				}
				distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
			}
			selectedNodes.add(minNode);
			minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		}
		return distanceMap;
	}

	public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
		Node minNode = null;
		int minDistance = Integer.MAX_VALUE;
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
		private HashMap<Node, Integer> heapIndexMap;// 记录节点在堆中的下标，从node查index，后面的节点是-1表示曾经进过堆，已处理过
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
         * @param node
         * @param index
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

	public static HashMap<Node, Integer> dijkstra2(Node head, int size) {
		NodeHeap nodeHeap = new NodeHeap(size);//节点小根堆
		nodeHeap.addOrUpdateOrIgnore(head, 0);
		HashMap<Node, Integer> result = new HashMap<>();
		while (!nodeHeap.isEmpty()) {
			NodeRecord record = nodeHeap.popMinDistance();
			Node cur = record.node;
			int distance = record.distance;
			for (Edge edge : cur.edges) {
				nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
			}
			result.put(cur, distance);
		}
		return result;
	}

}
