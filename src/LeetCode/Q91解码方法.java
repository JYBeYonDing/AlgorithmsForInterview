package LeetCode;

/**
 * Created by James on 2018/9/1 11:18.
 */
public class Q91解码方法 {
    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        char[] chars = s.toCharArray();

        int[] dp = new int[chars.length];

        dp[0] = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                if (chars[i - 1] == '0' || chars[i - 1] > '2') {
                    return 0;
                }
                dp[i] = (i>=2)? dp[i - 2] : 1;
            } else {
                int temp = 10 * (chars[i - 1] - '0') + chars[i] - '0';
                if (temp >= 10 && temp <= 26) {
                    dp[i] = dp[i - 1] + (i>=2? dp[i - 2]:1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[chars.length-1];

    }


    public static void main(String[] args) {
        Q91解码方法 fangfa = new Q91解码方法();
        System.out.println(fangfa.numDecodings("101"));
    }





    // 牛逼的代码
    public int numDecodings2(String s) {
        int[] dp = new int[s.length()+1];
        dp[1] = s.charAt(0)=='0'?0:1;
        dp[0] = 1;
        for(int i=2;i<=s.length();i++){
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            if(s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1)<'7')){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
