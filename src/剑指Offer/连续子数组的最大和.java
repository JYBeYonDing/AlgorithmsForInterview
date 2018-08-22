package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/1 10:03.
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。、
 * 今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(solution2(arr));
    }


    private static int solution(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;// 以arr[i]结尾的连续子数组的最大和
        for (int i : arr) {
            if (sum < 0) {
                sum = i;
            } else {
                sum += i;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    /**
     * 动态规划的思想
     *
     * @param array
     * @return
     */
    private static int solution2(int[] array) {
        int max = Integer.MIN_VALUE;
        int[] sum = new int[array.length+1];// 以arr[i+1]结尾的连续子数组的最大和
        for (int i=0 ;i<array.length;i++) {
            if (sum[i]<0) {
                sum[i+1] = array[i];
            } else {
                sum[i+1] = sum[i]+array[i];
            }
            if (sum[i+1] > max) {
                max = sum[i+1];
            }
        }
        return max;
    }
}
