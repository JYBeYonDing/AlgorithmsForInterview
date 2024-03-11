import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> num2Q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < nums2.length; i++) {
            num2Q.add(new int[] { i, nums2[i] });
        }
        Arrays.sort(nums1);
        int smallest = 0;
        int biggest = nums1.length - 1;
        int[] result = new int[nums1.length];
        while (!num2Q.isEmpty()) {
            int[] poll = num2Q.poll();
            if (nums1[biggest] > poll[1]) {
                result[poll[0]] = nums1[biggest];
                biggest--;
            }else{
                result[poll[0]] = nums1[smallest];
                smallest++;
            }
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
