package 其他算法收集;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/25 19:36.
 * 字符串模拟除法
 * 目前写的算法中除数只能是int型可以表示的数
 * 被除数可以无穷大
 */
public class 字符串模拟除法 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();// 被除数
        char[] sa = a.toCharArray();
        int b = Integer.parseInt(sc.nextLine());// 除数
        int[] cnt = new int[sa.length];// 用于存放结果
        //****下面这段就是模拟手动除法的过程***********************
        int tmp = 0;
        for (int i = 0; i < sa.length; ++i) {
            tmp = tmp * 10 + sa[i] - '0';
            if (tmp >= b) {
                cnt[i] = tmp / b;
                tmp = tmp % b;
            } else {
                cnt[i] = 0;
            }
        }
        //*****结果已经在数组cnt中，打印输出时需要注意高位的0  ******
        boolean f = true;//标识当前位是否是高位的0
        if (cnt[0] != 0) {
            f = false;
        }
        for (int i = 0; i < cnt.length; ++i) {
            if (f && (cnt[i] == 0)) {
                continue;
            } else {
                f = false;
            }
            System.out.print(cnt[i]);
        }
        System.out.println(" " + tmp);
    }
}
