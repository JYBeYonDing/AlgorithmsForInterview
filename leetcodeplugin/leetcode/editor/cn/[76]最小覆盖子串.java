import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            if (windows.get(c).equals(need.get(c))) {
                valid++;
            }
            right++;
            while (left < right && valid == need.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                char d = s.charAt(left);
                left++;
                if (windows.get(d).equals(need.get(d))) {
                    valid--;
                }
                windows.put(d, windows.get(d) - 1);
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
