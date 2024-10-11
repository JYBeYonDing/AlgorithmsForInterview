package 网易工作考核.简单;

import java.util.Scanner;


public class _7_15_最长回文子串 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i && i + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    if (2 * j + 1 > max) {
                        max = 2 * j + 1;
                        res = s.substring(i - j, i + j + 1);
                    }
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i && i + j + 1 < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                    if (2 * j + 2 > max) {
                        max = 2 * j + 2;
                        res = s.substring(i - j, i + j + 2);
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(res);
    }


}
