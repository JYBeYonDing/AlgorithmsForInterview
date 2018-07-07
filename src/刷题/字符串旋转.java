package 刷题;

/**
 * Created by 杨杰 on 2018/7/7 21:03.
 */
/**
 * 问题描述：
 *  给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串
 *  的尾部，使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间
 *  复杂度为 O(1)。
 *
 * 思路：
 *  三步旋转法：(X^TY^T)^T=YX
 *
 */
public class 字符串旋转 {
    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(rotateString(s, 3));
    }

    /**
     * @param s 字符串
     * @param n 前n个字符移到串的最后
     */
    private static String rotateString(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    /**
     * 将字符串翻转
     *
     * @param chars       输入串
     * @param start     字符串中的起始索引(包括)
     * @param end       字符串中的终止索引(包括)
     * @return          翻转后的串
     */
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
