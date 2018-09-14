package LeetCode;

/**
 * Created by James on 2018/9/4 10:09.
 */
public class Q75颜色分类 {

    public void sortColors(int[] nums) {

        int[] count = new int[3];

        for (int i : nums) {
            assert i >= 0 && i <= 2;
            count[i]++;
        }


        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }

    }

    public static void main(String[] args) {
        new Q75颜色分类().sortColors(new int[]{0,1,2,3,2});
    }
}
