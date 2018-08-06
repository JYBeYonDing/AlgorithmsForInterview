package 校招2019.拼多多;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by 杨杰 on 2018/8/5 18:30.
 * abcdefghijklmnop
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String str = scanner.nextLine();
        int len = str.length();
        int K = len/4;
        System.out.println(str.substring(0,K+1));
        int left = len - 1;
        int right = K + 1;
        StringBuilder space = new StringBuilder();
        for(int i=0;i<K-1;i++) {
            space.append(' ');
        }
        for(int i=0;i<K-1;i++) {
            System.out.print(str.charAt(left--));
            System.out.print(space);
            System.out.println(str.charAt(right++));
        }
        String third = str.substring(K * 2, K * 3 + 1);
        third = new StringBuilder(third).reverse().toString();
        System.out.println(third);
    }
}
