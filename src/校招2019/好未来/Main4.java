package 校招2019.好未来;

import java.util.Scanner;

/**
 * Created by James on 2018/8/28 22:03.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        System.out.printf("%.2f\n",sum/(double)(n-m));
    }
}
