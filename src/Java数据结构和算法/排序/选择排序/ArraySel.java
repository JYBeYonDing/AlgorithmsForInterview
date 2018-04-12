package Java数据结构和算法.排序.选择排序;

/**
 * 选择排序改进了冒泡排序，将必要的交换次数从O(N^2)减少到O(N).比较次数仍然保持O(N^2)
 * 一轮进行n-1次比较，交换1次
 */
public class ArraySel {
    private long[] a;
    private int nElems;

    public ArraySel(int max) {
        a = new long[max];
        nElems = 0;
    }

    /**
     * 选择排序
     * 不稳定
     */
    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
            }
            swap(out, min);
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
