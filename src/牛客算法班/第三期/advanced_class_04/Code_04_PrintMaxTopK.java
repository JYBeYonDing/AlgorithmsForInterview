package 牛客算法班.第三期.advanced_class_04;

import java.util.Arrays;

/**
 * 堆结构改写
 * 堆的调整代价很低
 *
 * 多个堆
 *
 *
 * 打印N个数组整体最大的Top K
 【题目】
 有N个长度不一的数组， 所有的数组都是有序的， 请从大到小打
 印这N个数组整体最大的前K个数。
 例如， 输入含有N行元素的二维数组可以代表N个一维数组。
 219,405,538,845,971
 148,558
 52,99,348,691
 再输入整数k=5， 则打印：
 Top 5: 971,845,691,558,538
 【要求】
 1． 如果所有数组的元素个数小于K， 则从大到小打印所有的数。
 2． 要求时间复杂度为O(KlogN)。
 */
public class Code_04_PrintMaxTopK {

	/**
	 * 堆节点
	 * 值，哪个数组，数组中位置
	 */
	public static class HeapNode {
		public int value; //
		public int arrNum; //
		public int index; //

		public HeapNode(int value, int arrNum, int index) {
			this.value = value;
			this.arrNum = arrNum;
			this.index = index;
		}
	}

	public static void printTopK(int[][] matrix, int topK) {
		int heapSize = matrix.length;// 堆的大小初始值等于数组的大小
		HeapNode[] heap = new HeapNode[heapSize];
		for (int i = 0; i != heapSize; i++) {
			int index = matrix[i].length - 1;
			heap[i] = new HeapNode(matrix[i][index], i, index);// 取最大值构建堆节点
			heapInsert(heap, i);
		}
		System.out.println("TOP " + topK + " : ");
		for (int i = 0; i < topK; i++) {
			if (heapSize == 0) {
				break;
			}
			System.out.print(heap[0].value + " ");
			if (heap[0].index != 0) {// 如果在原数组中的位置不为0，说明数组中还有值
				heap[0].value = matrix[heap[0].arrNum][--heap[0].index];
			} else {// 否则堆的大小减小
				swap(heap, 0, --heapSize);
			}
			heapify(heap, 0, heapSize);
		}
	}

	public static void heapInsert(HeapNode[] heap, int index) {
		while (index != 0) {
			int parent = (index - 1) / 2;
			if (heap[parent].value < heap[index].value) {
				swap(heap, parent, index);
				index = parent;
			} else {
				break;
			}
		}
	}

	public static void heapify(HeapNode[] heap, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		while (left < heapSize) {
			if (heap[left].value > heap[index].value) {
				largest = left;
			}
			if (right < heapSize && heap[right].value > heap[largest].value) {
				largest = right;
			}
			if (largest != index) {
				swap(heap, largest, index);
			} else {
				break;
			}
			index = largest;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}
	}

	public static void swap(HeapNode[] heap, int index1, int index2) {
		HeapNode tmp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = tmp;
	}

	// 测试用
	public static int[][] generateRandomMatrix(int maxRow, int maxCol,
			int maxValue) {
		if (maxRow < 0 || maxCol < 0) {
			return null;
		}
		int[][] matrix = new int[(int) (Math.random() * maxRow) + 1][];
		for (int i = 0; i != matrix.length; i++) {
			matrix[i] = new int[(int) (Math.random() * maxCol) + 1];
			for (int j = 0; j != matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * maxValue);
			}
			Arrays.sort(matrix[i]);
		}
		return matrix;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = generateRandomMatrix(5, 10, 1000);
		printMatrix(matrix);
		System.out.println("===========================");
		printTopK(matrix, 10);
	}

}
