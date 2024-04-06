import java.util.Arrays;

import org.apache.poi.poifs.filesystem.Ole10Native;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> wordDict;
    boolean result = false;


    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
//        dfs(s, 0);
//        return result;

        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return dp(s, 0);
    }

    private void dfs(String s, int idx) {
        if (idx > s.length()) {
            return;
        }
        if (result == true) {
            return;
        }
        if (s.length() == idx) {
            result = true;
            return;
        }
        for (String word : wordDict) {
            if (word.length() + idx > s.length()) {
                continue;
            }
            if (word.equals(s.substring(idx, idx + word.length()))) {
                dfs(s, idx + word.length());
            }
        }
    }

    private boolean dp(String s, int idx) {
        if (s.length() == idx) {
            return true;
        }
        if (dp[idx] == 1) {
            return true;
        }
        if (dp[idx] == 0) {
            return false;
        }
        for (String word: wordDict) {
            int len = word.length();
            if (s.length() >= idx + len && word.equals(s.substring(idx, idx + len))) {
                if (dp(s, idx + len)) {
                    dp[idx + len] = 1;
                    return true;
                }
            }
        }
        dp[idx] = 0;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
