import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while(right <s.length()){
            char c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0 )+1);
            right++;
            while(map.get(c)>1){
                char d = s.charAt(left);
                map.put(d,map.get(d)-1);
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
