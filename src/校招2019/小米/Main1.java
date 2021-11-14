package 校招2019.小米;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/27 14:45.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = Integer.parseInt(sc.nextLine());

        HashSet<Integer>[] sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            String[] strings = sc.nextLine().split(" ");
            sets[i] = new HashSet<Integer>();
            HashSet<Integer> tempSet = sets[i];
            boolean flag = true;
            for (int j = 0; j < strings.length; j++) {

                Integer num = Integer.parseInt(strings[j]);

                if (flag) {
                    flag = false;
                    for (int k = 0; k < i && sets[k]!=null; k++) {
                        if (sets[k].contains(num)) {
                            sets[k].addAll(tempSet);
                            tempSet = sets[k];
                            sets[i] = null;
                        }
                    }
                }

                tempSet.add(num);
            }
        }

        int resNum = 0;
        int sizeMax = 0;

        for (int i = 0; i < n; i++) {
            if (sets[i] != null) {
                resNum++;
                sizeMax = Math.max(sizeMax, sets[i].size());
            }
        }


        System.out.println(resNum);
        System.out.println(sizeMax);
    }
}