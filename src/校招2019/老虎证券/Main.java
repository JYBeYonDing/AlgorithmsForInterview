package 校招2019.老虎证券;

/**
 * Created by James on 2018/9/5 22:06.
 */
public class Main {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5,4,3};

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, solution(arr, i, 3));
        }
        System.out.println(max);
    }

    private static int solution(int[] arr, int index, int k) {
        if (k == 1) {
            return arr[index];
        }

        if (k < 1 || index >= arr.length) {
            return 0;
        }
        int max = 0;
        for (int i = index + 1; i <= index + 2 && i<arr.length; i++) {
            max = Math.max(max, solution(arr, i, k - 1) * arr[index]);
        }
        return max;
    }
}
