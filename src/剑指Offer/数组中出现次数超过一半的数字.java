package 剑指Offer;

/**
 * Created by James on 2018/8/17 22:32.
 */
public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    //使用快排的partition思想，找出中位数即可，时间复杂度位O（N）
    public static int MoreThanHalfNum_Solution(int [] array) {
        int result = 0;
        if (array == null) {
            return 0;
        }

        int middle = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        int index = partition(array, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(array, start, end);
            } else {
                start = index + 1;
                index = partition(array, start, end);
            }
        }
        result = array[middle];
        if (!checkMoreThanHalf(array, result)) {
            return 0;
        }
        return result;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int more = end;// >=more 的位置为 大于pivot的数
        int less = start-1; // <=less 的位置为 小于pivot的数
        while(start < more){
            if(array[start]<pivot){
                less++;
                swap(array,less,start);
                start++;
            } else if (array[start] == pivot) {
                start++;
            }else{
                more--;
                swap(array, start, more);
            }
        }
        swap(array, start, end);

        return less+1;
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }


    public static int MoreThanHalfNum_Solution2(int [] array) {
        int result = 0;
        int num = 1;
        if (array == null) {
            return 0;
        }

        for(int i =0;i<array.length ;i++) {
            if (array[i] != result) {
                num--;
            } else {
                num++;
            }

            if (num == 0) {
                result = array[i];
                num = 1;
            }
        }

        //判断这个数字的个数是否超过了一半
        if (!checkMoreThanHalf(array,result)) {
            result = 0;
        }
        return result;
    }
    private static boolean checkMoreThanHalf(int[] array,int result) {
        int num = 0;
        for(int i = 0 ; i<array.length ; i++) {
            if (array[i] == result) {
                num++;
            }
        }
        if (num > array.length >> 1) {
            return true;
        } else {
            return false;
        }
    }
}
