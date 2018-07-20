package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杨杰 on 2018/7/13 22:47.
 */
public class Q3无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        int leftBound = 0;
        for(int i=0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                maxLength = Math.max(maxLength, i - leftBound);
                leftBound = Math.max(leftBound,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
        }
        maxLength = Math.max(maxLength, s.length()-leftBound);
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
