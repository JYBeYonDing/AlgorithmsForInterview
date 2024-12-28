import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int hn = 0;
        int vn = 0;
        int hIdx = horizontalCut.length - 1;
        int vIdx = verticalCut.length - 1;

        int res = 0;

        while(hIdx >= 0 || vIdx >= 0) {
            int hcut = hIdx >= 0 ? horizontalCut[hIdx] : 0;
            int vcut = vIdx >= 0 ? verticalCut[vIdx] : 0;
            if(hcut > vcut) {
                res += (horizontalCut[hIdx]) * (vn+1);
                hn++;
                hIdx--;
            } else {
                res += (verticalCut[vIdx]) * (hn+1);
                vn++;
                vIdx--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
