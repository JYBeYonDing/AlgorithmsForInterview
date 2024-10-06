package 网易工作考核.简单;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _7_5_同构字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str= in.nextLine();
        String[] strs = str.split(",");
        char[] s = strs[0].toCharArray();
        char[] t = strs[1].toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            if (map.containsKey(s[i])) {
                if (map.get(s[i]) != t[i]) {
                    System.out.println("0");
                    return;
                }
            }else{
                map.put(s[i], t[i]);
                if (set.contains(t[i])) {
                    System.out.println("0");
                    return;
                }
                set.add(t[i]);
            }
        }
        System.out.println("1");
    }
}
