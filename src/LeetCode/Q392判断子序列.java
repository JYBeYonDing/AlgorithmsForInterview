package LeetCode;

/**
 * Created by James on 2018/9/2 9:45.
 */
public class Q392判断子序列 {
    public boolean isSubsequence(String s, String t) {


        if (s == null || t == null) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (j < s.length() && i < t.length()) {

            if (s.charAt(j) == t.charAt(i)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == s.length() && i <= t.length();

    }
}
