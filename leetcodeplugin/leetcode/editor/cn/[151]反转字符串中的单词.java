
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
        }
        left = -1;
        right = -1;
        int point = 0;
        while (point < s.length()) {
            if (left == -1 && charArray[point] != " ".charAt(0)) {
                left = point;
            }
            if ( right == -1 &&(  || charArray[right+1] == " ".charAt(0))) {
                
                right = point;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
