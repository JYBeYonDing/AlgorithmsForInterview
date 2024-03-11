import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        Integer result = 0;

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            right++;
            while (left < right && window.get(c) > 1) {

                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
                left++;
            }
            if (right - left > result) {
                result = right - left;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
