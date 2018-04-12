package Java数据结构和算法.二分查找;

public class OrderArray {
    private int[] a;
    private int nElems;

    public OrderArray(int max) {
        a = new int[max];
        nElems = 0;
    }

    /**
     * Java数据结构和算法.二分查找
     * @param key
     * @return
     */
    public int find(long key) {
        //Arrays下的binarySearch
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
