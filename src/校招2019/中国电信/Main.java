package 校招2019.中国电信;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/10 10:42.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String str = sc.nextLine();

        int count[] = new int[26];
        for (int i = 0; i < count.length; i++) {
            count[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            count[temp - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            min = Math.min(min, count[i]);
        }
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (count[temp - 'a'] != min) {
                System.out.print(temp);
            }
        }
        System.out.println();
    }

}