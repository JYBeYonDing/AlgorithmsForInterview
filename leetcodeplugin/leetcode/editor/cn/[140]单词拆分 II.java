import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> wordDict;
    LinkedList<String> path = new LinkedList<>();
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        dfs(s, 0);

        return res;
    }

    private void dfs(String s, int idx) {
        if (s.length() == idx) {
            StringBuilder tempRes = new StringBuilder();
            for (String word : path) {
                tempRes.append(word).append(" ");
            }
            res.add(tempRes.substring(0, tempRes.length() - 1));
            return;
        }

        for (String word : wordDict) {
            int length = word.length();
            if (idx + length > s.length()) {
                continue;
            }
            if (word.equals(s.substring(idx, idx + length))) {
                path.add(word);
                dfs(s, idx + length);
                path.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
