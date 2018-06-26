package Java面试慕课课程.BuautifulNumbers;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/6/26 9:11.
 */
public class BeautifulNumbersLarge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        for(long i=0;i<n;i++) {
            System.out.println(beautiful(sc.nextInt()));
        }
    }

    private static long beautiful(long n) {
        for(int bits = 64;bits>=2;bits--) {
            long radix = getRadix(n, bits);
            if (radix != -1) {
                return radix;
            }
        }
//        // should not reach here
//        return n-1;

        throw new IllegalStateException("Should not reach here.");
    }

    /**
     * 将n转成每位都为1的数
     * @return 转不出来返回-1
     */
    private static long getRadix(long n, int bits) {
        long minRadix = 2;
        long maxRadix = n;// 区间+1，这个n是取不到的
        while (minRadix < maxRadix) {
            long m = minRadix + (maxRadix - minRadix) / 2;
            long t = convert(m, bits);
            if (t == n) {
                return m;
            } else if (t < n) {
                minRadix = m + 1;
            } else {
                maxRadix = m;
            }
        }
        return -1;
    }

    /**
     * m进制下有bits位的1的数能转成多少
     */
    private static long convert(long radix, int bits) {
        long component = 1;
        long sum = 0;
        for(int i = 0;i<bits;i++) {
            if (Long.MAX_VALUE - sum < component) {// 防止溢出
                return Long.MAX_VALUE;
            } else {
                sum += component;
            }
            if (Long.MAX_VALUE / component < radix) {// 防止溢出
                component = Long.MAX_VALUE;
            } else {
                component *= radix;
            }
        }
        return sum;
    }
}
