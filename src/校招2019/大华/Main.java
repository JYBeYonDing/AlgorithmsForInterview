package 校招2019.大华;

/**
 * Created by James on 2018/9/13 10:56.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(rev(rev(100)+rev(322)));
    }

    public static int rev(int num) {
        char[] nums = (""+num).toCharArray();
        int start =0;
        int end = nums.length - 1;

        while (start < end) {
            char temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;

        }
        StringBuilder sb = new StringBuilder();
        boolean falg = true;
        for (int i = 0; i < nums.length; i++) {
            if (falg && nums[i] == '0') {
                continue;
            } else {
                sb.append(nums[i]);
                falg = false;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
