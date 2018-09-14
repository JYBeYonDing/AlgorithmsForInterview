package 校招2019.科大讯飞;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/7 16:33.
 *
 2
 5 60
 59 20 30 90 100
 5 60
 59 20 10 10 100
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int X = sc.nextInt();

            int[] nums = new int[n];
            int sum = 0;
            for (int k = 0; k < n; k++) {


                nums[k] = sc.nextInt();
                sum += nums[k];
            }

            res.add(solution(nums, X,sum));

        }

        for (int i : res) {
            System.out.println(i);
        }
    }

    private static Integer solution(int[] nums, int X, int sum) {

        Arrays.sort(nums);

        int wantSum = X * nums.length;

        if (sum >= wantSum) {
            return 0;
        }
        int res=0;
        for (int n : nums) {
            sum += 100 - n;
            res++;
            if (sum >= wantSum) {
                return res;
            }
        }
        return nums.length;
    }
}