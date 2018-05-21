package 牛客网.京东2019春招;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/21 23:59.
 * 对于一个字符串，能否从字符串中移除部分0个或多个字符使其变为回文串，并且牛牛认为空串不是回文串。
 * 总共有多少种移除方案。
 *
 * 牛客网上别人写的
 */
public class 回文串方案 {

    static int count = 0;

    public boolean isFalg(String s) {
        int len = s.length();
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            right--;
            left++;
        }

        return true;
    }

    public void traceBack(String s, ArrayList<Character> list) {
        int len = s.length();
        if (len == 0) {
            return;
        }
//System.out.println(list.toString());
        for (int i = 0; i < s.length(); i++) {
//System.out.println("index:"+i+"char:"+s.charAt(i));
            list.add(s.charAt(i));
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                builder.append(list.get(j));
            }
            if (isFalg(builder.toString())) {
                System.out.println(builder.toString());
                count++;
            }
            System.out.println("index:" + i);
            if (i + 1 < s.length())
                traceBack(s.substring(i + 1), list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        ArrayList<Character> list = new ArrayList<Character>();
        回文串方案 main = new 回文串方案();

        main.traceBack(s, list);
        String ss = "ABA";
        System.out.println(main.isFalg(ss));
        System.out.println(count);
    }
}
