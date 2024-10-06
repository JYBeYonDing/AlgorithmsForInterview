package 网易工作考核.简单;

import com.alibaba.fastjson2.JSON;

import java.util.Scanner;

public class _7_2大山的数目 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] map = null;
        int m = in.nextInt();
        int n = in.nextInt();
        if(m <= 0 || n <= 0){
            System.out.println(0);
        }
        map = new int[m][n];
        int result = 0;
        int left = 0;
        int up = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
                if (i - 1 >= 0) {
                    up = map[i - 1][j];
                }
                if (j - 1 >= 0) {
                    left = map[i][j - 1];
                }
                if (up == 0 && left == 0 && map[i][j] == 1) {
                    result++;
                }
                left =0;
                up =0;
            }
        }
        System.out.println(result);

        //        System.out.println(JSON.toJSONString(map));

    }

}
