package 牛客算法班.第三期.advanced_class_06;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 杨杰 on 2018/4/18 9:28.
 * <p>
 * 放烽火
 * 相邻山必定可看见
 * 中间间隔的山不大于需要看见的两座山的最小值则可以看见
 * <p>
 * 求能互相看见的山峰有多少对
 * <p>
 * 如果高度都不相等 2*n-3
 * <p>
 * 如果高度有可能相等
 * 先找到一个最大值，往后遍历
 * 有小山峰找大山峰形成一对
 * <p>
 * 单调栈
 *
 * 左神做这道题都用了1小时10分钟
 */
public class 环形山 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(communications(arr));
        }
        in.close();
    }

    /**
     * 环形数组中i的下一个位置
     *
     * @param size 数组大小
     * @param i    当前位置
     * @return 当前位置的下一个位置
     */
    public static int nextIndex(int size, int i) {
        return i < (size - 1) ? (i + 1) : 0;
    }

    /**
     * C(2,k) 得到高度相等的内部山峰,
     *
     * @param n
     * @return
     */
    public static long getInternalSum(int n) {
        return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
    }

    public static class Pair {
        public int value;
        public int times;

        public Pair(int value) {
            this.value = value;
            this.times = 1;
        }
    }


    private static long communications(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;// 最大值位置
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        int value = arr[maxIndex];// 最大值
        int index = nextIndex(size, maxIndex);// 从最大值位置的下一个数开始遍历
        long res = 0L;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(value));// 将最大值的pair仍入到栈中
        while (index != maxIndex) {// 因为是从最大值位置的下一个位置开始遍历，如果再次回到这个位置表示遍历结束
            value = arr[index];
            while (!stack.isEmpty() && stack.peek().value < value) {
                int times = stack.pop().times;
//                res += getInternalSum(times) + times;
//                res += stack.isEmpty() ? 0 : times;
                res += getInternalSum(times) + 2 * times;
            }
            if (!stack.isEmpty() && stack.peek().value == value) {//如果当前栈顶和当前值相等，否则建一个新的pair
                stack.peek().times++;
            } else {
                stack.push(new Pair(value));
            }
            index = nextIndex(size, index);
        }
        // 单独结算的时候
        while (!stack.isEmpty()) {
            int times = stack.pop().times;
            res += getInternalSum(times);// 相同值内部
            if (!stack.isEmpty()) {
                res += times;
                if (stack.size() > 1) {
                    res += times;
                } else {
                    res += stack.peek().times > 1 ? times : 0;
                }
            }
        }
        return res;
    }
}
