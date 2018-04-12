package 练习;

/**
 * Created by 杨杰 on 2018/4/12 15:30.
 */
public class 荷兰国旗 {


    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }

    private static int[] partition(int[] nums, int start, int end, int flag) {
        int less = start - 1;
        int more = end + 1;
        while (start < more) {
            if (nums[start] < flag) {
                less++;
                swap(nums, less, start);
                start++;
            } else if (nums[start] > flag) {
                more--;
                swap(nums, start, more);
            } else {
                start++;
            }
        }
        return new int[]{less + 1, more - 1};
    }
}
