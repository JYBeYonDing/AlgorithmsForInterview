package org.example.simple;

import java.util.*;

/**
 * 去除重复字母
 * 分数 30
 * 作者 
 * 单位 
 * 给你一个字符串 s ，请你去除字符串中重复的字符，使得每个字符只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 输入格式:
 * 输入一个字符串，字符串的长度小于1000。字符内容是ASCII码，ASCII码定义了128个字符，包括控制字符（例如换行符、制表符、退格等）和可显示的字符（包括数字、字母、标点符号和一些特殊字符）。
 *
 * 输出格式:
 * 输出处理后的字符串
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * abecbcd
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * abecd
 */
public class Simple28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        //字符计数
        Map<Character, Integer> charCntMap = new HashMap<>();
        for(char c : str.toCharArray()){
            int cnt = charCntMap.getOrDefault(c, 0);
            charCntMap.put(c, cnt + 1);
        }

        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            //空栈
            if(stack.isEmpty()) {
                stack.push(c);
                set.add(c);
                charCntMap.put(c, charCntMap.get(c) - 1);
                continue;
            }

            //字母已经出现过，则最大可能就是弹出到这个字符为止，但是无法找回已经弹出的字符，所以先判断是否在栈里
            //忽略这次出,可能弹不到这个字符其他字符就不够了
            if(set.contains(c)) {
                charCntMap.put(c, charCntMap.get(c) - 1);
                continue;
            }

            //弹出到字符递增为止，且被弹出的字符后面还有
            while(!stack.isEmpty() && stack.peek() - c >= 0 && charCntMap.get(stack.peek()) > 0) {
                char e = stack.pop();
                set.remove(e);
            }

            //放入当前字符
            stack.push(c);
            set.add(c);
            charCntMap.put(c, charCntMap.get(c) - 1);
        }

        int i = stack.size() - 1;
        char[] result = new char[stack.size()];
        while(!stack.isEmpty()) {
            result[i--] = stack.pop();
        }

        System.out.println(new String(result));
    }
}
