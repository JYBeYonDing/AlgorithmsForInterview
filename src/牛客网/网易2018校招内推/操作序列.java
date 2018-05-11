package 牛客网.网易2018校招内推;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/11 11:16.
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 * 1、将a_i放入b序列的末尾
 * 2、逆置b序列
 * 小易需要你计算输出操作n次之后的b序列。
 * 输入描述:
 * 输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
 * 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。
 * <p>
 * <p>
 * 输出描述:
 * 在一行中输出操作n次之后的b序列,以空格分割,行末无空格。
 * <p>
 * 输入例子1:
 * 4
 * 1 2 3 4
 * <p>
 * 输出例子1:
 * 4 2 1 3
 */
public class 操作序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] n = new int[N];
        for (int i = 0; i < N; i++) {
            n[i] = sc.nextInt();
        }
        System.out.println(solution1(n));
    }

    private static String solution(int[] n) {
        return solve(n, n.length);
    }

    private static String solve(int[] n, int leftLength) {
        if (leftLength == 1) {
            return n[0] + "";
        }
        if (leftLength == 2) {
            return n[1] + " " + n[0];
        }
        return n[leftLength - 1] + " " + solve(n, leftLength - 2) + " " + n[leftLength - 2];
    }

    /**
     * 非递归
     * 因为递归会造成栈溢出
     */
    private static String solution1(int[] n) {
        int[] nNew = new int[n.length];
        int left = 0;
        int right = n.length-1;
        for (int leftLength = n.length; leftLength >=1; leftLength = leftLength - 2) {
            if (leftLength == 1) {
                nNew[left] = n[0];
                break;
            } else if (leftLength == 2) {
                nNew[left] = n[1];
                nNew[right] = n[0];
                break;
            } else {
                nNew[left++] = n[leftLength - 1];
                nNew[right--] = n[leftLength - 2];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<nNew.length-1 ; i++) {
            sb.append(nNew[i] + " ");
        }
        sb.append(nNew[nNew.length - 1]);
        return sb.toString();
    }
}
