package 剑指Offer;

/**
 * Created by 杨杰 on 2018/6/1 17:22.
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class t54表示数值的字符串 {
    public static void main(String[] args) {
        char[] str = "12.4e8.9".toCharArray();
        System.out.println(solution(str));
    }

    /**
     * 正则表达式
     */
    public boolean isNumeric2(char[] str) {
        String s = String.valueOf(str);
        //return s.matches("[+-]?[0-9]*(.[0-9]*)?([eE][+-]?[0-9]+)?");
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }

    /**
     * 牛客网别人的参考答案
     * 思路很清晰
     */
    public static boolean solution(char[] str) {
//        链接：https://www.nowcoder.com/questionTerminal/6f8c901d091949a5837e24bb82a731f2
//        来源：牛客网

        // 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) return false; // e后面一定要接数字
                if (hasE) return false; // 不能同时存在两个e
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') // 不合法字符
                return false;
        }
        return true;
    }














//    链接：https://www.nowcoder.com/questionTerminal/6f8c901d091949a5837e24bb82a731f2
//    来源：牛客网

    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str.length < 1)
            return false;

        boolean flag = scanInteger(str);// 存在整数，并扫完整数部分

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index; //是否存在整数
    }
}
