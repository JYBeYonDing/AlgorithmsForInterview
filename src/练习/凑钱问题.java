package 练习;

/**
 * Created by 杨杰 on 2018/5/16 12:16.
 */
public class 凑钱问题 {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 8 };
        int aim = 12;
        System.out.println(money1(arr, aim));
        System.out.println(money2(arr, aim));
    }

    private static boolean money2(int[] arr, int aim) {
        boolean[][] dp = new boolean[aim+1][arr.length];
        for(int i = 0 ; i< dp.length ;i++) {
            dp[i][0] = aim % arr[0] == 0;
        }
        for(int j = 0 ; j<arr.length ; j++) {
            dp[0][j] = true;
        }
        for(int i = 0 ; i<dp.length ; i++) {
            for(int j = 1 ; j< dp[0].length ; j++) {
                if (i - arr[j] < 0) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i - arr[j]][j] || dp[i - arr[j]][j - 1];
                }
            }
        }

        return dp[aim][arr.length-1];
    }

    private static boolean money1(int[] arr, int aim) {
        return process1(arr, aim, arr.length - 1);
    }

    private static boolean process1(int[] arr, int aim, int i) {
        if (i < 0) {
            return false;
        }
        if (aim < 0) {
            return false;
        }
        if (aim == 0) {
            return true;
        }
        return process1(arr, aim - arr[i], i) || process1(arr, aim - arr[i], i - 1);
    }
}
