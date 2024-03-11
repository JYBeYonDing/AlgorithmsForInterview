import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int size;

    HashMap<Integer, Integer> blackIdx2Idx;

    public Solution(int n, int[] blacklist) {
        size = n - blacklist.length;
        blackIdx2Idx = new HashMap<>();
        for (int i = 0; i < blacklist.length; i++) {
            int b = blacklist[i];
            blackIdx2Idx.put(b, -1);
        }

        int last = n - 1;
        for (int b: blacklist) {
            if (b >= size) {
                continue;
            }
            while (blackIdx2Idx.containsKey(last)) {
                last--;
            }
            blackIdx2Idx.put(b, last);
            last--;
        }
    }

    public int pick() {
        int idx =(int) (Math.random() * size);
        if (blackIdx2Idx.containsKey(idx)) {
            return blackIdx2Idx.get(idx);
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj = new Solution(n, blacklist); int param_1
 * = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)
