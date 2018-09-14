package 校招2019.头条3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by James on 2018/9/9 10:23.
 */
public class Main33 {

    public static int total = 0;

    public static String[] temp = new String[4];

    public static void main(String[] args) {
        total = 0;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String ip = sc.nextLine();



        dfs(ip,0);
        System.out.println(total);
    }

    private static void dfs(String ip,int cur) {
        if (cur == 4) {
            int len = 0;
            for (int i = 0; i < 4; i++) {
                len += temp[i].length();
            }
            if (len != ip.length()) {
                return;
            }
            int i;
            for (i = 0; i < 4; i++) {
                if (Integer.parseInt(temp[i]) > 255) {
                    break;
                }
            }
            if (i == 4) {
                total++;
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int len = 0;
            for (int j = 0; j < cur; j++) {
                len += temp[j].length();
            }
            if ((len + i) <= ip.length()) {
                temp[cur] = ip.substring(len, (len + i));
                dfs(ip,cur + 1);
            }
        }
    }

}
