package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 杨杰 on 2018/6/17 13:44.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述:输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class 字符串的排列 {

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> result = Permutation(str);
        for (String s : result) {
            System.out.println(s);
        }
    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() < 1) {
            return result;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        result.add(new String(chars));
        while (hasNext(chars)) {
            result.add(new String(chars));
        }
        return result;
    }

    private static boolean hasNext(char[] chars) {
        //1.找到最后升序的第一个字符
        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        if (i < 0) {//说明已经是字典序的最大序，全部找完
            return false;
        }
        int j = chars.length-1;
        while (j > i && chars[j] <= chars[i]) {
            j--;
        }
        swap(chars, i, j);
        reverse(chars, i + 1,chars.length-1);
        return true;//找到一个序列
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start++, end--);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
