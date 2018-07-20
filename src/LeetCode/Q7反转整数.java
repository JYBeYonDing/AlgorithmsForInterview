package LeetCode;

/**
 * Created by 杨杰 on 2018/7/14 23:38.
 *
 * 技巧！！！判断整数是否溢出，乘完之后再除回来，如果不一样说明溢出了
 */
public class Q7反转整数 {
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        int newX = 0;
        while (x!=0) {
            int temp = newX;//这里设置了一个临时变量，用来检测是否会出现溢出
            newX = newX * 10 + x % 10;
            if (temp!=newX/10) {//如果不相等说明溢出
                return 0;
            }
            x /= 10;
        }
        if (negative) {
            newX = -newX;
        }
        return newX;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
