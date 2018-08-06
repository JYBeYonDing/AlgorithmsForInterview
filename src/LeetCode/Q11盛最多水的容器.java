package LeetCode;

/**
 * Created by 杨杰 on 2018/7/17 0:08.
 */
public class Q11盛最多水的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
