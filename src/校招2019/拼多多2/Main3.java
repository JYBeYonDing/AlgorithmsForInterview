package 校招2019.拼多多2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by James on 2018/8/30 20:04.
 *
 * 数学题，纸上算一下，找找规律就出来了，考试不要太紧张，其实有些题目不是很难。
 *
 * 1 300000
 *
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String[] strs = sc.nextLine().split(" ");

        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);

        int resA = 0;
        int resB = 0;

        a = a % b;

        HashMap<Integer, Integer> hashMap = new HashMap<>();



        int index = 0;
        while (a != 0) {
            int digit = a * 10 / b;
            a = a * 10 % b;
            if (digit > 0) {
                if ( !hashMap.containsKey(a)) {
                    hashMap.put(a, index);
                } else {
                    resA = hashMap.get(a);
                    resB = index - resA;
                    System.out.println(resA + " " + resB);
                    return;
                }
            }

            index++;
        }

        System.out.println(index + " " + 0);
    }
}