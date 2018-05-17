package 牛客算法班.第三期.basic_class_01;

/**
 * Created by 杨杰 on 2018/5/17 15:51.
 * 根据 算法导论p109 修改
 */
public class Code_06_计数排序 {
    private static void countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        // 辅助数组c用来计数，c[i]中存放数字min+i在数组nums中出现了几次
        int[] count = new int[max - min + 1];
        for(int i = 0 ; i< nums.length ;i++) {
            count[nums[i]-min]++;
        }
        // c[i]中统计了<=i+min 的数据的个数
        for (int i = 1 ;i<count.length ; i++) {
            count[i] += count[i - 1];
        }
        // 辅助空间，用来存放排序后的数组
        int[] help = new int[nums.length];
        // nums数组索引从后往前保证了排序的 稳定性！！！
        for(int i = nums.length-1 ; i>=0 ; i--) {
            help[--count[nums[i]-min]] = nums[i];// 将num[i]放到排序后应放的位置
        }

        // 复制到原来的数组
        for(int i= 0 ; i< nums.length ;i++) {
            nums[i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 5};
        countSort(nums);
        for (int i : nums) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
