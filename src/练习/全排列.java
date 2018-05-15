package 练习;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 杨杰 on 2018/5/15 11:08.
 */
public class 全排列 {
    public static void main(String[] args) {
        String test1 = "abc";
        printAllPermutations1(test1);
        System.out.println("======");
        printAllPermutations2(test1);
        System.out.println("======");

        String test2 = "acc";
        printAllPermutations1(test2);
        System.out.println("======");
        printAllPermutations2(test2);
        System.out.println("======");
    }

    /**
     * 全排列，包括重复
     *
     * @param test1
     */
    private static void printAllPermutations1(String test1) {
        if (test1 == null) {
            return;
        }
        process1(test1, 0);
    }

    private static void process1(String test1, int i) {
        if (i == test1.length()) {
            System.out.println(test1);
            return;
        }
        char[] chars = test1.toCharArray();
        for (int k = i; k < chars.length; k++) {
            swap(chars, i, k);
            process1(new String(chars), i + 1);
            swap(chars, i, k);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * 去掉重复的全排列
     *
     * @param test2
     */
    private static void printAllPermutations2(String test2) {
        if (test2 == null) {
            return;
        }
        process2(test2, 0);
    }

    private static void process2(String test2, int i) {
        if (i == test2.length()) {
            System.out.println(test2);
        }
        char[] chars = test2.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int k = i; k<test2.length();k++) {
            if (!set.contains(chars[k])) {
                set.add(chars[k]);
                swap(chars, i, k);
                process2(new String(chars), i + 1);
                swap(chars, i, k);
            }
        }
    }
}
