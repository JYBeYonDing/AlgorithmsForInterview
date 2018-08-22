package 校招2019.华为0822;

import java.util.Scanner;

/**
 * Created by James on 2018/8/22 20:13.
 * <p>
 * AGCTAGCT 输出4
 * AGAG 输出2
 * GGG 输出2
 */
public class 最长重复子串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        solution2(str);


    }



    private static void solution2(String str) {
        if (str == null) {
            System.out.println(" 0");
            return;
        }
        int max = 0;
        int first = 0;
        for (int i = 1; i < str.length(); i++) {//前后两个指针相差i位的情况下找出最长的重复子串
            int k = 0;//相同字段的长度
            for (int j = 0; j < str.length() - i && k<i; j++) {//加上"&k<i"是为了保证aaaa这种情况的最长重复子串为aa，而不是重叠的aaa
                if (str.charAt(j) == str.charAt(i + j)) {//第j位和第j+i位
                    k++;
                } else {
                    k = 0;
                }
                if (k > max) {
                    max = k;
                    first = j - k + 1;
                }

            }
        }
        if (max > 0) {
            System.out.print(str.substring(first, first + max) + " ");
            System.out.println(max);
        } else {
            System.out.println(" 0");
        }
    }



    /**
     * 暴力解，相当于三重循环，复杂度太大
     *
     * @param str 字符串
     */
    private static void solution(String str) {
        if (str == null || str.length() <= 1) {
            System.out.println(" 0");
            return;
        }

        int maxLen = 0;// 最长重复长度
        int first = 0;// 出现重复长度时的指针

        for (int i = 0; i < str.length(); i++) {
            for (int end = i + 1; end < str.length(); end++) {
                if (str.substring(end).contains(str.substring(i, end))) {
                    if (end - i > maxLen) {
                        maxLen = end - i;
                        first = i;
                    }
                }
            }
        }
        if (maxLen > 0) {
            System.out.print(str.substring(first, first + maxLen) + " ");
            System.out.println(maxLen);
        } else {
            System.out.println(" 0");
        }
    }





}
