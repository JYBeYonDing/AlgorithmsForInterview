package 牛客网;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/4/26 17:20.
 * 链接：https://www.nowcoder.com/questionTerminal/661c49118ca241909add3a11c96408c8
 来源：牛客网
 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
 要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 输入描述:
 每个输入包含 1 个测试用例。
 每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，
 接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
 接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
 输出描述:
 输出一行表示最大的乘积。

 3
 7 4 7
 2 50

 49


 没做出来
 */
public class 合唱团 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0; i<n;i++) {
//            arr[i] = sc.nextInt();
//        }
//        int k = sc.nextInt();
//        int d = sc.nextInt();

        int[] arr = {7, 4, 7};
        int n=3;
        int k=2;
        int d = 50;
        System.out.println(getMaxMemory(arr,d,k));
    }

    /**
     * 递归
     */
    public static int getMax(int[] arr, int d, int k) {
        return process(arr, arr.length, 0, k, d);
    }

    private static int process(int[] arr, int last, int index, int k, int d) {
        if (index - last > d) {
            return -1;
        }
        if (index == arr.length) {
            return k == 0 ? 1 : -1;
        }
        int notInclude = process(arr, last, index + 1, k, d);
        int include = arr[index] * process(arr, index, index + 1, k - 1, d);
        return Math.max(notInclude, include);
    }

    /*记忆搜索*/
    public static int getMaxMemory(int[] arr, int d, int k) {
        int[][][] memory = new int[arr.length+1][arr.length+1][k+1];
        return processMemory(memory,arr, arr.length, 0, k, d);
    }

    private static int processMemory(int[][][] memory, int[] arr, int last, int index, int k, int d) {
        if (index - last > d) {
            memory[last][index][k] = -1;
            return -1;
        }
        if (index == arr.length) {
            if (k == 0) {
                memory[last][index][k] = 1;
                return 1;
            } else {
                memory[last][index][k] = -1;
                return -1;
            }
        }
        int notInclude = memory[last][index + 1][k];
        if (memory[last][index + 1][k] == 0) {
            notInclude = processMemory(memory, arr, last, index + 1, k, d);
            memory[last][index + 1][k] = notInclude;
        }
        int include = 0;
        if (k == 0) {
            return -1;
        } else {
            include = memory[index][index + 1][k-1];
            if (memory[index][index + 1][k - 1] == 0) {
                include =arr[index] * processMemory(memory,arr, index, index + 1, k - 1, d);
                memory[index][index + 1][k - 1] = include;
            }
        }
        memory[last][index][k] = Math.max(notInclude, include);
        return Math.max(notInclude, include);
    }


    public static int getMaxDP(int[] arr, int d, int k) {
        int n = arr.length;
        int[][][] dp = new int[n+1][n+1][k+1];//last+1,index,k
        for(int i=0;i<n+1;i++) {
            for(int ik=0;ik<k+1;ik++) {
                if (ik == 0) {
                    dp[i][n][ik] = 1;
                } else {
                    dp[i][n][ik] = -1;
                }
            }
        }
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<n+1;j++) {
                for(int ik=0;ik<k+1;i++) {
                    if ((i != 0) && (j - (i - 1)) > d) {
                        dp[i][j][ik] = -1;
                    }
                }
            }
        }
        for(int i=n;i>=0;i--) {
            for(int j=n;j>=0;j--) {
                for(int ik=0;ik<k+1;i++) {
                    if ((j != n) && !((i != 0) && (j - (i - 1)) > d)) {
                        dp[i][j][ik] = Math.max(dp[i - 1][j + 1][ik], dp[j][j + 1][k - 1]);
                    }
                }
            }
        }

        return dp[0][0][k];
    }

}
