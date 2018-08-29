package 剑指Offer;

/**
 * Created by James on 2018/8/27 19:06.
 *
 * 思路：把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1编程0。
 * 那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
 *
 * 举一反三：把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于是把整数的二进制表示中的最右边一个1编程0。
 * 很多二进制的问题都可以用这个思路解决。
 */
public class t11二进制中1的个数 {
    public static int NumberOf1(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n= n & (n-1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(3));
    }
}
