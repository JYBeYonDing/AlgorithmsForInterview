package 计蒜客.计蒜客0520;

import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/5/20 16:16.
 */
public class 找房均价计算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] res = new String[n];
        for(int i = 0 ;i<n ;i++) {
            String[] s = sc.nextLine().split("\\.");
            String X = s[0];
            String Y = s[1];
//            System.out.println(X);
//            System.out.println(Y);
            if (soulution(Y)) {
                res[i] = addOne(X);
            } else {
                res[i] = X;
            }
        }
        for (String s : res) {
            System.out.println(s);
        }
    }

    private static String addOne(String x) {
        long xx = Long.parseLong(x)+ 1;
        return xx+"";
    }

    private static boolean soulution(String y) {
        char[] ys = y.toCharArray();
        for(int i=y.length()-1;i>0;i--) {
            if (ys[i] >= '5') {
                ys[i-1]++;
            }
        }
        if (ys[0] >= '5') {
            return true;
        } else {
            return false;
        }
    }
}
