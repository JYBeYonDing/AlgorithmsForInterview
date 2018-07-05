package 刷题;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/7/5 22:00.
 * 题目描述
 度度熊收到了一个只有小写字母的字符串S，他对S的子串产生了兴趣，
 S的子串为S中任意连续的一段。他发现，一些子串只由一种字母构成，他想知道在S中一共有多少种这样的子串。

 例如在串”aaabbaa”中，度度熊想找的子串有”a”,”aa”,”aaa”,”b”,”bb”五种。
 输入
 输入只有一行，一个字符串，长度不超过100000，只由小写字母组成
 输出
 输出一行，符合要求的子串种数
 */
public class 度度熊找子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.length() <= 1) {
            System.out.println(s.length());
        }
        int temp = 0;
        HashSet<String> result = new HashSet<>();
        result.add(s.substring(0, 1));
        for(int i = 1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(temp)) {
                result.add(s.substring(temp, i+1));
            } else {
                result.add(s.substring(i, i + 1));
                temp = i;
            }
        }
        System.out.println(result.size());
    }
}
