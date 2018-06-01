package 牛客网;

/**
 * Created by 杨杰 on 2018/6/1 22:25.
 * 纯暴力，当时没有做出了。
 *
 * 反思：做题过程中，先用最简单的思路写出来。
 * 问题要分步骤。
 * 明确目标，分析思路。
 */
public class vivo提前批 {
    public static void main(String[] args) {
        String str = "ewoijvovovoweo";
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        int max = 0;
        int index = 0;
        for(int i = 0; i<str.length();i++) {
            for(int j = i+1; j<str.length();j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    int len = j-i;
                    if (canMatch(str, i, len)) {
                        if (len * 2 > max) {
                            max = len*2;
                            index = i;
                        }
                    }
                }
            }
        }
        return str.substring(index, index+max);
    }

    private static boolean canMatch(String str, int i, int len) {
        if (i + len + len <= str.length()) {
            for(int index = 0;index<len;index++) {
                if (str.charAt(index+i) != str.charAt(i + len + index)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
