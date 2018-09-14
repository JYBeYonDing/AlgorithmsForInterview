package 校招2019.头条3;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/9 10:35.
 */
public class Main4 {

    // 自己写的没有AC，看Q393UTF8编码
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int N = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();

        }

        boolean flag = solution(nums, N, 0);

        if (flag) {
            System.out.println(1);

        } else {
            System.out.println(0);

        }

    }

    private static boolean solution(int[] nums,int N,int index) {
        if (N <= 0 || index > N) {
            return false;
        }
        if (index == N) {
            return true;
        }


        if (nums[index] < 128) {
            return solution(nums,N,index+1);
        }



        if (nums[index] >= 128 + 64 && nums[index] < 128 + 64 + 32) {
            return nums[index+1] >= 128 && nums[index+1] < 128 + 64 && solution(nums,N,index+2) ;
        }



        if (nums[index] >= 128 + 64 + 32 && nums[index] < 128 + 64 + 32 + 16) {
            return nums[index+1] >= 128 && nums[index+1] < 128 + 64
                    && nums[index+2] >= 128 && nums[index+2] < 128 + 64
                    && solution(nums,N,index+3);
        }



        if (nums[index] >= 128 + 64 + 32+16 && nums[index] < 128 + 64 + 32 + 16+8) {
            return nums[index+1] >= 128 && nums[index+1] < 128 + 64
                    && nums[index+2] >= 128 && nums[index+2] < 128 + 64
                    && nums[index+3] >= 128 && nums[index+3] < 128 + 64
                    && solution(nums, N, index + 4);
        }


        return false;
    }
}