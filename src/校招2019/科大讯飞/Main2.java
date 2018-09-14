package 校招2019.科大讯飞;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/7 16:47.
 *
 6
 1 2 3 4 5 6
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = sc.nextInt();

//        int[] nums = new int[n];

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();

            nums.add(sc.nextInt());
        }

        boolean flag = true;

        int res = 0;

        while (flag) {
            ArrayList<Integer> newList = new ArrayList<>();
            flag = false;

            int pre = nums.get(0);
            newList.add(pre);
            for (int i = 1; i < nums.size(); i++) {

                int temp = nums.get(i);
                if (temp > pre) {
                    newList.add(temp);

                    flag = true;
                }

                pre = temp;
            }
            if (nums.size() == newList.size()) {
                break;
            }
            res++;
            nums = newList;
        }


        System.out.println(res);
    }
}