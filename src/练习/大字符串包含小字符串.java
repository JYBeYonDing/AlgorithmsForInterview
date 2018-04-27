package 练习;

/**
 * Created by 杨杰 on 2018/4/27 10:57.
 */
public class 大字符串包含小字符串 {
    public static void main(String[] args) {
        String test1 = "a";
        System.out.println(answer(test1));

        String test2 = "aa";
        System.out.println(answer(test2));

        String test3 = "ab";
        System.out.println(answer(test3));

        String test4 = "abcdabcd";
        System.out.println(answer(test4));

        String test5 = "abracadabra";
        System.out.println(answer(test5));

    }

    private static String answer(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() == 1) {
            return str + str;
        }
        int[] nexts = new int[str.length()+1];
        nexts[0] = -1;
        nexts[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < nexts.length) {
            if (str.charAt(pos - 1) == str.charAt(cn)) {
                nexts[pos++] = ++cn;
            } else if (cn == 0) {
                nexts[pos++] = 0;
            } else {
                cn = nexts[cn];
            }
        }
        return str + str.substring(nexts[str.length()]);
    }
}
