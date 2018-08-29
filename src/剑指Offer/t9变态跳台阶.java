package 剑指Offer;

/**
 * Created by James on 2018/8/27 17:47.
 */
public class t9变态跳台阶 {
    public int JumpFloorII(int target) {
        int j = 1;
        for (int i = 1; i < target; i++) {
            j = j  * 2;
        }
        return j;
    }
}
