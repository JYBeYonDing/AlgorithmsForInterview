package LeetCode;

/**
 * Created by 杨杰 on 2018/7/9 21:09.
 */
public class Q5最长回文子串 {
    /**
     * 复杂度太大
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(s).reverse();
        int longest = 1;
        String longestStr = s.substring(0,1);
        for(int i=0;i<sb1.length();i++) {
            for(int j = i+1;j<sb1.length()+1;j++) {
                if (sb2.indexOf(sb1.substring(i, j),sb1.length() - j) == sb1.length() - j) {
                    if (j - i > longest) {
                        longest = j-i;
                        longestStr = sb1.substring(i, j);
                    }
                }
            }
        }
        return longestStr;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("ab"));
    }


    /**
     * 复杂度O(N^2)
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() <= 0) {
            return null;
        }
        int longest = 0;
        String longestStr = null;
        for(int i = 0;i<s.length();i++) {
            //考虑到会问长度的奇偶性，所有要分别求可能的情况
            int[] r1 = expandAroundCenter(s, i, i);
            int[] r2 = expandAroundCenter(s, i, i + 1);
            int[] r = r1[0] > r2[0] ? r1 : r2;
            if (r[0] > longest) {
                longest = r[0];
                longestStr = s.substring(r[1], r[2] + 1);
            }
        }
        return longestStr;
    }

    private static int[] expandAroundCenter(String s, int left, int right) {
        int L =left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        // 返回的一个数为长度，第二个第三个数分别为左右边界
        return new int[]{R-L+1,L+1,R-1};
    }
}
