package LeetCode;

import java.time.temporal.ChronoUnit;

/**
 * Created by James on 2018/9/2 10:02.
 */
public class Q55跳跃游戏 {


    public boolean canJump(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return true;
        }

        int cur = 0;

        while (cur < nums.length) {
            int tempMax = cur + nums[cur];
            if (tempMax >= nums.length-1) {
                return true;
            }

            int nextMax = tempMax;
            int nextStep=cur;
            for (int i = cur+1; i <= tempMax; i++) {
                if (i + nums[i] > nextMax) {
                    nextMax = i + nums[i];
                    nextStep = i;
                }
            }
            if (nextStep == cur) {
                return false;
            }
            cur = nextStep;
        }

        return false;
    }

    public static void main(String[] args) {
        Q55跳跃游戏 tiao = new Q55跳跃游戏();

        System.out.println(tiao.canJump(new int[]{0,1}));
    }




    //牛逼的贪心算法
    public boolean canJump2(int[] nums) {
        int max = 0;// 能跳的最远的距离
        for(int i = 0;i<nums.length;i++){
            if(i>max) return false;// 走的位置已经超过了能跳的最远的距离，说明失效了
            max = Math.max(nums[i]+i,max);

        }
        return true;
    }
}
