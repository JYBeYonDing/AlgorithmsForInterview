
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = longest(s,i,i);
            if(s1.length()>max.length()) {
                max = s1;
            }
            String s2 = longest(s,i,i+1);
            if(s2.length()>max.length()){
                max = s2;
            }
        }
        return max;
    }

    /**
     * 从 l和r向两边扩展的最长回文
     * @param chars
     * @param l
     * @param r
     * @return
     */
    private String longest(String s, int l, int r) {
        int rLeft=l;
        int rRight=r;
        while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }





}
//leetcode submit region end(Prohibit modification and deletion)
