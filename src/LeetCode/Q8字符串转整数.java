package LeetCode;

/**
 * Created by 杨杰 on 2018/7/14 23:53.
 */
public class Q8字符串转整数 {
    public static int myAtoi(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        boolean negative = false;
        boolean start = false;
        int num = 0;
        for(int i=0;i<str.length();i++) {
            if ((str.charAt(i) != ' ') && !start ) {
                start = true;
                char c = str.charAt(i);
                if (c == '-') {
                    negative = true;
                } else if (c == '+') {
                    negative = false;
                } else if (c < '0' || c > '9') {
                    return 0;
                } else {
                    num = c - '0';
                }
            } else if (start && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                int temp = num;
                num = num * 10 + str.charAt(i) - '0';
                if (num / 10 != temp) {
                    if (negative) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            }else if (start && (str.charAt(i) < '0' || str.charAt(i) > '9')) {
                if (negative) {
                    return -num;
                } else {
                    return num;
                }
            }
        }
        if (negative) {
            return -num;
        } else {
            return num;
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }

    public int myAtoi2(String str) {
        str = str.trim();
        long result = 0;
        int digits = 0;
        int negativeMark = 1;

        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] < '0' || charArray[i] > '9') {
                if (i == 0 && charArray[0] == '-') {
                    negativeMark = -1;
                    continue;
                }
                if (i == 0 && charArray[0] == '+') {
                    continue;
                }
                break;
            }

            if (digits == 0 && charArray[i] == '0') {
                continue;
            }

            digits ++;
            if (digits > 12) {
                break;
            }

            result = result * 10 + (charArray[i] - '0');
        }

        result *= negativeMark;

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
