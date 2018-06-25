package Java面试慕课课程;

/**
 * Created by 杨杰 on 2018/6/23 10:21.
 */
public class BinarySearch {

    /**
     * Search element k in a sorted array.
     *
     * @param arr a sorted array.
     * @param k   the element to search.
     * @return index in arr where k is . -1 if not found.
     */
    int binarySearch(int[] arr, int k) {
        int a = 0;
        int b = arr.length;// 右边界选择半开有很多好处，建议用半开
        // 规定要查找的值k可能在的数组arr内下标区间a,b
        // 循环不变式：[a,b)是一个有效区间，k只可能在区间里面，如果在区间外边就说明没有。
        while (a<b) {
//            int m = (a + b) / 2;//可能溢出
            int m = a + ((b-a) >> 1);//int mid = (low + high) >>> 1;// Arrays类库中的二分查找，采用了无符号右移！！！因为下标都是正数！！！负数感觉就不可以了。
            // a==b : m=a and m=b
            // b==a+1: m=a
            // b==a+2: m=a+1
            if (k < arr[m]) {
                b = m;
            } else if (k > arr[m]) {
                a = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(new int[]{1,2,3,4,5},4));
        System.out.println(binarySearch.binarySearch(new int[]{1,2,3,4,5},0));
        System.out.println(binarySearch.binarySearch(new int[]{1,2,3,4,5},5));
        System.out.println(binarySearch.binarySearch(new int[]{1,2,3,4,5},1));
        System.out.println(binarySearch.binarySearch(new int[]{1},1));
        System.out.println(binarySearch.binarySearch(new int[]{5},1));
        System.out.println(binarySearch.binarySearch(new int[]{},1));
    }
}
