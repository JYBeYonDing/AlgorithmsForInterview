package 练习;

import edu.princeton.cs.algs4.In;

/**
 * Created by 杨杰 on 2018/4/27 11:19.
 */
public class 马拉车练习 {
    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
        str1 = "1234321";
        System.out.println(maxLcpsLength(str1));
        str1 = "12344321";
        System.out.println(maxLcpsLength(str1));
    }

    private static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }
        char[] sChars = getCharsWithPivot(str);
        int[] pArr = new int[sChars.length];// 回文半径数组
        int pR = 0;//最右回文右边界
        int c = -1;// 最右回文右边界的最早中心
        int pos = 0;
        int res = Integer.MIN_VALUE;
        while (pos < sChars.length) {
            pArr[pos] = (pos < pR) ? (Math.min(pR - pos, pArr[2 * c - pos])) : 1;
            while ((pos + pArr[pos] < sChars.length) && (pos - pArr[pos] > -1)) {
                if (sChars[pos + pArr[pos]] == sChars[pos - pArr[pos]]) {
                    pArr[pos]++;
                } else {
                    break;
                }
            }
            if (pR < pos + pArr[pos]) {
                pR = pos + pArr[pos];
                c = pos;
            }
            if (res < pArr[pos]) {
                res = pArr[pos];
            }
            pos++;
        }
        return res - 1;
    }

    private static char[] getCharsWithPivot(String str) {
        char[] chars = new char[str.length() * 2 + 1];
        for(int i = 0 ; i<str.length();i++) {
            chars[2 * i] = '#';
            chars[2 * i + 1] = str.charAt(i);
        }
        chars[chars.length - 1] = '#';
        return chars;
    }

}
