package LeetCode;

/**
 * Created by 杨杰 on 2018/7/17 0:00.
 */
public class Q9回文数 {
    public static boolean isPalindrome(int x) {
        String s = x + "";
        boolean isPa = true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }

    //最快
    public boolean isPalindrome2(int x) {
        StringBuffer sb = new StringBuffer(String.valueOf(x));
        String s = sb.toString();
        String reverse = sb.reverse().toString();
        if(s.equals(reverse))
            return true;
        return false;
    }
}
