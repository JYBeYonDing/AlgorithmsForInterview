package Java数据结构和算法.排序.插入排序;

public class ArrayIns {
    private long[] a;
    private int nElems;

    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }

    /**
     * 插入排序
     * 稳定
     * 比冒泡排序快一倍，比选择排序略快
     * 对于已经有序或基本有序的数据来说，插入排序要快的多。
     * 如果数据基本有序，插入排序几乎只需要O(N)的时间
     */
    public void insertionSort() {
        int in, out;

        for(out = 1;out<nElems ; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                in--;
            }
            a[in] = temp;
        }
    }
}
