package 校招2019.头条3;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/9 10:21.
 */
public class Main3 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String ip = sc.nextLine();

        System.out.println(solution(ip));

    }



    public static int solution(String s) {
        List<String> res = new ArrayList<>();
        helper(s, "", res, 0);
        return res.size();
    }

    public static void helper(String s, String tmp,
                              List<String> res, int n) {

        if (s.length() > 3 * (4 - n))
            return;
        if (n == 4) {
            if (s.length() == 0)

                res.add(tmp.substring(0, tmp.length() - 1));
            return;
        }
        for (int k = 1; k <= 3; k++) {

            if (s.length() < k)
                break;
            int val = Integer.parseInt(s.substring(0, k));

            if (val > 255 || k != String.valueOf(val).length())
                continue;

            helper(s.substring(k), tmp + s.substring(0, k)
                    + ".", res, n + 1);
        }
    }
}