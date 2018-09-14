package LeetCode;

/**
 * Created by James on 2018/9/4 16:24.
 */
public class Q69x的平方根 {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int l = 1;
        int r = x;

        while (l <= r) {

            int mid = l + (r - l) / 2;
            int sqrt = x / mid;

            if (sqrt == mid) {
                return mid;
            } else if (sqrt < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        Q69x的平方根 pingfanggen = new Q69x的平方根();

        System.out.println(pingfanggen.mySqrt(2147395599));
    }
}
