package 其他算法收集;

/**
 * Created by 杨杰 on 2018/5/17 20:57.
 */
public class 找素数 {
    // 方法一
    public static void main(String[] args) {
        printPrime(100);
    }

    /**
     * 暴力查找
     * @param n
     */
    private static void printPrime(int n) {
        for (int i = 2; i < n; i++) {
            int count = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
                if (j == i && count == 1) {//如果只有一个因子，且是他本身就是素数，打印
                    System.out.print(i + " ");
                }
                if (count > 1) {// 多余一个因子直接跳过
                    break;
                }
            }
        }
    }
//********************************************************************************************************
    /**
     * 方法二
     * 使用开根号的方法，减少了部分搜索空间
     */
    public static void main2(String[] args) {

        for (int j = 2; j < 1000; j++) {
            if (m(j)) {
                System.out.print(j + " ");
            }
        }
    }

    /**
     * 使用开根号的方法，减少了部分搜索空间
     * @param num
     * @return
     */
    public static boolean m(int num) {
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;// 只要有一个能整除就立马返回false
            }
        }
        return true;
    }
}
