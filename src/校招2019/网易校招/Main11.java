package 校招2019.网易校招;

/**
 * Created by James on 2018/9/8 16:41.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String str = sc.nextLine();

        int res = 0;

        int len = str.length();
        int end = 1;
        for (int i =0;i < len;i++) {
            char c = str.charAt(i);
            if (i < len-1 && c != str.charAt(i + 1)) {
                end = end + 1;
            } else {
                if (res < end) {
                    res = end;
                }
                end = 1;
            }
        }


        System.out.println(res);
    }

    public static void main2(String[] args) {
        int pre = 0;
        Scanner sc = new Scanner(System.in);
        int end = 1;
        String str = sc.next();
        int idx = 0;
        int len = str.length();
        while (idx < len) {
            char c1 = str.charAt(idx);
            if (idx + 1 < len && c1 - str.charAt(idx + 1) != 0) {
                end = end + 1;
            } else {
                if (pre < end) {
                    pre = end;
                }
                end = 1;
            }
            idx = idx + 1;
        }
        System.out.println(pre);

    }
}
