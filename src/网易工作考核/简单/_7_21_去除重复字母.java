package 网易工作考核.简单;

import java.util.Scanner;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字符，使得每个字符只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 输入格式:
 * 输入一个字符串，字符串的长度小于1000。字符内容是ASCII码，ASCII码定义了128个字符，包括控制字符（例如换行符、制表符、退格等）和可显示的字符（包括数字、字母、标点符号和一些特殊字符）。
 * <p>
 * 输出格式:
 * 输出处理后的字符串
 * <p>
 * 输入样例:
 * 在这里给出一组输入。例如：
 * <p>
 * abecbcd
 * 输出样例:
 * 在这里给出相应的输出。例如：
 * <p>
 * abecd
 */
public class _7_21_去除重复字母 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] charArray = s.toCharArray();
        int[] count = new int[128];
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            count[c]++;
        }
        boolean[] removed = new boolean[charArray.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if(removed[i]){
                continue;
            }
            char next = Character.MAX_VALUE;
            for (int j = i + 1; j < charArray.length; j++) {
                if (!removed[j]) {
                    next = charArray[j];
                    break;
                }
            }
            char c = charArray[i];
            if (c > next && count[c] > 1) {
                removed[i] = true;
                count[c]--;
            }else{
                sb.append(c);
                count[c] = 0;
            }
        }
        System.out.println(sb);
    }


}
