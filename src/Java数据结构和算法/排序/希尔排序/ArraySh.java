package Java数据结构和算法.排序.希尔排序;

/**
 * 希尔排序
 * 在最坏情况下的执行效率和在平均情况下的执行效率相比没有差很多。
 * 而快速排序在最坏情况下的执行效率会非常差
 *
 * 间隔序列中的数字互质通常被认为很重要。
 */
public class ArraySh {
    private long[] theArray;
    private int nElems;

    public ArraySh(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for(outer=h;outer<nElems;outer++) {
                temp = theArray[outer];
                inner = outer;
                while (inner > h - 1 && theArray[inner - h] >= temp) {
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                }
                theArray[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}
