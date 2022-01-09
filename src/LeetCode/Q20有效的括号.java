package LeetCode;

import java.util.ArrayDeque;

/**
 * @author 杨杰(yangjie7 @ corp.netease.com)
 * @date 2022/1/9 15:23
 */
public class Q20有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("{}"));
    }

    public static boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            i++;
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else if(c==')'){
                if (!stack.isEmpty() && '(' == stack.pop()) {
                    continue;
                }else{
                    return false;
                }
            }else if(c==']'){
                if (!stack.isEmpty() && '[' == stack.pop()) {
                    continue;
                }else{
                    return false;
                }
            }else if(c=='}'){
                if (!stack.isEmpty() && '{' == stack.pop()) {
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
