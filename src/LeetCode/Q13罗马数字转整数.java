package LeetCode;

import java.util.HashMap;

/**
 * Created by 杨杰 on 2018/7/22 11:59.
 */
public class Q13罗马数字转整数 {
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static {
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);
        hashMap.put("CM", 900);
        hashMap.put("CD", 400);
        hashMap.put("XC", 90);
        hashMap.put("XL", 40);
        hashMap.put("IX", 9);
        hashMap.put("IV", 4);
    }


    /**
     * 因为输入的一定是罗马数字，那么我们只要考虑两种情况即可：
     第一，如果当前数字是最后一个数字，或者之后的数字比它小的话，则加上当前数字
     第二，其他情况则减去这个数字
     */
    public static int romanToInt2(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);
        int num = 0;
        for(int i = 0;i<s.length();i++) {
            int temp = charMap.get(s.charAt(i));
            if (i == s.length() - 1 || temp >= charMap.get(s.charAt(i + 1))) {
                num += temp;
            } else {
                num -= temp;
            }
        }
        return num;
    }

    /**
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        String[] strs = s.split("");
        int num = 0;
        for(int i=0;i<s.length();) {
            if (i < s.length() - 1) {
                if (hashMap.get(strs[i]) < hashMap.get(strs[i + 1])) {
                    num += hashMap.get(strs[i] + strs[i + 1]);
                    i += 2;
                } else {
                    num += hashMap.get(strs[i]);
                    i++;
                }
            }else {
                num += hashMap.get(strs[i]);
                i++;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt2("MCMXCIV"));
    }
}
