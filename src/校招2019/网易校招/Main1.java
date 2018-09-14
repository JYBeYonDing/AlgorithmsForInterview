package 校招2019.网易校招;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/8 15:53.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String str = sc.nextLine();


        int bs = 0;
        int ws = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'b') {
                bs++;
            } else {
                ws++;
            }
        }

        if (bs == ws) {
            System.out.println(2 * bs);
        } else {

            System.out.println(Math.min(bs,ws)*2+1);
        }


    }
}