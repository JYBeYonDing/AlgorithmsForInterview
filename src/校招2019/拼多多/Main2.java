package 校招2019.拼多多;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/8/5 18:30.
 * abcdefghijklmnop
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String str = scanner.nextLine();
        int len = str.length();
        int res = 0;
        for(int end = 1;end<len;end++) {
            //以end为分界，str.substring(0, end);str.substring(end);
            int sizeA = differentType(str.substring(0, end));
            int sizeB =differentType(str.substring(end));
            res += sizeA * sizeB;
        }
        System.out.println(res);
    }

    private static int differentType(String str) {
        if (str.length() == 1) {
            return 1;
        }
        int len = str.length();
        if (str.charAt(0) == '0' && str.charAt(len - 1) == '0') {
            return 0;
        }
        if (str.charAt(0) == '0' && str.charAt(len - 1) != '0') {
            return 1;
        }
        if (str.charAt(0) != '0' && str.charAt(len - 1) == '0') {
            return 1;
        }
        return len;
    }
}
