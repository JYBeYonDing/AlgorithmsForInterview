package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/1 10:57.
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class t53正则表达式匹配 {
    public static void main(String[] args) {
        char[] str = "aaa".toCharArray();
        char[] pattern = "ab*a".toCharArray();
        System.out.println(match(str, pattern));
    }
    public static boolean match(char[] str, char[] pattern) {
        return matchRec(str, pattern, 0, 0);
    }

    private static boolean matchRec(char[] str, char[] exp, int si, int ej) {
        if (ej == exp.length) {// 当exp耗尽了，str必须也耗尽才会返回true
            return si == str.length;
        }
        // 如果j上还有字符，考查j+1的情况，后面的位置不是*
        if (ej + 1 == exp.length || exp[ej + 1] != '*') {
            return si != str.length //如果i==str.length,说明正则表达式没有匹配完，而字符串已经没了，则一定没有匹配成功
                    && (exp[ej] == str[si] || exp[ej] == '.')
                    && matchRec(str, exp, si + 1, ej + 1);
        }
        // 下面部分都是j+1的位置都为'*'的情况
        // exp的j+1位置，不仅有字符而且字符是'*'
        while (si != str.length && (exp[ej] == str[si] || exp[ej] == '.')) {
            if (matchRec(str, exp, si, ej + 2)) {
                return true;
            }
            si++;
        }
        return matchRec(str, exp, si, ej + 2);// 直接将*和前一个字符看成0个字符

    }
}
