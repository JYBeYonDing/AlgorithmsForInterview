package 校招2019.华为;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/8/29 18:35.
 *
 *
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String str = sc.nextLine();

        int res = solution(str);

        System.out.println(res);

    }

    private static int solution(String str) {
        if (str==null || str.length() == 0) {
            return 0;
        }
        int res = 0;
        int tempNum;
        int i = 0;
        while (i < str.length()) {
            tempNum = 0;
            int numOfNegative =0;
            while (i < str.length() && str.charAt(i) == '-') {
                numOfNegative++;
                i++;
            }
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                tempNum = tempNum * 10 + (str.charAt(i) - '0');
                i++;
            }
            if (numOfNegative % 2 == 1) {
                tempNum = -tempNum;
            }
            res += tempNum;
            i++;
        }
        return res;
    }
}