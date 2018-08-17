package 校招2019.网易;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/8/11 15:36.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String[] strs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);
        strs = scanner.nextLine().split(" ");
        int[] nums = new int[n];
        for(int i =0;i<n;i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        strs = scanner.nextLine().split(" ");
        int[] ts = new int[n];
        for(int i =0;i<n;i++) {
            ts[i] = Integer.parseInt(strs[i]);
        }

        solution(nums,ts,k,n);
    }

    private static void solution(int[] nums, int[] ts, int k, int n) {
        int sum = 0;
        int max =0;
        for (int i = 0; i < n; i++) {
            if (ts[i] == 1) {
                sum += nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (ts[i] == 0 ) {
                int num =sum;
                for (int j = i; j < Math.min(i+k,n); j++) {
                    if(ts[j]==0) {
                        num+=nums[j];
                    }
                }
                max = Math.max(max, num);
            }
        }
        System.out.println(max);
    }
}

