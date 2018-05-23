package 牛客网.京东2019春招;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/21 23:59.
 * 对于一个字符串，能否从字符串中移除部分0个或多个字符使其变为回文串，并且牛牛认为空串不是回文串。
 * 总共有多少种移除方案。
 *
 * https://www.geeksforgeeks.org/count-palindromic-subsequence-given-string/
 *
 * Find how many palindromic subsequence (need not necessarily be distinct)
 * can be formed in a given string. Note that the empty string is not considered as a palindrome.
 * Examples:
 * Input : str = "abcd"
 * Output : 4
 * Explanation :- palindromic  subsequence are : "a" ,"b", "c" ,"d"
 * <p>
 * Input : str = "aab"
 * Output : 4
 * Explanation :- palindromic subsequence are :"a", "a", "b", "aa"
 * <p>
 * Input : str = "aaaa"
 * Output : 15
 */
public class 回文串方案 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solutionDP(s));
    }

    private static int solutionDP(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int length = 2; length < len + 1; length++) {// 考虑的长度逐渐增大
            for (int l = 0; l <len; l++) {// 左边界
                int r = l + length - 1;// 右边界
                if (r < len) {
                    if (s.charAt(l) == s.charAt(r)) {// 这里思考困难的话，举几个例子就清楚了
                        dp[l][r] = dp[l + 1][r] + dp[l][r - 1] + 1;
                    } else {
                        dp[l][r] = dp[l + 1][r] + dp[l][r - 1] - dp[l + 1][r - 1];
                    }
                }
            }
        }

        return dp[0][len - 1];
    }


//// * 牛客网上别人写的
////https://www.nowcoder.com/discuss/75214
//// 没看懂
//    static int count = 0;
//
//    public boolean isFalg(String s) {
//        int len = s.length();
//        int left = 0;
//        int right = len - 1;
//        while (left <= right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                return false;
//            }
//            right--;
//            left++;
//        }
//
//        return true;
//    }
//
//    public void traceBack(String s, ArrayList<Character> list) {
//        int len = s.length();
//        if (len == 0) {
//            return;
//        }
////System.out.println(list.toString());
//        for (int i = 0; i < s.length(); i++) {
////System.out.println("index:"+i+"char:"+s.charAt(i));
//            list.add(s.charAt(i));
//            StringBuilder builder = new StringBuilder();
//            for (int j = 0; j < list.size(); j++) {
//                builder.append(list.get(j));
//            }
//            if (isFalg(builder.toString())) {
//                System.out.println(builder.toString());
//                count++;
//            }
//            System.out.println("index:" + i);
//            if (i + 1 < s.length())
//                traceBack(s.substring(i + 1), list);
//            list.remove(list.size() - 1);
//        }
//    }


    //********************************************************************************
    // https://www.nowcoder.com/discuss/73194
    //另一位牛客网友的答案，这代码暂时有问题
//    private static int count_1(String s) {
//        int lesStr = s.length();
//        int cnt1 = 1;
//        int cen = (lesStr - 1) / 2;
//        int i = 0;
//        while (i <= cen) {
//            if (s.charAt(i) != s.charAt(lesStr - 1)) {
//                cnt1 = 0;
//                break;
//            }
//            i++;
//        }
//        return cnt1;
//    }
//
//    private static int solution(String s) {
//        int lenStr = s.length();
//        int cout_1_1 = 0;
//        cout_1_1 += count_1(s);
//        for(int i=0;i<lenStr;i++) {
//            String s_true = s.substring(0, i) + s.substring(i + 1);
//            cout_1_1 += count_1(s_true);
//            for(int j=i+1;j<lenStr;j++) {
//                for (int i1=j+1;i1<lenStr+1;i1++) {
//                    String s_true2 = s.substring(0, i) + s.substring(i + 1, j - (i + 1)) + s.substring(i1);
//                    if (!s_true2.isEmpty()) {
//                        cout_1_1 += count_1(s_true2);
//                    }
//                }
//            }
//        }
//        return cout_1_1;
//    }
}
