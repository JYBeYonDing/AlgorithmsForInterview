package 牛客算法班.第三期.basic_class_03;

/**
 * 用数组结构实现大小固定的队列和栈
 */
public class Code_01_数组实现栈和队列 {

	public static class ArrayStack {
		private Integer[] arr;
		private Integer index;

		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			index = 0;
		}

		public Integer peek() {
			if (index == 0) {
				return null;
			}
			return arr[index - 1];
		}

		public void push(int obj) {
			if (index == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			arr[index++] = obj;
		}

		public Integer pop() {
			if (index == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[--index];
		}
	}

	public static class ArrayQueue {
		private Integer[] arr;
		private Integer size;// 用于约束first和last，使得first和last解耦，first和last互不影响，否则会很烦
		private Integer first;
		private Integer last;

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			first = 0;
			last = 0;
		}

		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[first];
		}

		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[last] = obj;
			last = last == arr.length - 1 ? 0 : last + 1;
		}

		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int tmp = first;
			first = first == arr.length - 1 ? 0 : first + 1;
			return arr[tmp];
		}
	}

	public static void main(String[] args) {
		
	}

}
