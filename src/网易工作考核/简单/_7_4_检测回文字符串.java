package 网易工作考核.简单;

import java.util.Scanner;

public class _7_4_检测回文字符串 {

    public static void main(String[] args) {
        //        System.out.println('0'-'9');
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        char[] charArray = string.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            if (charToInt(charArray[left]) == -1) {
                left++;
            } else if (charToInt(charArray[right]) == -1) {
                right--;
            } else if (charToInt(charArray[left]) != charToInt(charArray[right])) {
                System.out.println("0");
                return;
            } else {
                left++;
                right--;
            }
        }
        System.out.println("1");

    }

    public static int charToInt(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c + 'a' - 'A';
        }
        if (c <= 'z' && c >= 'a') {
            return c;
        }
        if (c >= '0' && c <= '9') {
            return c;
        }
        return -1;
    }

}
