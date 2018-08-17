package LeetCode;

/**
 * Created by 杨杰 on 2018/8/8 19:23.
 */
public class Q338比特位计数 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i=1;i<=num;i++) {
            res[i] = res[i >> 1] + (i&1);
        }
        return res;
    }

    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i=1;i<=num;i++) {
            // i&(i-1) 为1的位数正好比 i 为1的位数少1
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
