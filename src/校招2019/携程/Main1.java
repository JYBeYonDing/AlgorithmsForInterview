package 校招2019.携程;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/4 19:30.
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        long num = sc.nextLong();
        int res = 0;
        while (num != 0) {
            res++;
            num= num & (num-1);
        }

        System.out.println(res);

    }
}