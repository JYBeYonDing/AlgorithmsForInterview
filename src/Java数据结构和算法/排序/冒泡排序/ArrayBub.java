package Java数据结构和算法.排序.冒泡排序;

public class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort() {
        int out;
        int in;
        for(out = nElems-1;out>0;out--) {
            for(in = 0; in<out; in++) {
                if (a[in] > a[in + 1]) {
                    //实际中，最好将交换操作这段代码直接放到程序中，因为方法的调用也会产生额外的消耗。
                    swap(in, in + 1);
                }
            }
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
