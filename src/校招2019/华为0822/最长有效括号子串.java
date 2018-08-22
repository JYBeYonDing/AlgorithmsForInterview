package 校招2019.华为0822;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by James on 2018/8/22 19:45.
 */
public class 最长有效括号子串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution2(str));
    }

    /**
     * 网上找的答案
     * @param s
     * @return
     */
    private static int  solution(String s) {

        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


    private static int  solution2(String s) {
        int[] dp = new int[s.length()];//dp[i]表示以s[i]结尾的有效括号子串长度
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                dp[i] = 0;
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    int last = stack.pop();
                    if (last == 0) {
                        dp[i] = i+1;
                    } else {
                        dp[i] = dp[last-1] + i-last+1;
                    }
                } else {
                    dp[i] = 0;
                }
            } else {
                stack.clear();
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
