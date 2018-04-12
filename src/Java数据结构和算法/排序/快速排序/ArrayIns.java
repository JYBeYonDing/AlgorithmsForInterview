package Java数据结构和算法.排序.快速排序;

public class ArrayIns {
    private long[] theArray;
    private int nElems;

    public ArrayIns(long[] theArray) {
        this.theArray = theArray;
        nElems = theArray.length;
    }

    /**
     * 快速排序
     * 理想情况下应该选择被排序的数据项的中值数据项作为枢纽
     * 当数据是有序或者是逆序时，从数组的一端选择数据项不是好方法，退化到O(N^2)而且递归调用层次变多，可能溢出
     *
     * 改进：三数据项取中方法：找到数组中第一个，最后一个和中间位置数据项的居中数据作为数据项的枢纽。
     */
    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    private void recQuickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            long pivot = theArray[right];//选择最右端的数据项作为枢纽不属于完全随意的选择，但是这样消除了不必要的检测
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left-1;
        int rightPtr = right;

        while (true) {
            while (theArray[++leftPtr] < pivot) {
                ;
            }
            while (rightPtr > leftPtr && theArray[--rightPtr] > pivot) {
                ;
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    private void swap(int one, int two) {
        long temp = theArray[one];
        theArray[one] = theArray[two];
        theArray[two] = temp;
    }

    @Override
    public String toString() {
        String array = "";
        for (long i : theArray) {
            array =array + i +" ";
        }
        return array;
    }

    public static void main(String[] args) {
        long[] theArray = new long[]{6, 4, 5, 7, 3, 9, 2, 3, 6, 0, 1, 3, 7};
        ArrayIns arrayIns = new ArrayIns(theArray);
        arrayIns.quickSort();
        System.out.println(arrayIns);
    }
}
