package 牛客网.模拟2017年校招第五场;

import java.util.*;

/**
 * Created by 杨杰 on 2018/5/17 17:53.
 * 牛牛有一些字母卡片,每张卡片上都有一个小写字母,所有卡片组成一个字符串s。
 * 牛牛一直认为回文这种性质十分优雅,于是牛牛希望用这些卡片拼凑出一些回文串,但是有以下要求:
 1、每张卡片只能使用一次
 2、要求构成的回文串的数量最少
 牛牛想知道用这些字母卡片,最少能拼凑出多少个回文串。
 例如: s = "abbaa",输出1,因为最少可以拼凑出"ababa"这一个回文串
 s = "abc", 输出3,因为最少只能拼凑出"a","b","c"这三个回文串
 输入描述:
 输入包括一行,一个字符串s,字符串s长度length(1 ≤ length ≤ 1000).
 s中每个字符都是小写字母

 输出描述:
 输出一个整数,即最少的回文串个数。

 输入例子1:
 abc

 输出例子1:
 3
 */
public class 制造回文 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        if (s == null || s.length()==0) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0;i<s.length() ;i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            } else {
                hashMap.put(s.charAt(i), 1);
            }
        }
        int odd = 0;
        for (Integer i : hashMap.values()) {
            if (i % 2 == 1) {
                odd++;
            }
        }
        return odd;
    }
}
