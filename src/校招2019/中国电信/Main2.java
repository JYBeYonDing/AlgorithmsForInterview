package 校招2019.中国电信;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/10 10:53.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = sc.nextInt();

        System.out.println(solution(n));

    }



    private static int solution(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index < 7) {
            return index;
        }
        int[] nums = new int[index];
        nums[0] = 1;
        int c2 = 0;
        int c3 = 0;
        int c5 = 0;
        for (int i = 1; i < index; i++) {
            nums[i] = Math.min(nums[c2] * 2, Math.min(nums[c3] * 3, nums[c5] * 5));
            if (nums[i] == nums[c2] * 2) {
                c2++;
            }
            if (nums[i] == nums[c3] * 3) {
                c3++;
            }
            if (nums[i] == nums[c5] * 5) {
                c5++;
            }
        }
        return nums[index - 1];

    }


}