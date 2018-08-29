package 剑指Offer;

import java.util.Arrays;

/**
 * Created by James on 2018/8/27 22:11.
 *
 * 如果面试题是关于n位整数并且没有限定n的取值范围，或者是输入任意大小的整数，那么这个题目很有可能是需要考虑大数问题的。
 * 字符串是一个简单、有效的表示大数的方法。
 */
public class 按序打印数字 {
    public static void main(String[] args) {
        print1ToMaxOfNDigits(2);
    }

    private static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    private static void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    private static void printNumber(char[] number) {
        for (char c : number) {
            System.out.print(c);
        }
        System.out.println();
    }
}
