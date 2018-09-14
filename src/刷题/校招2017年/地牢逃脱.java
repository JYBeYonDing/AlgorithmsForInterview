package 刷题.校招2017年;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/3 22:05.
 */
public class 地牢逃脱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String str = sc.nextLine();

        String[] strs = sc.nextLine().split(" ");

        int n = Integer.parseInt(strs[0]);


        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }


        //输出结果
        System.out.println();

        // 输出小数
        System.out.printf("%.2f\n", 3.1415926);
        String s = String.format("%.2f", 3.1415926);
        System.out.println(s);
    }
}