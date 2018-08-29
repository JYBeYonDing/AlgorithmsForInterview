package 剑指Offer;

/**
 * Created by James on 2018/8/27 17:42.
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class t8跳台阶 {
    public int JumpFloor(int target) {
        if (target == 0 || target==1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int j1 = 1;
        int j2 = 2;
        for (int i = 3; i <= target; i++) {
            int temp = j1;
            j1 = j2;
            j2 = temp+j2;
        }
        return j2;
    }

}
