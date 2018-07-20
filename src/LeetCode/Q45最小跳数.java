package LeetCode;

/**
 * Created by 杨杰 on 2018/7/8 23:17.
 给定一个非负整数数组，你最初位于数组的首位。
 数组中的每个元素表示你在该位置的最大跳跃长度。
 你的目标是用最小跳跃次数到达最后一个索引。

 例如:
 给定一个数组 A = [2,3,1,1,4]
 跳到最后一个索引的最小跳跃数是 2。(从索引 0 跳到 1 跳1步，然后跳3步到最后一个索引。)
 注意:
 假设你总是可以到达最后一个索引位置。

 一开始以为是dp。。。其实是贪心，每次找范围内index + next最大的索引一定是满足最小步数
 */
public class Q45最小跳数 {
    public int jump(int[] nums) {
        if(nums.length<=1){// 如果只有一个数，则就是最后一个位置，不用跳
            return 0;
        }
        int step = 0;//跳数
        int p = 0;// 当前位置
        int len = nums.length;
        while(p<len){
            if(p+nums[p]>=len-1){// 如果从当前位置可以调到最后一个位置，直接返回跳数
                return step+1;
            }
            int max = -1;//当前位置所能跳的范围内，再一跳能跳的最远距离
            int index =0;//能跳最远距离的那一跳的起跳位置
            for(int i = p;i<=p+nums[p];i++){// 从i位置起跳
                if(i+nums[i]>max){
                    max = i+nums[i];
                    index = i;
                }
            }
            step++;
            p = index;
        }
        return step;
    }
}
