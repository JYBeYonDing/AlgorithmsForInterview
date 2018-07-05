package 牛客网.华为2018届;

/**
 * Created by 杨杰 on 2018/6/27 16:50.
 */
public class 整数反转求和 {
    public static void main(String[] args) {
        int a = 123;
        int b = 456;
        System.out.println(reverseAdd(a,b));
    }

    private static int reverseAdd(int a, int b) {
//        String s1 = reverse(a + "");
//        String s2 = reverse(b + "");
//        return Integer.parseInt(s1) + Integer.parseInt(s2);
        int r1 = reverse(a);
        int r2 = reverse(b);
        return r1 + r2;
    }

    private static int reverse(int num) {
        int res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num = num / 10;
        }
        return res;
    }

//    private static String reverse(String string) {
//        char[] chars = string.toCharArray();
//        int start = 0;
//        int end = chars.length-1;
//        while (start < end) {
//            char temp = chars[start];
//            chars[start] = chars[end];
//            chars[end] = temp;
//            start++;
//            end--;
//        }
//        return new String(chars);
//    }
}
