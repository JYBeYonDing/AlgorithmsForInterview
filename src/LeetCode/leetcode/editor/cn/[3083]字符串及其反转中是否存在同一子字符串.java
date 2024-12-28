
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubstringPresent(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        for (int i = 0; i + 1 < s.length(); i++) {
            String sub = s.substring(i, i + 2);
            if(reverse.contains(sub)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubstringPresent2(String s) {
        int[] h = new int[26];
        for (int i = 0; i + 1 < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            int y = s.charAt(i + 1) - 'a';
            h[x] |= 1 << y;
            if ((h[y] >> x & 1) != 0) {
                return true;
            }
        }
        return false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
