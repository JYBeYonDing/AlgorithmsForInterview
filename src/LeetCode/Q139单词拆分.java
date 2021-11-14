package LeetCode;

import java.util.List;

/**
 * Created by James on 2018/9/27 22:17.
 */
public class Q139单词拆分 {



    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);// [j,i)
                if (dp[j] && wordDict.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

}
