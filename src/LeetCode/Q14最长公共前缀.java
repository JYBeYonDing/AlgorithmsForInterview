package LeetCode;

/**
 * Created by 杨杰 on 2018/7/22 12:47.
 */
public class Q14最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String standard = strs[0];
        int len = 0;
        for(int i = 0 ;i<standard.length();i++) {
            for(int sindex = 1;sindex<strs.length;sindex++) {
                if (strs[sindex].length()<=0 || i == strs[sindex].length() || strs[sindex].charAt(i) != standard.charAt(i)) {
                    return standard.substring(0, len);
                }
            }
            len++;
        }
        return standard.substring(0, len);
    }
    public static void main(String[] args) {

    }
}
